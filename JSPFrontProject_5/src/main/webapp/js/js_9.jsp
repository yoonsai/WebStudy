<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
/*
 *   $(function(){
	    let h1=$('#h1');
	    let gBtn=$('#green');
	    h1.click(function(){
	    	
	    })
	    h1.on('click',function(){})
     })
     <button v-on:click="aaa()">
     let aaa=addOnclick
 */
window.onload=function(){
	let h1=document.querySelector("#h1")
	let gBtn=document.querySelector("#green")
	let bBtn=document.querySelector("#blue")
	let rBtn=document.querySelector("#red")
	
	gBtn.addEventListener('click',function(){
		h1.style.color="green"
	});
	bBtn.addEventListener('click',function(){
		h1.style.color="blue"
	});
	rBtn.addEventListener('click',function(){
		h1.style.color="red"
	});
	//                    ====== ===========
    //                    이벤트명  처리할 함수
}
</script>
</head>
<body>
<h1 id="h1">제목</h1>
<button id="green">green</button>
<button id="blue">blue</button>
<button id="red">red</button>

</body>
</html>