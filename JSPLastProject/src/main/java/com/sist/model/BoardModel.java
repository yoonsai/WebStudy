package com.sist.model;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.*;

public class BoardModel {
	@RequestMapping("board/list.do")
	public String board_list(HttpServletRequest request, HttpServletResponse response)
	{
		//1. 페이지 받기
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		//2.데이터베이스 연결
		BoardDAO dao=BoardDAO.newInstance();
		List<BoardVO> list=dao.boardListData(curpage);
		int totalpage=(int)Math.ceil((dao.boardRowCount())/10.0);
		int count=dao.boardRowCount();
		count=count-((curpage*10)-10); //30개면 count는 30-((2*10)-10) = 30-10 = 20
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("curpage", curpage);
		request.setAttribute("count", count);
		request.setAttribute("list", list);
		request.setAttribute("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		String today= new SimpleDateFormat("yyyy-mm-dd").format(new Date());
		System.out.println(today);
		request.setAttribute("main_jsp", "../board/list.jsp");
		CommonsModel.commonsFooterData(request);
		return "../main/main.jsp";
	}
	
	@RequestMapping("board/insert.do")
	public String board_insert(HttpServletRequest request, HttpServletResponse response)
	{
		request.setAttribute("main_jsp", "../board/insert.jsp");
		CommonsModel.commonsFooterData(request);
		return "../main/main.jsp";
	}
	
	@RequestMapping("board/insert_ok.do")
	public String board_insert_ok(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			request.setCharacterEncoding("UTF-8");
			
		}catch(Exception e) {}
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		String pwd=request.getParameter("pwd");
		
		BoardVO vo=new BoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		
		BoardDAO dao=BoardDAO.newInstance();
		dao.boardInsert(vo);
		
		return "redirect:../board/list.do";
	}
	
	@RequestMapping("board/detail.do")
	public String board_detail(HttpServletRequest request, HttpServletResponse response)
	{
		String no=request.getParameter("no");
		BoardDAO dao=BoardDAO.newInstance();
		BoardVO vo=dao.boardInfoData(Integer.parseInt(no), 1);
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../board/detail.jsp");
		CommonsModel.commonsFooterData(request);
		return "../main/main.jsp";
	}
	
	@RequestMapping("board/delete_ok.do")
	public void board_delete_ok(HttpServletRequest request, HttpServletResponse response)
	{
		String no=request.getParameter("no");
		String pwd=request.getParameter("pwd");
		BoardDAO dao=BoardDAO.newInstance();
		String res=dao.boardDelete(Integer.parseInt(no), pwd);
		
		try {
			PrintWriter out=response.getWriter();
			out.write(res);
		}catch(Exception e) {}
	}
	
	@RequestMapping("board/update.do")
	public String board_update(HttpServletRequest request, HttpServletResponse response)
	{
		String no=request.getParameter("no");
		BoardDAO dao=BoardDAO.newInstance();
		BoardVO vo=dao.boardInfoData(Integer.parseInt(no), 1);
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../board/update.jsp");
		CommonsModel.commonsFooterData(request);
		return "../main/main.jsp";
	}
	
	@RequestMapping("board/update_ok.do")
	public void board_update_ok(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			request.setCharacterEncoding("UTF-8");
			
		}catch(Exception e) {}
		String no=request.getParameter("no");
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		String pwd=request.getParameter("pwd");
		
		BoardVO vo=new BoardVO();
		vo.setNo(Integer.parseInt(no));
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		BoardDAO dao=BoardDAO.newInstance();
		String res=dao.boardUpdate(vo);
		
		try {
			PrintWriter out=response.getWriter();
			out.write(res);
		}catch(Exception e) {}
	}
}
