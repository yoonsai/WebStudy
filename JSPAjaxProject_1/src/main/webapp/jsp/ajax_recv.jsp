<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    // data:{"no":1}
    String index=request.getParameter("no");
    String img="../image/m"+index+".jpg";
%>
<%=img%>
<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<img src="<%=img %>" width="300" height="350">
	</center>
</body>
</html> --%>