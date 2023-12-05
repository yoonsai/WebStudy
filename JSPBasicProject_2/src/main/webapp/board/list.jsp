<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*, java.util.*,java.text.*"
    errorPage="error.jsp"
    %>
<%
    // 사용자 요청 => 요청 처리 결과를 받는다..
    // 사용자 요청 = 페이지
    // 사용자 페이지 요청 => 받는다
    String strPage=request.getParameter("page");
    if(strPage==null) // 처음실행
    	strPage="1";
    // 현재 페이지 지정
    int curpage=Integer.parseInt(strPage);
    // 오라클로부터 데이터를 읽어오기
    BoardDAO dao=BoardDAO.newInstance();
    List<BoardVO> list=dao.boardListData(curpage);
    //총페이지 
    int count=dao.boardRowCount();
    int totalpage=(int)(Math.ceil(count/10.0));
    
    // count 변경
    count=count-((curpage*10)-10);
%>
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
    <table class="table_content" width=800>
      <tr>
       <td>
        <a href="insert.jsp">새글</a>
       </td>
      </tr>
    </table>
    <table class="table_content" width=800>
      <tr>
        <th width=10%>번호</th>
        <th width=45%>제목</th>
        <th width=15%>이름</th>
        <th width=20%>작성일</th>
        <th width=10%>조회수</th>
      </tr>
      <%
         for(BoardVO vo:list)
         {
       %>  	 
           <tr>
            <td width=10% class="text-center"><%=count -- %></td>
            <td width=45%>
             <%
                if(vo.getGroup_tab()>0)
                {
                	for(int i=0;i<vo.getGroup_tab();i++)
                	{
                		out.write("&nbsp;&nbsp;"); 
                	}
             %>   
                  <img src="re_icon.png" style="width:35px;height:25px">
             <%
                }
             %>
               <a href="detail.jsp?no=<%=vo.getNo()%>"><%=vo.getSubject() %></a>&nbsp;
            <%
               SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
               String today=sdf.format(new Date());
               System.out.println(today);
               if(today.equals(vo.getDbday()))
               {
            	   
            %>
                  <sup style="color:red">new</sup>
            <%
               }
            %>
            </td>
            <td width=15% class="text-center"><%=vo.getName() %></td>
            <td width=20% class="text-center"><%=vo.getDbday() %></td>
            <td width=10% class="text-center"><%=vo.getHit() %></td>
           </tr>
     <% 
         }
      %>
      <tr>
        <td colspan="5" class="text-center">
          <a href="#">이전</a>&nbsp;
          <%=curpage %> page / <%=totalpage %> pages&nbsp;
        </td>
      </tr>
    </table>
  </center>
</body>
</html>