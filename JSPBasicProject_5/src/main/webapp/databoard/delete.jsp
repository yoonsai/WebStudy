<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*, java.io.*"%>
<jsp:useBean id="dao" class="com.sist.dao.DataBoardDAO"/>
<%
   String no=request.getParameter("no");
   //DAO
   DataBoardBean vo=dao.boardFileInfoData(Integer.parseInt(no));
   dao.boardDelete(Integer.parseInt(no));
   //파일삭제
   try{
	   if(vo.getFilesize()>0) // 파일이 존재한다면
	   {
		   File file=new File("c:\\download\\"+vo.getFilename());
		   file.delete();
	   }
   }catch(Exception e){
   }
   //list.jsp로 이동
   response.sendRedirect("list.jsp");
%>
