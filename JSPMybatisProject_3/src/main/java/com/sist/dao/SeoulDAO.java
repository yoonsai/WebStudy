package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.*;

public class SeoulDAO {
	private static SqlSessionFactory ssf=CommonsDataBase.getSsf();
	/*
	 *  SqlSession session=null;
		try {
			session=ssf.openSession();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
  
	 */
	public static List<SeoulVO> seoulLocationListData(Map map){
		SqlSession session=null;
	    List<SeoulVO> list=new ArrayList<SeoulVO>();
		try {
			session=ssf.openSession();
			list=session.selectList("seoulLocationListData",map);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return list;
	}
	
	public static int seoulLocationTotalPage(){
		SqlSession session=null;
	    int total=0;
		try {
			session=ssf.openSession();
			total=session.selectOne("seoulLocationTotalPage");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return total;
	}
	
	public static List<SeoulVO> seoulNatureListData(Map map){
		SqlSession session=null;
	    List<SeoulVO> list=new ArrayList<SeoulVO>();
		try {
			session=ssf.openSession();
			list=session.selectList("seoulNatureListData",map);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return list;
	}
	
	public static int seoulNatureTotalPage(){
		SqlSession session=null;
	    int total=0;
		try {
			session=ssf.openSession();
			total=session.selectOne("seoulNatureTotalPage");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return total;
	}
	
	
	public static List<SeoulVO> seoulShopListData(Map map){
		SqlSession session=null;
	    List<SeoulVO> list=new ArrayList<SeoulVO>();
		try {
			session=ssf.openSession();
			list=session.selectList("seoulShopListData",map);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return list;
	}
	
	public static int seoulShopTotalPage(){
		SqlSession session=null;
	    int total=0;
		try {
			session=ssf.openSession();
			total=session.selectOne("seoulShopTotalPage");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return total;
	}
	public static SeoulVO seoulLocationDetailData(int no){
		SqlSession session=null;
		SeoulVO vo=new SeoulVO();
		try {
			session=ssf.openSession();
			session.update("seoulLocationHitIncrement",no);
			session.commit();
			vo=session.selectOne("seoulLocationDetailData",no);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return vo;
	}
	public static List<FoodVO> seoulFoodData(String address){
		SqlSession session=null;
	    List<FoodVO> list=new ArrayList<FoodVO>();
		try {
			session=ssf.openSession();
			list=session.selectList("seoulFoodData",address);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return list;
	}
	
}
