<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	let img=document.getElementById("image");
	img.width=200;
	img.height=250;
}
function change(){
	let img=document.getElementById("image");
	img.src="../image/m2.jpg";
	img.width=200;
	img.height=250;
  //----객체 ---- 멤버변수
  
  let div=documnet.getElementById("msg");
  div.textContent="새로운 이미지로 변경되었습니다";
}

</script>
</head>
<body>
   <img id="image" src="../image/m1.jpg">
   <div id="msg">버튼을 클릭하면 이미지가 변경됩니다</div>
   <input type=button value="변경" onclick="change()"> 
</body>
</html>