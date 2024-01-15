<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	//배열 선언 ==> 자바에서 가지고 온다
	let names=[{name:'홍길동'},{name:'심청이'},{name:{'박문수'},{name:{'김두한'},{name:{'이순신'}]
	// 1. 배열 출력
	console.log(names)
	// 2. 인원수 확인
	console.log("인원수:"+names.length)
	// 3. 인원추가
    name.push({name:"을지문덕"})
    console.log(names)
    //제거 => 마지막 인원제거
    names.pop()
    console.log(names)
    // 5. 전체 제거
    names.delete
    console.log(names.length)
	
}
</script>
</head>
<body>

</body>
</html>