package com.sist.model;
import java.util.*;
import com.sist.dao.*;
import javax.servlet.http.HttpServletRequest;
public class FoodModel {
	public void foodDetailData(HttpServletRequest request)
	{
		try {
			request.setCharacterEncoding("UTF-8");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		String fd=request.getParameter("fd");
		String ss=request.getParameter("ss");
		String fno=request.getParameter("fno");
		
		FoodDAO dao=FoodDAO.newInstance();
		FoodVO vo=dao.foodDetailData(Integer.parseInt(fno));
		
		request.setAttribute("vo", vo);
		request.setAttribute("fd", fd);
		request.setAttribute("ss", ss);
	}
}
