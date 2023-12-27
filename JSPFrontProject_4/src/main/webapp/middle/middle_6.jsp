<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
    316page => 함수
    => 함수 : 코드의 집합
             기능처리 (사용자가 요청 => 행위, 브라우저에서만 작동)
             =====
             버튼 클릭 / 마우스 오버 / 변경 / 키보드
             => 호출시에 이벤트
                onclick / onmouseover(hover)
                onmouseout / onchange / onkeydown / onkeyup
       함수생성 방법
       익명의 함수 : function(){} => callback (시스템에 의해 자동호출)
                  map(function(){})
       선언적 함수 
          = function(){} ==> 함수명()
          = let func=function(){} => 이벤트 등록
          = let func=()=>{}
    => 함수 유형 : 리턴형을 기술하지 않는다 => 리턴은 가능
                리턴형 메소드명(매개변수,매개변수..)
                function func_name(매개변수..)
                {
                    return "a"
                }
                
                let a=func_name()  
       function 함수명(매개변수...)
       =======================================================
         리턴형        매개변수 => 리턴형은 let,const로 통일하기 때문에 기술
          o            o        
          ==============
           예) function func_name(id,pwd)    
               {
                    return 값;
               }     
          o            x
          ==============
           예) function func_name()   
               {
                    return 값;
               }
          x            o 
          ==============
           예) function func_name(name)   
               {
                    return; (생략가능) => void
               }
          x            x      
          ==============
           예) function func_name()   
               {
               }   
               
          구성요소 
          function func_name() // 선언부
          {
             구현부
          }
          
          => ES6 권장사항
             let func_name=function(){}
             let func_name=()=>{}
             
             => let func_name=function(매개변수){}
             => let func_name=(매개변수)=>{}
             => =>는 function,return을 생략할 경우에 사용
     
     호출방법
       function func_name(){} ===> func_name()
       let func_name2=function(){} ===> func_name2()
       let func_name3=()=>{} ===> func_name3()
       
       function func_name(name){} ==> func_name('홍길동')

 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
window.onload=function(){
	document.write("<h3>리턴형, 매개변수 설정</h3>")
	let name=hello('홍길동');
	document.write(name+"<br>");
	document.write("<hr>");
	
	document.write("<h3>리턴형만 존재하는 함수</h3>");
	let msg=hello2();
	document.write(msg+"<br>");
	document.write("<hr>");
	
	hello3("홍길동");
	hello4();
}

//function hello(name)
//let hello=function(name)
let hello=(name)=>
{
	return name+"님 환영합니다..";
}

//function hello2()
//let hello2=function()
let hello2=()=>
{
	return "Hello JavaScript Function"
}

//function hello3(name)
//let hello3=function(name)
let hello3=(name)=>
{
	// void => 직접처리
	document.write("<h3>매개변수</h3>");
	document.write(name+"<br>")
	document.write("<hr>");
}

//function hello4()
//let hello4=function()
let hello4=()=>
{
	
	// void => 직접처리
	document.write("<h3>매개변수,리턴형이 없는 함수</h3>");
	document.write("매개변수가 없다<br>")
	document.write("<hr>");
}
</script>
</head>
<body>

</body>
</html>