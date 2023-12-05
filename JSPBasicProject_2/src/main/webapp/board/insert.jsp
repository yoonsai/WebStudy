<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/table.css">
<style type="text/css">
  img#main{
    margin-top:30px;
    border: none;
  }
  a{
     color:black;
     text-decoration: none;
  }
  a:hover{
     color:green;
     text-decoration: underline;
  }
</style>
</head>
<body>
<center>
    <h1>자유게시판</h1>
    <img id="main" src="https://cdn-icons-png.flaticon.com/512/6311/6311574.png" width="200" height="200">
    <form method="post" action="insert_ok.jsp">
    <table class="table_content" width=800>
      <tr>
       <th width=20%>이름</th>
       <td width=80%>
        <input type=text name=name size=45 required>
       </td>
      </tr>
      
      <tr>
       <th width=20%>제목</th>
       <td width=80%>
        <input type=text name=subject size=45 required>
       </td>
      </tr>
      
      <tr>
       <th width=20%>내용</th>
       <td width=80%>
        <textarea row="10" cols="50" name=content size=45 required></textarea>
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
        <button>글쓰기</button>
        
        <input type="button" value="취소" onclick="javascript:history.back()">
       </td>
      </tr>
    </table>
    </form>
</center>
</body>
</html>