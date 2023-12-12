<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.model.*"%>
<%
    SawonVO vo=new SawonVO();
    vo.setName("홍길동");
    vo.setDept("개발부");
   
    // &{}를 사용하려면 request나 session에 저장해야함
    request.setAttribute("vo", vo); // JSP로 데이터를 추가해서 전송
    // request는 제한이 없음, 모든걸 다 보낼 수 있다
    
    SawonVO svo=(SawonVO)request.getAttribute("vo");
    
    session.setAttribute("vo", vo);
    // sessionScope
    // requestScope 
    // => 키 이름이 같으면 requestScope만 생략가능 => ${sessionScope.vo.getName() } 또는 ${sessionScope.vo.name }
    // => 키 이름이 다르면 둘다 생략가능
       
    
%>
<%--
     화면 출력 = 태그형 프로그램 제작 (자바 최소화)
     <%= %> => ${}, <c:out value=""/>
              ===== $는 Jquery 라이브러리
     let a=${name}
     
     ${출력물} => 자바의 변수가 아니다
       ---- request, session
     request.setAttribute("name","홍길동")
     
     <%= request.getAttribute("name")%>
     ${name}
       ===== 키
     => getParameter() => ? ... GET/POST
        setAttribute() => request의 기존 데이터 외에 다른 데이터를 추가해서 전송
                          데이터베이스...
     => 새로 추가된 데이터를 읽어서 출력 
     
     => param = getParameter("name")
        ${param.name}
     
     1) 연산자
        산술연산자 (+, -, *, /(div), %(mod) )
                -- +는 순수하게 산술만 처리
                (문자열 결합)
                null값은 0으로 인식
                "5"+1
                == Integer.parseInt("5")
                / => 정수/정수 => 실수
        
        비교연산자 : if(조건문) => 숫자 / 문자 / 날짜
                  <c:if test="${vo.getId()==sessionScope.id}">
                  == (eq) 
                  != (ne)
                  < (lt)
                  > (gt)
                  <= (le)
                  >= (ge)
                 
        논리연산자 : 조건문
                  && (and) => 범위안에 포함
                  || (or) => 범위밖에 있는 경우
                  ! (not) => 부정연산자
           
        삼항연산자 : 페이지 ${curpage>1?curpage-1:curpage}
                       ${curpage<totalpage?curpage+1:curpage}
        ======================================================
        ${requestScope.name} => request.getAttribute("name")
                      ====== 키
        ${sessionScope.id} => session.getAttribute("id");
                       === 키 
        => request,session 저장시에 Map형식으로 저장
          ================= 키, 값으로 저장
        
        예) 
            session.setAttribute("admin","1")
               => session.getAttribute("admin")
               => ${sessionScope.admin}
                
            request.setAttrbute("id","hong")
            => ${requestScope.id}
            => ${id} => requestScope는 생략이 가능
                 == 변수가 아니라 키 => hong출력
            
            
            ?id=admin&pwd=1234
            = request.getParameter("id") = admin
            = request.getParameter("pwd") = 1234
            
            => EL로 변경
              => ${param.id} = admin
              => ${param.pwd} = 1234           
            
               Bean 또는 VO
            => class Sawon
            {
               private int sabun;
               private String name;
               
               => getter/setter
                  getSabun(), setSabun()
                  getName(), setName()
            }
            
            Sawon vo=new Sawon();
            vo.setSabun(1); ===> getSabun()
            vo.setName("홍길동"); ===> getName()
            
            request.setAttribute("vo",vo) => 해당 JSP로 요청값 전송
            => Sawon vo=(Sawon)request.getAttribute("vo");
               ============================================
               ${vo.getName()}
          
         Model => 자바
         ===== DAO/VO/..자바로 코딩하는 모든 파일
               ====== 한개로 만들 수 있다
                
                
     
     
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <p>이름 : <%=vo.getName() %></p>
  <p>부서 : <%=vo.getDept() %></p>
  
  <p>이름 : ${vo.name}, ${vo.getName()}</p>
  <p>부서 : ${vo.dept}, ${vo.getDept()}</p>
  <p>이름 : ${sessionScope.vo.getName()}</p>
  <p>부서 : ${sessionScope.vo.dept}</p>
  
</body>
</html>