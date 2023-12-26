<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

.container{
   width:900px;
   height:700px;
   border:1px solid black;
   margin:0 auto;
   
}
.header{
   width:900px;
   height:100px;
   background-color:aqua;
   text-align: center;
   
}
.nav{
   width:900px;
   height:150px;
   background-color:pink;
   text-align: center;
}
.aside{
   width:200px;
   height:350px;
   background-color:yellow;
   float: left;
}
.section{
   width:700px;
   height:350px;
   background-color:green;
   float: left;
}
.footer{
   width:900px;
   height:100px;
   background-color:lime;
   clear: both;
}
#keyword{
   width: 300px;
   height: 50px;
/*    margin-top: 20px;
   margin-left: 170px; */
   margin-top: 25px;
}
.btn{
   width: 50px;
   height: 50px;
}
ul{
  list-style: none;
  background-color: blue;
  margin: 0 auto;
  clear:both;
  text-align: center;
  margin-left: 50px;
}
ul li{
  padding: 15px;
  float: left;
  font-weight: bold;
  color: white;
  margin-top: 50px;
}
ul li:first-child{
    border-radius: 10px 0 0 10px;
}

ul li:last-child{
    border-radius: 0 10px 10px 0;
}
ul li:nth-child(odd){
    background-color: orange;
}
ul li:nth-child(even){
    background-color: red;
}
ul li:hover{
    cursor: pointer;
    color:cyan;
}
</style>
</head>
<body>
   <div class="container">
     <div class="header">
       <div class="serch">
       <input type=text id="keyword">
       <input type=button class="btn" value="검색">
       </div>
     </div>
     <div class="nav">
       <ul>
         <li>홈</li>
         <li>회원</li>
         <li>맛집</li>
         <li>레시피</li>
         <li>서울여행</li>
         <li>제주여행</li>
         <li>추천</li>
         <li>커뮤니티</li>
         <li>마이페이지</li>
       </ul>
     </div>
     <div class="aside"></div>
     <div class="section"></div>
     <div class="footer"></div>
   </div>
</body>
</html>