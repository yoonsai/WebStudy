<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    JSTL
      == Tag Lib
      <% %> => 태그형으로 제작
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                                ==================================== 라이브러리
      ====================
          1. 변수선언
          2. 제어문 => for(int i=1;i<=10;i++)
                     => <c:forEach var="i" begin="1" end="10" step="1"/>
                     for(String name:slist)
                     <c:forEach var="name" items="${slist}">
                     
                     <c:forTokens var="" items="" delims="">
                                  ====== ======== ==========
                                  변수명   가져올 값   구분기호
                     => StringTokenizer st=new StringTokenizer(value,delim)
                        while(st.hasMoreTokens())
                        {
                           
                        }
                     
                   => if 조건문
                      <c:if>
                      <c:if test="${}">
                            ========== 조건문
                      => if(test)
                      => 단점 => else문장이 없다
                               ============= 사용자 정의 (회사)
                    
                   => 다중 조건문 => XML로 제작
                          XML
                          ===
                          1. 태그나 속성 => 대문자 구분
                          2. 속성값 => ""
                          3. 계층구조 => 여는 태그 / 닫는 태그 일치
                              => <jsp:include>
                          
                      <c:choose>
                        <c:when test="조건문">출력</c:when>
                        <c:when test="조건문">출력</c:when>
                        <c:when test="조건문">출력</c:when>
                        <c:otherwise>default</c:otherwise>
          
          3. 화면이동
             <c:redirect url=""/>
             => response.sendRedirect(url)
          6. 화면출력
             <%= %>
             <c:out value=""> => Jquery => $
               ${} => import가 동일하게 있으면 오류 발생
          ======================================= core
          4. 날짜변환 / 숫자변환 ===== format
             SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd")
             <fmt:formatDate value="" pattern="yyyy-MM-dd">
             
             DecimalFormat df=new DecimalFormat("###,###")
             <fmt:formatNumber >
             => 오라클에서 => TO_CHAR
          5. 메소드 호출 ============== functions
      
      
      
                                    
 --%>

<%
     // JSTL => 출력은 EL
     List<String> nList=new ArrayList<String>();
     nList.add("홍길동");
     nList.add("이순신");
     nList.add("강감찬");
     nList.add("심청이");
     nList.add("춘향이");
     
     List<String> sList=new ArrayList<String>();
     sList.add("남자");
     sList.add("남자");
     sList.add("남자");
     sList.add("여자");
     sList.add("여자");
     
     request.setAttribute("nlist",nList);
     
%>
<!-- 일반 변수가 아니라 request.setAttribute(var,value); -->
<c:set var="slist" value="<%=sList %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1></h1>
  <ul>
    <!-- for(String name:nlist) -->
    <c:forEach var="name" items="${nlist}">
      <li>${name}</li>
    </c:forEach>
  </ul>
  
  <ul>
    <!-- for(String name:slist) -->
    <c:forEach var="sex" items="${slist}">
      <li>${sex}</li>
    </c:forEach>
  </ul>
  
  <h1>이름(성별)</h1>
  <ul>
    <c:forEach var="name" items="${nlist}" varStatus="s">
    <!--  varStatus => nlist의 인덱스번호를 가져옴 -->
      <li>${s.index+1}. ${name}(${slist[s.index]})</li>
    </c:forEach>
  </ul>
</body>
</html>