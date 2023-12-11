<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%@ page import="java.util.*" %>
<jsp:useBean id="dao" class="com.sist.dao.FoodDAO"/>
<%--
   fs=all%mode=2%ss=
   => ss!=null  => ss=""
 --%>
 <%
    //request.setCharacterEncoding("UTF-8");
    String fs=request.getParameter("fs");
    String ss=request.getParameter("ss"); // 검색어
    String strPage=request.getParameter("page");
    //System.out.println("ss="+ss);
    int totalpage=0;
    if(strPage==null)
    {
    	strPage="1";
    }
    int curpage=Integer.parseInt(strPage);
    
    List<FoodVO> list=new ArrayList<FoodVO>();
    if(ss==null || ss.equals(""))
    {
    	fs="all";
    }
    if(fs.equals("all"))
    {
    	list=dao.foodAllData(curpage);
    	totalpage=dao.foodTotalPage();
    }
    else{
    	list=dao.foodFindData(curpage,fs,ss);
    	totalpage=dao.foodFindTotalPage(fs, ss);
    }
    final int BLOCK=10;
    int startpage=((curpage-1)/BLOCK*BLOCK)+1;
    int endpage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
    
    if(endpage>totalpage){
       endpage=totalpage;
    }

 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper row3">
  <main class="container clear"> 
    <!-- main body --> 
    <!-- ################################################################################################ -->
    <div class="content"> 
      <!-- ################################################################################################ -->
      <div id="gallery">
        <figure>
          <header class="heading">
           <form method="post" action="../main/main.jsp" class="inline">
              <select name="fs">
               <option value="all" <%=fs.equals("all")?"selected":""%>>전체</option>
               <option value="name" <%=fs.equals("name")?"selected":""%>>업체명</option>
               <option value="address" <%=fs.equals("address")?"selected":""%>>주소</option>
              </select>
              <input type=hidden name=mode value=2>
              <input type="text" name=ss size=15 value="<%=ss==null?"":ss %>">
              <button>검색</button>
           </form>
          </header>
          <ul class="nospace clear">
           <%
               for(int i=0;i<list.size();i++)
               {
            	   FoodVO vo=list.get(i);
               
           
           %>
            <li class="one_quarter <%=i%4==0?"first":"" %>"><a href="#"><img src="https://www.menupan.com/<%=vo.getPoster() %>" alt=""><%=vo.getName() %></a></li>
            <%

               }
           
           %>
            
          </ul>
        </figure>
      </div>
      <!-- ################################################################################################ --> 
      <!-- ################################################################################################ -->
      <nav class="pagination">
        <ul>
        <%
            if(startpage>1)
            {
        %>
          <li><a href="../main/main.jsp?mode=2&page=<%=startpage-1%>&ss=<%=ss%>&fs=<%=fs%>">&laquo; Previous</a></li>
        <%
            }
            for(int i=startpage;i<=endpage;i++)
            {
        %>
          <li <%=curpage==i?"class=current":"" %>><a href="../main/main.jsp?mode=2&page=<%=i %>&ss=<%=ss%>&fs=<%=fs%>"><%=i %></a></li>
        <%
            }
            if(endpage<totalpage)
            {
        %>
          <li><a href="../main/main.jsp?mode=2&page=<%=endpage+1%>&ss=<%=ss%>&fs=<%=fs%>">Next &raquo;</a></li>
         <%
            }
        %>
        </ul>
      </nav>
      <!-- ################################################################################################ --> 
    </div>
    <!-- ################################################################################################ --> 
    <!-- / main body -->
    <div class="clear"></div>
  </main>
</div>
</body>
</html>