<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row{
  margin: 0px auto;
  width: 100%
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<c:if test="${sessionScope.id!=null }">
	<div class="container">
	  <div class="row">
	   <div class="text-right">
	    <form method="post" action="../member/logout.do">
	     ${sessionScope.name}(${sessionScope.admin=='y'?"관리자":"일반사용자" }) 님 로그인되었습니다
	     <input type="submit" value="로그아웃"
	       class="btn-sm btn-success">
	    </form>
	   </div>
	  </div>
	</div>
	</c:if>
	<div style="height: 20px"></div>
	<jsp:include page="${main_jsp }"></jsp:include>
</body>
</html>