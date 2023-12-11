<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%--
   581page
   기본 객체 (내장 객체)
   => ***requestScope / ***sessionScope / applicationScope
   => param / pageContext
   EL은 자바 변수를 출력하는 것이 아니다
   == request.session에 저장된 데이터를 출력
   applicationScope => realPath
   /*
      ${} => 출력물 (request,session에 저장된 데이터 출력)
   */
--%>
<jsp:useBean id="model" class="com.sist.dao.StudentModel"/>
<%
   //String name="홍길동";
   //request.setAttribute("name","심청이");
   //session.setAttribute("name","박문수");
   // param => getParameter()
   // param.key => param.name
   studentVO vo=model.studentData();
   session.setAttribute("vo",vo);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
학번:${vo.hakun}<br>
이름:${vo.name}<br>
국어:${vo.kor}<br>
영어:${vo.eng}<br>
수학:${vo.math}<br>
<%--
  이름은 ${requestScope.name } 입니다..<br>
  이름은 ${name } 입니다..<br> 생략하면 request에서 가져옴
  이름은 ${sessionScope.name }  입니다..<br>

--%>

</body>
</html>