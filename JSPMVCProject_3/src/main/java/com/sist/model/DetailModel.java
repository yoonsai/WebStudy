package com.sist.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

public class DetailModel implements model {

	@Override
	public String handleRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String no=request.getParameter("no");
		
		BoardDAO dao=BoardDAO.newInstance();
		BoardVO vo=dao.boardDetailData(Integer.parseInt(no));
		request.setAttribute("vo", vo);
		return "board/detail.jsp";
	}

}
