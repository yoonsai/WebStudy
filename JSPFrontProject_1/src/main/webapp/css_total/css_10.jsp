<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container{
   width:700px;
   height:500px;
   border:1px solid red;
}
.header{
   width: 700px;
   height: 100px;
   background-color: yellow;
}
.aside{
   width: 150px;
   height: 300px;
   background-color: cyan;
   float: left;
}
.section{
   width: 400px;
   height: 300px;
   background-color: pink;
   float: left;
}
.footer{
   width: 700px;
   height: 100px;
   background-color: green;
   clear: both;  /*float해제*/
}
</style>
</head>
<body>
   <div class="container">
     <div class="header"></div>
     <div class="aside"></div>
     <div class="section"></div>
     <div class="aside"></div>
     <div class="footer"></div>
   </div>
</body>
</html>