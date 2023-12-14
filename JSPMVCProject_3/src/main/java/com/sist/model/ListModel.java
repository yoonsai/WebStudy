package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.sist.dao.*;
import com.sist.vo.BoardVO;
public class ListModel implements model {

	@Override
	public String handleRequest(HttpServletRequest request) {
		String page=request.getParameter("page");
		if(page==null)
		{
			page="1";
		}
		int curpage=Integer.parseInt(page);
	    BoardDAO dao=BoardDAO.newInstance();
	    List<BoardVO> list=dao.BoardListData(curpage);
	    int totalpage=dao.boardTotalPage();
	    
	    request.setAttribute("curpage", curpage);
	    request.setAttribute("totalpage", totalpage);
	    request.setAttribute("list", list);
		return "board/list.jsp";
	}

}
