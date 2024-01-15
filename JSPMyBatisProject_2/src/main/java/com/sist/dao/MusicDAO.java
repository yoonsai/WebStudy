package com.sist.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MusicDAO {
	private static SqlSessionFactory ssf;
	// 초기화 => XML을 파싱
	
	static {
		
		// 자동인식
		try {
			Reader reader=Resources.getResourceAsReader("Config.xml");
			ssf=new SqlSessionFactoryBuilder().build(reader);
			//Mybatis에서 제공하는 태그와 속성만 사용해야 한다
			//제공하는 태그는 => dtd에 선언되어 있다
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static List<MusicVO> musicFindData(Map map)
	{
		SqlSession session=null;
		List<MusicVO> list=new ArrayList<MusicVO>();
		try {
			session=ssf.openSession();
			list=session.selectList("musicFindData",map);
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(session!=null)
				session.close();
		}
		return list;
	}
	
}
