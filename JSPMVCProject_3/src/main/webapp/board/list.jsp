<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="vo" class="com.sist.dao.BoardDAO"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style>
.container{
   margin-top :50px;
}
.row{
   margin: 0px auto;
   width: 800px;
}
</style>
</head>
<body>
   <div class="container">
     <div class="row">
       <h1 class="text-center">게시판</h1>
       <table class="table">
         <tr>

            <a href="insert.do">새글</a>

         </tr>
         
         <tr>
         <th width=10% class="text-center">번호</th>
         <th width=40% class="text-center">제목</th>
         <th width=20% class="text-center">이름</th>
         <th width=20% class="text-center">작성일</th>
         <th width=10% class="text-center">조회수</th>
       </tr>
       
       <c:forEach var="vo" items="${list}">
       <tr>
         <th width=10% class="text-center">${vo.no}</th>
         <th width=40% class="text-center"><a href="detail.do?no=${vo.no}">${vo.subject}</a></th>
         <th width=20% class="text-center">${vo.name}</th>
         <th width=20% class="text-center">${vo.dbday}</th>
         <th width=10% class="text-center">${vo.hit}</th>
       </tr>
       </c:forEach>
       </table>
     </div>
   </div>
</body>
</html>