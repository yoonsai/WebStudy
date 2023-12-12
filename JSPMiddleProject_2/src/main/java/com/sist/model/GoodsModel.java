package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;
// 요청 받아서 => 요청 처리 후에 결과값을 request/session에 담아서 jsp로 보내줌
/*
 *    JSP => Model => DAO
 *        <=       <=
 *      request => 결과값을 추가해서 전송
 *      ===========================> Call by Reference
 * 
 */
public class GoodsModel {

	 public void goodsListData(HttpServletRequest request)
	   {
	      // type , page => <% %>
	      String type=request.getParameter("type");
	      if(type==null)
	         type="1";
	      String page=request.getParameter("page");
	      if(page==null)
	         page="1";
	      // 페이지 지정
	      int curpage=Integer.parseInt(page);
	      //
	      GoodsDAO dao=new GoodsDAO();
	      
	      List<GoodsVO> list=dao.goodsAlldata(curpage,Integer.parseInt(type));
	      int totalpage=dao.goodsTotalPage(Integer.parseInt(type));
	      
	      final int BLOCK=10;
	      int startPage=((curpage-1)/BLOCK*BLOCK)+1; //1,11,21..
	      int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	      
	      if(endPage>totalpage)
	      {
	    	  endPage=totalpage;
	      }
	      //JSP에서 출력할 데이터전송
	      request.setAttribute("list", list);
	      request.setAttribute("curpage", curpage);
	      request.setAttribute("totalpage", totalpage);
	      request.setAttribute("startPage", startPage);
	      request.setAttribute("endPage", endPage);
	      request.setAttribute("type", type);
	   }
	 
	 public void goodsDetailData(HttpServletRequest request)
	 {
		 //요청값을 받는다
		 String table=request.getParameter("table");
		 String no=request.getParameter("no");
		 String type=request.getParameter("type");
	     // 요청에해당되는 데이터베이스 값 읽기
		 GoodsDAO dao=new GoodsDAO();
		 GoodsVO vo=dao.goodsDetailData(Integer.parseInt(no), Integer.parseInt(table));
		 // request에 담아준다
		 request.setAttribute("vo", vo);
		 request.setAttribute("table", table);
		 // ======= detail.jsp
	 }

}
