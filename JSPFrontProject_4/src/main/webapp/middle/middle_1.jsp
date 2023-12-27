<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
      2. forEach구문
         for(let data of 배열) => for(데이터형 변수:배열, 컬렉션)
         {           ===
            반복수행문장 ==> 배열에 실제 값을 읽어온다
         }    
         ==> 
         for(let data in 배열)
         {            ===
            반복수행문장 ==> 배열의 인덱스번호를 읽어온다
            => 오라클 (join) where no=no
         }
       3. map => 반복문 (가장 많이 사용되는 반복문) => vue,react
          사용법
          배열명.map(function(데이터)){
                   ============== 자동호출 (배열에서 읽은 값 1개를 매개변수로 첨부)
               반복 출력문
          }
          
          => 배열명.map((데이터)=>{
                           ==== 화살표 (function과 return을 제거)
                           ==== 람다식 : 함수의 포인터를 이용
          })
          
          Runnable r=new Runnable(
              ()=>{}
          )
          
          Runnable r=new Runnable(
              public void run()
              {
              }
          )
         
    
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	const names=["홍길동","심청이","이순신","강감찬","박문수"];
	const sexs=["남자","여자","남자","남자","여자"];
	// 일반 for문
	document.write("<h3>일반 for</h3>");
	//length => 배열의 데이터 갯수
	for(let i=0;i<names.length;i++)
	{
		document.write(names[i]+"&nbsp;");
	}
	document.write("<hr>");

	
	//for of
	document.write("<h3>for of</h3>");
	//length => 배열의 데이터 갯수
	for(let name of names)
	{
		document.write(name+"&nbsp;");
	}
	document.write("<hr>");
	
	//배열의 인덱스번호 출력
	//여러개의 배열을 한번에 출력 ==> 오라클 (조인)
	for(let index in names)
	{
		document.write(names[index]+"("+sexs[index]+")<br>");
	}
	document.write("<hr>");
	
	//함수형으로 변경 => map / forEach
	//일반 for, map, forEach
	document.write("<h3>map 사용법 1</h3>");
	//형식 => ajax
	names.map(function(name){
		document.write(name+"&nbsp;")
	});
	document.write("<hr>");
	document.write("<h3>map 사용법 2</h3>");
	names.map((name)=>{
		document.write(name+"&nbsp;")
	});
	document.write("<hr>");
	
	document.write("<h3>forEach 사용법 1</h3>");
	names.forEach(function(name){
		document.write(name+"&nbsp;")
	});
	document.write("<hr>");
	
	document.write("<h3>forEach 사용법 2</h3>");
	names.forEach((name)=>{
		document.write(name+"&nbsp;")
	});
	document.write("<hr>");
	
}
</script>
</head>
<body>

</body>
</html>