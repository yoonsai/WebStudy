package com.sist.dao;

public class StudentModel {
	public studentVO studentData()
	{
		studentVO vo=new studentVO();
		vo.setHakun(1);
		vo.setName("홍길동");
		vo.setKor(90);
		vo.setEng(90);
		vo.setMath(90);
		return vo;
	}
}
