package com.sist.dao;

import java.util.List;

import com.sist.vo.BoardVO;

public class class1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardDAO dao=BoardDAO.newInstance();
		List<BoardVO> list=dao.BoardListData(1);
	    for(BoardVO vo:list)
	    {
	    	System.out.println(vo.getContent());
	    }
	}

}
