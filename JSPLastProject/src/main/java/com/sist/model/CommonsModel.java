package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.manager.*;
import com.sist.vo.*;
public class CommonsModel {
	 
	public static void commonsFooterData(HttpServletRequest request)
	   {
		   // 1. 공지사항 => hit가 많은 
		   NoticeDAO ndao=NoticeDAO.newInstance();
		   List<NoticeVO> nolist=ndao.noticeTop7();
		   request.setAttribute("nolist", nolist);
		   // 2. 맛집 뉴스 
		   List<NewsVO> nlist=NewsManager.newsSearchData("맛집");
		   request.setAttribute("nlist", nlist);
		   // 3. 인기 맛집 => hit
		   FoodDAO dao=FoodDAO.newInstance();
		   List<FoodVO> flist=dao.foodTop7();
		   request.setAttribute("flist", flist);
	   }
}
