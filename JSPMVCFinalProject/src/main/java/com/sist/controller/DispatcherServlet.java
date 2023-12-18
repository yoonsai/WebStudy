package com.sist.controller;

import java.io.*;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.util.*;
/*
 *   XML파싱
 *   Annotation => 클래스 찾기 => 메소드 찾기
 *   => MVC동작
 *      1. 요청 (jsp파일에서 요청) => <a>, <form>
 *         => DispatcherServlet(Controller) => 이미 제작
 *         => @WebServlet("*.do")
 *                        ====== list.do, insert.do
 *                               ====     ====== 구분자
 *                  | 서버에서 받을 수 있는 부분
 *                    URI,URL => 서버 연결은 주소란
 *                    => URI를 이용해서 => Model찾기
 *      2. DispatcherServlet (Controller)
 *         역할
 *         == 요청을 받는다 (브라우저 -> 요청을 받는 파일 => JSP/Servlet)
 *                       JSP ===> View(화면출력)
 *                       Servlet => 연결 (자바/HTML)
 *                                  ==============
 *         === 분리된 자바를 찾는다 ==> 연결
 *      3. MVC목적
 *         1) 보안 (JSP => 배포 (소스를 통으로 전송)) => 유지보수
 *         2) 여러명이 동시 개발
 *            Front - BACK
 *         3) JSP의 단점 : 확장성, 재사용, 변경
 *            ======== 사이트 제작시 버린다
 *         4) 신규사원 확장
 *            => MVVM , MVVP
 *      4. 소프트웨어 => 회귀
 *      =================
 *      
 *      5. 동작
 *                   request
 *      JSP(링크,버튼) ======= DispatcherServlet
 *                              ===> Model(DAO와 연동)
 *                                  ======
 *                                  request에 결과값 담기
 *                                  => setAttribute()
 *             DispatcherServlet<===
 *              => request 필요하다 => request를 jsp로 전송
 *                   JSP로 request를 전송 메소드
 *                   => forward(request,response)
 *              => request 필요없다 => 화면만 이동
 *                   화면만 변경하는 메소드
 *                   => sendRedirect(파일명)
 *                   => 회원가입, 로그인, 글쓰기...
 *                   => INSERT/DELETE/UPDATE
 *    
 *     DispatcherServlet은 수정x => 고정한다 => .jar
 *     
 *      1. 설정 파일
 *        Spring : application-context.xml
 *                 application-datasource.xml
 *                 application-security.xml
 *                 => 태그 속성은 Spring에서 제공하는 것만 사용이 가능
 *                 => dtd
 */

import java.net.*;
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> clslist=new ArrayList<String>();

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//1. XML의 경로 읽기 => XML안에 클래스 등록
		try {
			URL url=this.getClass().getClassLoader().getResource(".");
			File file=new File(url.toURI());
			//System.out.println(file.getPath());
			String path=file.getPath();
			path=path.replace("\\",File.separator);
			System.out.println(path);
			
			//File.separator => 프로그램이 실행중인 os에 해당하는 구분자를 리턴
			//window => \\, Mac => /
			
			path=path.substring(0,path.lastIndexOf(File.separator));
			//C:\webDev\webStudy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\JSPMVCFinalProject\WEB-INF\classes
			//System.out.println(path);
			path=path+File.separator+"application.xml";
			//System.out.println(path);
			//------------------------------------------------ xml 파일 경로 찾아줌
			
			
			//------------------------------------------------ xml 문서를 파싱해서 java로 데이터 옮겨오기
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			// HTML, XML, WML, HDML... 파일 파싱 
			//DocumentBuilderFactory 클래스로 XML 문서에서 DOM 오브젝트 트리를 생성하는 parser를 얻을 수 있다고 한다.
			DocumentBuilder db=dbf.newDocumentBuilder();
			//파서기
			//DocumentBuilder 클래스는 XML 문서에서 DOM Document instance를 얻는다고 한다. 
			Document doc=db.parse(new File(path));
			//1. 루트 (beans) => 테이블명
			// 파싱 : 구문 분석 데이터를 조립해서 원하는 데이터를 빼내는 프로그램을 하는것
			Element root=doc.getDocumentElement();
			// getDocumentElement() 메서드를 사용하면 가장 첫번째 요소(root 요소)를 가져올 수 있음 => beans
			
			//System.out.println(root.getTagName()); => beans
			// 2. 같은 태그를 묶어서 제어
			
			NodeList list=root.getElementsByTagName("bean");
			for(int i=0;i<list.getLength();i++)
			{
				Element bean=(Element)list.item(i);
				String id=bean.getAttribute("id");
				String cls=bean.getAttribute("class");
				//System.out.println(id+":"+cls);
				
				clslist.add(cls); //클래스 값(com.sist.model.BoardModel) 저장
				
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri=request.getRequestURI();
		// URL => http://localhost/JSPMVCFINALProject/board/list.do
		// URI => /JSPMVCFINALProject/board/list.do
		// ContectPath = /JSPMVCFINALProject
		// uri.substring(request.getContextPath().length()+1) => board/list.do
		uri=uri.substring(request.getContextPath().length()+1);
		System.out.println(uri);
		try {
			for(String cls:clslist) 
			{
				Class clsName=Class.forName(cls);
				//클래스 정보를 읽어서 clsName에 저장
				Object obj=clsName.getDeclaredConstructor().newInstance();
				// 객체 생성 (메모리 할당) == 리플렉션
				Method[] methods=clsName.getDeclaredMethods();
				// MainModel 등 각각의 모델 클래스에 있는 메소드를 methods 배열에 저장
				
				for(Method m:methods)
				{
					RequestMapping rm=m.getAnnotation(RequestMapping.class);
					//RequestMapping.class => RequestMapping클래스
					//m(메소드)의 RequestMapping 어노테이션 값을 rm에 저장 == seoul/location.do
					//@RequestMapping("seoul/location.do")
					if(rm.value().equals(uri))
					{
						String jsp=(String)m.invoke(obj, request, response);
						// m.invoke(obj, request, response); => obj(클래스 객체)의 메소드 실행
						//               ================= 메소드 인자값
						// m.invoke(obj, request, response); ==> 메소드 리턴값 "../main/main.jsp"
						if(jsp==null) // void => ajax
						{
						   return;	
						}
						else if(jsp.startsWith("redirect:"))
						{
							// return "redirect:list.do"
							jsp=jsp.substring(jsp.indexOf(":")+1);
							response.sendRedirect(jsp);
						}
						else {
							RequestDispatcher rd=request.getRequestDispatcher(jsp);
							rd.forward(request, response);
							// DispatcherServlet으로 붙여넣기 
							// DispatcherServlet을 실행하는 것 (*.do = DispatcherServlet)
						}
						return;
					}
				}
			}
		}catch(Exception e) {}
	}

}
