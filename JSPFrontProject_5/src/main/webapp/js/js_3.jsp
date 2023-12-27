<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	/* let h1=document.querySelector("h1")
	h1.style.color="orange";
	h1.style.background="skyblue"; */
	
	let h1=document.querySelectorAll('h1');
	// h1 => 배열
	console.log("h1="+typeof h1)
	for(let h of h1)
	{
		h.style.color="orange";
		h.style.background="skyblue";
	}
}
</script>
</head>
<body>
  <h1>Hello JavaScript</h1>
  <h1>Hello JavaScript</h1>
  <h1>Hello JavaScript</h1>
</body>
</html>