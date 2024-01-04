package com.sist.model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.sist.controller.RequestMapping;

import java.io.PrintWriter;
import java.net.Inet4Address;
/*
String[] guList = { "전체", "강서구", "양천구", "구로구", "마포구", "영등포구", "금천구",
            "은평구", "서대문구", "동작구", "관악구", "종로구", "중구", "용산구", "서초구", "강북구",
            "성북구", "도봉구", "동대문구", "성동구", "강남구", "노원구", "중랑구", "광진구", "송파구",
            "강동구" };
 */
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
public class FoodModel {
 @RequestMapping("food/location.do")
 public String food_location(HttpServletRequest request,HttpServletResponse response) {
    String[] guList = { "전체", "강서구", "양천구", "구로구", "마포구", "영등포구", "금천구",
            "은평구", "서대문구", "동작구", "관악구", "종로구", "중구", "용산구", "서초구", "강북구",
            "성북구", "도봉구", "동대문구", "성동구", "강남구", "노원구", "중랑구", "광진구", "송파구",
            "강동구" };
    
    String page = request.getParameter("page");
    if(page==null)
       page="1";
    int curpage=Integer.parseInt(page);
    
    String gu = request.getParameter("gu");
    if(gu==null)
       gu="4";
    String address=guList[Integer.parseInt(gu)];
      /*
       * String address=request.getParameter("address"); 
       * if(address==null)
       * address="마포구";
       */
    
    FoodDAO dao = FoodDAO.newInstance();
    List<FoodVO> list = dao.foodFindData(curpage, address);
    int totalpage = dao.foodFindTotalPage(address);
    
    final int BLOCK=10;
      int startPage=((curpage-1)/BLOCK*BLOCK)+1;
      int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
      
      if(endPage>totalpage)
         endPage=totalpage;
    
    request.setAttribute("curpage", curpage);
    request.setAttribute("totalpage", totalpage);
    request.setAttribute("startPage", startPage);
    request.setAttribute("endPage", endPage);
    request.setAttribute("list", list);
    request.setAttribute("gu", gu);
    request.setAttribute("address",address);
    request.setAttribute("main_jsp", "../food/location.jsp");
    CommonsModel.commonsFooterData(request);
    return "../main/main.jsp";
 }
 @RequestMapping("food/location_detail.do")
 public void food_location_detail(HttpServletRequest request,HttpServletResponse response) {
	 String fno = request.getParameter("fno");
	 FoodDAO dao = FoodDAO.newInstance();
	 FoodVO vo= dao.foodDetailData(Integer.parseInt(fno));
	 JSONObject obj=new JSONObject();
	 obj.put("poster", vo.getPoster());
	 obj.put("phone", vo.getPhone());
	 obj.put("name", vo.getName());
	 obj.put("score", vo.getScore());
	 obj.put("address", vo.getAddress());
	 obj.put("seat", vo.getSeat());
	 obj.put("time", vo.getTime());
	 obj.put("type", vo.getType());
	 obj.put("theme", vo.getTheme());
	 obj.put("price", vo.getPrice());
	 obj.put("content", vo.getContent());
	 
	 // 전송
	 try {
		 response.setContentType("application/x-www-from-urlencoded; charset=UTF-8");
		 PrintWriter out=response.getWriter();
		 out.write(obj.toJSONString());
	 }catch(Exception e) {}
	 
 }
 @RequestMapping("food/list.do")
 public String food_list(HttpServletRequest request,HttpServletResponse response) {
	 String page = request.getParameter("page");
	    if(page==null)
	       page="1";
	    int curpage=Integer.parseInt(page);
	    FoodDAO dao = FoodDAO.newInstance();
	    List<FoodVO> list = dao.foodListData(curpage);
	    int totalpage = dao.foodListTotalPage();
	    
	    final int BLOCK=10;
	      int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	      int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	      
	      if(endPage>totalpage)
	         endPage=totalpage;
	    
	    request.setAttribute("curpage", curpage);
	    request.setAttribute("totalpage", totalpage);
	    request.setAttribute("startPage", startPage);
	    request.setAttribute("endPage", endPage);
	    request.setAttribute("list", list);
	 request.setAttribute("main_jsp", "../food/list.jsp");
	 CommonsModel.commonsFooterData(request);
	    return "../main/main.jsp";
 }
 @RequestMapping("food/detail.do")
 public String food_find_detail(HttpServletRequest request,HttpServletResponse response) {
	 String fno = request.getParameter("fno");
	 FoodDAO dao = FoodDAO.newInstance();
	 FoodVO vo= dao.foodDetailData(Integer.parseInt(fno));
	 request.setAttribute("vo", vo);
	 request.setAttribute("main_jsp", "../food/detail.jsp");
	 CommonsModel.commonsFooterData(request);
	    return "../main/main.jsp";
 }
 
 @RequestMapping("food/food_before_detail.do")
 public String food_before(HttpServletRequest request,HttpServletResponse response) {
	 String fno=request.getParameter("fno");
	  Cookie cookie=new Cookie("food_"+fno, fno);
	  cookie.setPath("/");
	  cookie.setMaxAge(60*60*24);
	  response.addCookie(cookie);
	  return "redirect:../food/food_detail.do?fno="+fno;
 }
 
 @RequestMapping("food/food_detail.do")
 public String food_detail(HttpServletRequest request,HttpServletResponse response) {
	 
	 String fno = request.getParameter("fno");
	 FoodDAO dao = FoodDAO.newInstance();
	 FoodVO vo= dao.foodDetailData(Integer.parseInt(fno));
	 String addr=vo.getAddress();
	 String addr1=addr.substring(addr.indexOf(" ")+1);
	 String addr2=addr1.substring(0,addr1.indexOf(" "));
	 System.out.println(addr2.trim());
	 request.setAttribute("addr", addr2);
	 request.setAttribute("vo", vo);
	 request.setAttribute("main_jsp", "../food/food_detail.jsp");
	 CommonsModel.commonsFooterData(request);
	 return "../main/main.jsp";
 }
}