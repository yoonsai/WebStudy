package com.sist.model;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.RequestMapping;
import com.sist.dao.GoodsDAO;
import com.sist.vo.CartVO;
import com.sist.vo.GoodsVO;


public class GoodsModel {
	String[] typeles={"","goods_all","goods_special",
			   "goods_best","goods_new"};
	@RequestMapping("goods/goods_list.do")
	   public String main_main(HttpServletRequest request,
			   HttpServletResponse response)
	   {
		   String page=request.getParameter("page");
		   if(page==null)
			   page="1";
		   int curpage=Integer.parseInt(page);
		   
		   String type=request.getParameter("type");
		   if(type==null)
			   type="1";
		   
		   int rowSize=20;
		   int start=(curpage*rowSize)-(rowSize-1);
		   int end=curpage*rowSize;
		   
		   Map map=new HashMap();
		   map.put("tab_name", typeles[Integer.parseInt(type)]);
		   map.put("start", start);
		   map.put("end", end);
		   
		   List<GoodsVO> list=GoodsDAO.goodsListData(map);
		   for(GoodsVO vo:list)
		   {
			   String name=vo.getGoods_name();
			   if(name.length()>15)
			   {
				   name=name.substring(0,15)+"...";
				   vo.setGoods_name(name);
			   }
			   vo.setGoods_name(name);
			   System.out.println(vo.getGoods_name());
			   System.out.println(vo.getGoods_poster());
		   }
		   int totalpage=GoodsDAO.goodsTotalPage(map);
		   
		   // home.jsp에 출력할 내용물 전송 
		   final int BLOCK=10;
		   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		   if(endPage>totalpage)
			   endPage=totalpage;
		   
		   request.setAttribute("curpage", curpage);
		   request.setAttribute("totalpage", totalpage);
		   request.setAttribute("startPage",startPage);
		   request.setAttribute("endPage", endPage);
		   request.setAttribute("list", list);
		   request.setAttribute("type", type);
		   
		   request.setAttribute("main_jsp", "../goods/goods_list.jsp");
		   return "../main/main.jsp";
	   }
	@RequestMapping("goods/goods_detail.do")
	public String goods_detail(HttpServletRequest request,
			   HttpServletResponse response)
	   {
		   String no=request.getParameter("no");
		   String type=request.getParameter("type");
		   Map map=new HashMap();
		   map.put("tab_name", typeles[Integer.parseInt(type)]);
		   map.put("no", no);
		   GoodsVO vo=GoodsDAO.goodsDetailData(map);
		   String price=vo.getGoods_price();
		   price=price.replaceAll("[^0-9]", ""); //숫자를 제외하고 나머지를 공백으로 바꿔라 (^은 부정)
		   // 숫자 => [0-9] , 알파벳 => [A-Za-z], 한글 => [가-힣]
		   // ^[A-Z] => 시작 [^A-Z] => 제외
		   // [A-Z]$ => 끝 [A-Z]
		   // . 임의의 한글자
		   // *(0이상) / +(1이상) / ?(0,1)
		   // 정규식
		   // [] => 패턴 , {} => 갯수
		   // [0-9]{1-3}\\[0-9]{1,3}\\.[0-9]{1-3}\\.[0-9]{1-3} (IP번호 긁어올수있음)
		   vo.setGoods_price(price);
		   request.setAttribute("vo", vo);
		   request.setAttribute("type", type);
		   request.setAttribute("main_jsp", "../goods/goods_detail.jsp");
		   return "../main/main.jsp";
	   }
	@RequestMapping("goods/cart_insert.do")
	public void cart_insert(HttpServletRequest request,
			   HttpServletResponse response)
	   {
		    String result="";
		     try {
		    	String no=request.getParameter("no");
			    String price=request.getParameter("price");
			    String count=request.getParameter("count");
			    String type=request.getParameter("type");
			    HttpSession session=request.getSession();
			    String id=(String)session.getAttribute("id");
			    
			    CartVO vo=new CartVO();
			    vo.setAmount(Integer.parseInt(count));
			    vo.setGoods_no(Integer.parseInt(no));
			    vo.setId(id);
			    vo.setPrice(Integer.parseInt(price));
			    vo.setType(Integer.parseInt(type));
			    GoodsDAO.cartgoodsInsert(vo);
			    result="yes";
		    }catch(Exception e) {
		    	result="no";
		    }
		     try {
		    	 PrintWriter out=response.getWriter();
		    	 out.write(result);
		     }catch(Exception e) {
		    	 
		     }
		    
	   }
		   @RequestMapping("goods/cart_buy.do")
		public void cart_buy(HttpServletRequest request,
				   HttpServletResponse response)
		   {
			    String result="";
			     try {
			    	String no=request.getParameter("no");
				    String price=request.getParameter("price");
				    String count=request.getParameter("count");
				    String type=request.getParameter("type");
				    HttpSession session=request.getSession();
				    String id=(String)session.getAttribute("id");
				    
				    CartVO vo=new CartVO();
				    vo.setAmount(Integer.parseInt(count));
				    vo.setGoods_no(Integer.parseInt(no));
				    vo.setId(id);
				    vo.setPrice(Integer.parseInt(price));
				    vo.setType(Integer.parseInt(type));
				    GoodsDAO.goodsBuyInsert(vo);
				    result="yes";
			    }catch(Exception e) {
			    	result="no";
			    }
			     try {
			    	 PrintWriter out=response.getWriter();
			    	 out.write(result);
			     }catch(Exception e) {
			    	 
			     }
			    
		   }
		   @RequestMapping("goods/cart_cancel.do")
		public String cart_cancel(HttpServletRequest request,
				   HttpServletResponse response)
		   {
			    
			    	String no=request.getParameter("no");
				    GoodsDAO.cartDelete(Integer.parseInt(no));
				    return "redirect:../mypage/mypage_cart.do";
			    
		   }
		   
		   @RequestMapping("goods/goods_cart_buy.do")
		   public String goods_cart_buy(HttpServletRequest request,
				   HttpServletResponse response)
		   {
			    
			    	String no=request.getParameter("no");
				    GoodsDAO.cartDelete(Integer.parseInt(no));
				    return "redirect:../mypage/mypage_cart.do";
			    
		   }
		
	
}
