<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="model" class="com.sist.dao.EmpModel"/>
<%
    model.empListData(request);
    // mvc모델에서는 cotroller로 해당 코드를 쓸 예정
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <center>
    <table class="table_content">
        <tr>
          <th>사번</th>
          <th>이름</th>
          <th>직위</th>
          <th>입사일</th>
          <th>급여</th>
        </tr>
        <c:forEach var="vo" items="${list }">
        <tr>
          <td>${vo.empno }</td>
          <td>${vo.ename }</td>
          <td>${vo.job }</td>
          <td>${vo.hiredate }</td>
          <td>${vo.sal }</td>
        </tr>
        </c:forEach>
    </table>
  </center>
</body>
</html>