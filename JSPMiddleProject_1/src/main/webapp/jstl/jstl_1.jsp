<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>&lt;c:forTokens&gt;=> StringTokenizer</h1>
  <!-- var=> st.nextToken() 값을 저장하는 변수 -->
  <c:forTokens var="image" items="m1,m2,m3,m4,m5,m6,m7" delims=",">
    <img src="${image}.jpg" width="150" height="200">
  </c:forTokens>
  
  <h1>&lt;c:if&gt;</h1>
  <%-- 증가 : step="1" 1씩 증가면 생략가능함 --%>
  <c:forEach var="i" begin="1" end="10">
   <c:if test="${i%2==0}">
     ${i += "짝"}&nbsp;
   </c:if>
   
   <c:if test="${i%2!=0}">
     ${i += "홀"}&nbsp;
   </c:if>
  </c:forEach>
</body>
</html>