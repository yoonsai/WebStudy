package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class InsertModel implements model {

	@Override
	public String handleRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		//화면이동
		return "board/insert.jsp";
	}

}
