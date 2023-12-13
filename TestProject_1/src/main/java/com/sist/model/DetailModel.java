package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class DetailModel implements Model {

	@Override
	public String handleRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return "goods/detail.jsp";
	}

}
