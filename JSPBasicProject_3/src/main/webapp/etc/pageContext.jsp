<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
   1. 내장 객체 얻기
   2. 웹 흐름 제어
      include(), ***forward() => 파일마다 request를 공유한다 
      pageContext.include() ==> X
       => <jsp:include>
       => 
          1. <%@ include file=""%> : 정적
             => file에는 반드시 file명을 설정한다
                menu / footer
          2. <jsp:include page=""> : 동적
             => 내용출력시에 변경
                page=변수명
          => JSP안에 특정 위치에 다른 JSP를 포함
          a.jsp
           <html>
             <body>
               <%
                  int a=10;
               %>
               <h1><%= a%></h1>
             </body>
           </html>
           ========================
           <html>
           <body>
             <h1>10</h1>
           </body>
           </html>
           ========================
           
           b.jsp
           <html>
             <body>
               <%  int a=100; %>
               <h1><%= a%></h1>
               ===========================
               <%@ include file="a.jsp"%>
                 =>  a가 두개라 오류남 => 소스코드를 합친다음에 한 번에 컴파일
                    <html>
                     <body>
                      <%
                         int a=10;
                      %>
                      <h1><%= a%></h1>
                     </body>
                    </html>
               ===========================
               <jsp:include page="a.jsp">
                 => 따로따로 컴파일 한 후 html를 붙이는 것
             </body>
           </html>
           =========================
           b.jsp
           <html>
             <body>
               <h1>100</h1>
             </body>
           </html>
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>