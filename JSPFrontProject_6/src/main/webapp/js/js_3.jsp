<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
    내장 객체
    =======
    String 객체
      => 자바와 유사
         1) substring(), substr()
         2) trim()
         3) replace()
         4) split()
         5) charAt()
         6) indexOf()
         7) lastIndexOf()
         8) slice()
         
    Math 객체
      => random()
      => round()
    Array 객체
      => push()
      => pop()
      => reverse
      => sort
      => slice()
    Date 객체
      => get()

--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	/*
	   let str="HelloJavascript";
	   let str=new String("hello")
	*/
	let str="Hello javascript";
	   document.write("문자갯수:"+str.length+"<br>")
	   str=str.trim()
	   
}
</script>
<style type="text/css">
.container{
margin-top:50px;
}
.row{
}
</style>
</head>
<body>

</body>
</html>