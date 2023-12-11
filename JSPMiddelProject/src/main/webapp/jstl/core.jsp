<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%--
     prefix="c" => <c:
     prefix="core" => <core:
     
     JSTL => 자바의 제어문 => 태그로 만들어져 있다
     ====
      core : 변수 설정 , 제어문 , URL (화면 이동)
        <c:set> : 변수 설정
        <c:set var="today" value="2023-12-11"/>
        => request.setAttribute("today","2023-12-11");
        => ${today}
        <c:redirect url="a.jsp">
        => response.sendRedirect("a.jsp");
        <c:if> if => 다중조건문 / else문장이 없다
        <c:forEach> for
        <c:choose> switch
        
      format / xml / sql / fn => String메소드
      ======              ====
      
 --%> 
<%
    List<String> list=new ArrayList<String>();
    list.add("홍길동");
    list.add("심청이");
    list.add("박문수");
    list.add("이순신");
    list.add("강감찬");
    
    //request.setAttribute("list", list);
    //=> 하단의 <c:set ~ 랑 같은 뜻
%>
<c:set var="list" value="<%=list %>"/> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>Java : for</h1>
   <%
       for(int i=1;i<=10;i++)
       {
   %>
          <%=i %>&nbsp;
   <%
       }
   %>
   <%-- step="1"은 생략이 가능 step="-1"은 사용할 수 없다 --%>
   <h1>JSTL : for</h1>
   <c:forEach var="i" begin="1" end="10" step="1">
   ${i}&nbsp;
   </c:forEach>
   
   
   <h1>Java : for-Each</h1>
   <ul>
   <%
       for(String name:list)
       {
   %>
          <li><%=name %></li>
   <%
       }
   %>
   </ul>

   <h1>JSTL : for-Each</h1>
   <ul>
   <c:forEach var="name" items="${list }">
      <li>${name}</li>
   </c:forEach>
   </ul>
</body>
</html>