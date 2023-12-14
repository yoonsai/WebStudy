package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sist.dao.GoodsDAO;
import com.sist.vo.GoodsVO;

public class ListModel implements Model {

	@Override
	public String handleRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		final int BLOCK=10;
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		
		
		int curpage=Integer.parseInt(page);
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		

		GoodsDAO dao=GoodsDAO.newInstance();
        List<GoodsVO> list=dao.goodsListData(curpage);
		int totalPage=dao.totalPage();
		
		if(endPage>totalPage)
		{
			endPage=totalPage;
		}
		
        request.setAttribute("curpage", curpage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("list", list);
		
		return "goods/list.jsp";
	}

}
