package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.controller.RequestMapping;
/*
 *   1. DispatcherServlet
 *      => WEB_INF => application에 있는 클래스명을 읽는다
 *      => 대기
 *      => init은 서버 구동시 한번만 수행
 *   2. 사용자 접속시 : service()메소드 호출
 *      => 사용자가 URL전송
 *         main/main.do
 *      => 전체 XML에 등록된 모델을(클래스값) 읽음
 *           => @RequestMapping을 찾아서 아래에 있는 main_main()메소드 호출
 * 
 * 
 */
public class MainModel {
	@RequestMapping("main/main.do")
	public String main_main(HttpServletRequest request, HttpServletResponse response)
	{
		request.setAttribute("main_jsp", "../main/home.jsp");
		return "../main/main.jsp";
	}
}
