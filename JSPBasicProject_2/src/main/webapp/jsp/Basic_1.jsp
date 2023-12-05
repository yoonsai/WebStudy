<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<%--
      1. 동작
         1) 요청 : http://localhost/JSPBasicProject_2/jsp/Basic_1.jsp
                  => Basic_1.jsp을 찾아서 실행 결과를 보여달라
                  => 주소창
         2) 웹서버에서 요청을 받는다 
            ===== HTML/XML/JSON => 자체처리
            ===== .jsp/servlet => 처리가 불가능
         3) jsp => WAS(Web Application Server) => 톰캣
                   jsp, servlet 번역(자바처리) => jsp엔진
         4) 톰캣 
            = jsp ==> 자바파일로 변경
              basic_1.jsp ==> basic_1_jsp.java
              ===========
               | 코딩된 내용
                 public void _jspService(request,response)
                 {
                    session, pageContext, page, exception
                    out, application, config ==> 생성
                    ======================== 내장 객체
                    ====================================
                     jsp에서 코딩 내용을 첨부 = _jspService() 메소드
                    ====================================
                 }
            = 컴파일 => basic_1_jsp.class => 서블릿
            => 실행 => out.write("<html>")
                       => 출력버퍼에 출력
                       => ===== html을 브라우저에서 읽어서 출력
            *** html/css/javascript를 사용하기 편리하게 만들어져 있다
                html태그앞에 out.write()가 생략
                
                 
      2. 지시자 => 설정
         page : jsp파일에 대한 정보
           사용법
           <%@ page 속성=값 속성=값%>
                    속성은 지정되어 있다
                    속성은 한번만 사용이 가능 => import는 여러번 사용이 가능
                    => XML형식으로 만들어져 있다
                       ======
                       문법이 어렵다 (1.대소문자를 구분, 2.값을 설정할떄 반드시"")
                    => info : 파일에 대한 설명 
                       info="2023-12-05 홍길동 수정"
                       info="게시판 수정 파일"
                    => contextType : 브라우저 전송 => 어떤 형식인지 알려준다
                       contextType="text/html;charset=UTF-8" => html형식
                       contextType="text/xml;charset=UTF-8" => xml형식
                                             ==============
                                             UTF-8 / EUC-KR
                                                        | window에서만
                                               | 운영체제 호환
                       ** Git (공유) => UTF-8
                       ** MAC / Window => 경로명 => 호환
                       File.separator  '\\'
                       ContextType = "text/plain;charset=UTF-8" => json형식
                                      ==========
                                         | Vue/React
                       => VO => {}
                       => List => []
                       => Ajax => JSON을 전송 => simple-json.jar
                       ==============       => jackson
                     = import : 라이브러리 불러올때 사용
                       import="  ,  ,  "
                       <%@ page import=""%>
                       <%@ page import=""%>
                       <%@ page import=""%>
                       <%@ page import=""%>
                     = buffer : 8kb
                        => 증가가 가능 (HTML이 전체 인식이 안되는 경우)
                        => HTML을 저장하는 메모리 공간 : 출력 버퍼
                                                  => 사용자당 한개만 생성
                                                  => 브라우저에서 전체 읽기를 하면 => 버퍼를 비워준다
                     = errorPage : 한개만 설정이 가능
                     = isErrorPage : 종류별로 처리가 가능
                        = 404 : 파일이 없는 경
                        = 500 : 자바 컴파일시 오류
                        = 403 : 접근 거부 ==> Spring(Security) => 암호/벅호, 권한부여
                        = 400 : GET/POST => 전송방식
                                doGet / doPost
                                => service()
                                => @GetMapping
                                   @PosteMapping
                        = 412 : 잘못된 전송 (bad request)
                                => [] => String 
                    =================================== 에러시 처리                                           
         include : jsp안에 다른 jsp를 포함
                   <%@ include file=""%> : 사용빈도가 거의 없다
                   => 정적
                   <jsp:include page=""> : 동적
                   따로 컴파일==>html만 추가
         taglib : jsp에서 자바문법(제어문,변수선언,메소드호출)
                 ============== 태그형으로 제작
                 jsp는 view역할만 수행
                      ===== 화면 ui => 보안에 취약 
      3. 자바 사용법
         = HTML + Java => 구분
         = 스크립트
           <%  %> : 일반 자바 (메소드안에서 자바코딩) 
                    변수(지역변수), 메소드 호출, 연산자, 제어문
                    => 일반적으로 가장 많이 사용
           ============ _jspService()안에 첨부
           <%! %> : 사용빈도는 거의 없다
                    => 클래스 영역
                    => 메소드 선언, 멤버변수 설정
                    
           <%= %> : out.write() : 데이터 출력
           <%
              <%! %>,<%= %> ==> 오류발생
           %>
           a.jsp
           =====
             => a_jsp.java
             public class a_jsp extends HttpServlet
             { 
                 =======================
                 
                   <%! 
                      int a;
                      public void display(){}
                   %>
                 =======================
                 public void _jspInit()
                 public void _jspDestory()
                 public voids _jspService()
                 ==========================
                 
                 <%
                     for(int i=0;i<3;i++)
                     {      
                 %>
                        <h1><%=i%></h1>
                 <%
                     }
                 %>
                 ==========================
             }
      public void _jspService(
       final javax.servlet.http.HttpServletRequest request, 
       final javax.servlet.http.HttpServletResponse response)
   
       final javax.servlet.jsp.PageContext pageContext;
       javax.servlet.http.HttpSession session = null;
       final javax.servlet.ServletContext application;
       final javax.servlet.ServletConfig config;
       javax.servlet.jsp.JspWriter out = null;
       final java.lang.Object page = this;
       ====
       ==== 
      
      ================================
      4. 내장 객체 => Spring에서는 자체 처리
         _jsp
      ================================ request, response
         => 답변형 게시판
      5. 액션 태그
      6. 빈즈 => 병행 => VO
      7. 데이터베이스 연동
      8. MVC
      ================================ Spring, Spring-Boot, 실무

--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <% 
    int a=10/0;
  %>
</body>
</html>