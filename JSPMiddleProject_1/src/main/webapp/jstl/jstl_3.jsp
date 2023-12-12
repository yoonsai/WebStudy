<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.text.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>날짜변환</h1>
<%
   Date date=new Date();
   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
   String today=sdf.format(date);
%>
<%=date %><br>
<%=today %>

<h1>날짜변환(JSTL)</h1>
<c:set var="today" value="<%=date %>"/>
<fmt:formatDate value="${today}" pattern="yyyy-MM-dd"/>
<p>${today}</p>

<h1>숫자변환</h1>
<%
   int a=12345678;
   DecimalFormat df=new DecimalFormat("##,###,###");
   String num=df.format(a);
%>
<%=num %><br>

<h1>숫자변환</h1>
<c:set var="num" value="<%=a %>"/>
<fmt:formatNumber value="${num}" pattern="##,###,###"/>
</body>
</html>