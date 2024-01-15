package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
public class EmpDAO {
	// 파싱 (XML) => <select id="">SELECT~</select>
	// map.put("id","SELECT~") selectList(id명,?)
	private static SqlSessionFactory ssf;
	static
	{
		try {
			//1. XML을 읽어온다
			Reader reader=Resources.getResourceAsReader("Config.xml");
			//2. XML에 설정된 데이터 읽기 => Map
			ssf=new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	// 기능 설정
	public static List<EmpVO> empListData()
	{
		SqlSession session=ssf.openSession(); //객체 생성
		List<EmpVO> list=session.selectList("empListData");
		session.close();
		return list;
	}
	
	public static List<EmpVO> empDeptJoinData()
	{
		SqlSession session=ssf.openSession(); //객체 생성
		List<EmpVO> list=session.selectList("empDeptJoinData");
		session.close();
		return list;
	}
	public static List<EmpVO> empsubqueryData()
	{
		SqlSession session=ssf.openSession(); //객체 생성
		List<EmpVO> list=session.selectList("empsubqueryData");
		session.close();
		return list;
	}
	public static List<String> empNameData()
	{
		SqlSession session=ssf.openSession(); //객체 생성
		List<String> list=session.selectList("empNameData");
		session.close();
		return list;
	}
	
	public static List<EmpVO> empFindData(String name)
	{
		SqlSession session=ssf.openSession(); //객체 생성
		Map map=new HashMap<>();
		map.put("name", name);
		List<EmpVO> list=session.selectList("empFindData",map);
		session.close();
		return list;
	}
}
