<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
     
     
     3. 내장 객체 => 미리 생성 후 사용이 가능하게 만든다
        ======
        request : 사용자의 요청정보
            => HttpServletRequest
        response : 응답 (브라우저로 전송)
        
        
        
            
     
     
     session : 서버에 필요한 정보 저장
       => 사용자 정보 (로그인) / 장바구니 => 임시기억장소
       => 전역변수(공유변수) => 모든 JSP에서 사용이 가능
        ** request => 매개 변수 => 모든 JSP마다 한개씪 가지고 있다
           => 화면 변경 / 새로고침 => 자동으로 초기화


 		http://localhost/JSPBasicProject_7/jsp/a.jsp?name=%ED%99%8D%EA%B8%B0%EB%8F%99
 		
 		response주요메소드
 		 = addCookie()
 		 = sendRedirect()
 		 = setHeader()
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <a href="a.jsp?name=홍기동">전송</a>
</body>
</html>