<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
  let i=0;
  document.write("<h3>do~while</h3>");
  do{
	  document.write("i="+i+"<br>");
	  i++;
  }
  while(i<10){
	  document.write("<hr>");
  }
  
  
  document.write("<h3>while</h3>");
  i=1;
  while(i<=10)
  {
	  document.write("i="+i+"<br>");
	  i++;
  }
  
  
  document.write("<hr>");
  document.write("<h3>for</h3>");
  for(i=1;i<=10;i++)
  {
	  document.write("i="+i+"<br>");
  }
  
  
  document.write("<hr>");
  document.write("<h3>break</h3>");
  for(i=1;i<=10;i++)
  {
	  if(i==5) break;
	  document.write("i="+i+"<br>");
  }
  
  
  document.write("<hr>");
  document.write("<h3>continue</h3>");
  //특정 부분을 제외할 경우에 주로 사용
  //제외하고 증가식으로 이동
  for(i=i;i<=10;i++)
  {
	 if(i==5) continue; // i==5일때 => 증가식으로 이동
	 document.write("i="+i+"<br>");
  }
  document.write("<hr>")
  
</script>
</head>
<body>

</body>
</html>