package com.sist.model;
import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
public class GoodsModel {
	public void goodsAllData(HttpServletRequest request)
	{
		final int BLOCK=10;
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		
		
		int curpage=Integer.parseInt(page);
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		

		GoodsDAO dao=new GoodsDAO();
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
	}
}
