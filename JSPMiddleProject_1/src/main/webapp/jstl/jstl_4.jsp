<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
      fn => String 메소드만 가능
      태그형이 아님
 --%>
<%
    String msg="Hello JSTL";
%>
<c:set var="msg" value="<%=msg %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>자바(String)</h1>
<%=msg.length() %><br>
<%=msg.substring(0,2) %><br>

<h1>JSTL</h1>
${fn:length(msg)}<br>
${fn:substring(msg,0,2)}<br>
${fn:replace(msg,"o","T")}<br>
</body>
</html>