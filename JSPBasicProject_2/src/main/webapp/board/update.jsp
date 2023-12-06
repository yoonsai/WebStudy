<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
    //데이터받기
    String no=request.getParameter("no");
    String curpage=request.getParameter("page");
    
    //no값이 가지고 있는 데이터를 받아 온다
    BoardDAO dao=BoardDAO.newInstance();
    //화면 출력
    BoardVO vo=dao.boardUpdateData(Integer.parseInt(no));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/table.css">
<style type="text/css">
   img#main{
      margin-top: 50px;
   }
   a{
      color: black;
      text-decoration: none;
   }
   a:hover{
      color: green;
      text-decoration: underline;
   }
</style>
</head>
<body>
<center>
    <h1>자유게시판</h1>
    <img id="main" src="https://cdn-icons-png.flaticon.com/512/6311/6311574.png" width="200" height="200">
    <form method="post" action="update_ok.jsp">
    <table class="table_content" width=800>
      <tr>
       <th width=20%>이름</th>
       <td width=80%>
        <input type=text name=name size=45 required value="<%=vo.getName() %>">
        <%-- 감춘다음 데이터를 전송 : hidden --%>
        <input type="hidden" name=no value="<%=no%>">
        <input type="hidden" name=page value="<%=curpage %>">
       </td>
      </tr>
      
      <tr>
       <th width=20%>제목</th>
       <td width=80%>
        <input type=text name=subject size=45 required value="<%=vo.getSubject() %>">
       </td>
      </tr>
      
      <tr>
       <th width=20%>내용</th>
       <td width=80%>
        <textarea row="10" cols="50" name=content size=45 required><%=vo.getContent() %></textarea>
       </td>
      </tr>
      
      <tr>
       <th width=20%>비밀번호</th>
       <td width=80%>
        <input type=password name=pwd size=10 required>
       </td>
      </tr>
      
      <tr>
       <td colspan="2" class="text-center">
          <button>수정</button>
          <input type=button value="취소"
           onclick="javascript:history.back()">
        </td>

      </tr>
    </table>
    </form>
</center>
</body>
</html>