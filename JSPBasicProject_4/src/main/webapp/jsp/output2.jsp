<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.bean.*"%>
<%
    //한글 변환
    request.setCharacterEncoding("UTF-8");


%>
<%-- Student bean=new StudentBean(): 메모리 할당 --%>
<jsp:useBean id="bean" class="com.sist.bean.StudentBean">
  <jsp:setProperty name="bean" property="*"/>
  </jsp:useBean>
<%--
     bean라는 객체안에 데이터 전체 저장
   --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>학생 정보</h1>
  학번:<%=bean.getHakbun() %><br>
  학번:<jsp:getProperty name="bean" property="hakbun"/><br> <%--get은 너무 길어서 잘 안씀 bean.getHakbun() 방식을 많이 사용--%>
  이름:<%=bean.getName() %><br>
  국어:<%=bean.getKor() %><br>
  영어:<%=bean.getEng() %><br>
  수학:<%=bean.getMath() %><br>
</body>
</html>