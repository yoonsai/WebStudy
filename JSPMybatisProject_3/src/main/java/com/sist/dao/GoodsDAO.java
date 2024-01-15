package com.sist.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.CartVO;
import com.sist.vo.GoodsVO;


public class GoodsDAO {
	private static SqlSessionFactory ssf=
		    CommonsDataBase.getSsf();
   public static List<GoodsVO> goodsListData(Map map)
   {
	   List<GoodsVO> list=
			     new ArrayList<GoodsVO>();
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   list=session.selectList("goodsListData",map);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return list;
   }
   public static int goodsTotalPage(Map map)
   {
	   int total=0;
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   total=session.selectOne("goodsTotalPage",map);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return total;
   }
   public static GoodsVO goodsDetailData(Map map)
   {
	   GoodsVO vo=new GoodsVO();
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   vo=session.selectOne("goodsDetailData",map);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return vo;
   }
   
   public static void cartgoodsInsert(CartVO vo)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession(true);
		   
		   int count=session.selectOne("cartIsgoodsCount",vo);
		   if(count!=0)
		   {
			   //존재한다면 => 수량만 증가
			   session.update("cartgoodsUpdate",vo);
		   }
		   else
		   {
			   session.insert("cartgoodsInsert",vo);
		   }
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
   }
   public static List<CartVO> mypageGoodsCartData(Map map)
   {
	   List<CartVO> list=new ArrayList<CartVO>();
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   list=session.selectList("mypageGoodsCartData",map);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return list;
   }
   public static void goodsBuyInsert(CartVO vo)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession(true);
		   session.selectList("goodsBuyInsert",vo);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
   }
   public static List<CartVO> mypageGoodsBuyData(Map map)
   {
	   List<CartVO> list=new ArrayList<CartVO>();
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   list=session.selectList("mypageGoodsBuyData",map);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return list;
   }
   public static void cartDelete(int cart_no)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession(true);
		   session.selectList("cartDelete",cart_no);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }

	   
    }
   
   public static void goodsCartBuy(int cart_no)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession(true);
		   session.selectList("goodsCartBuy",cart_no);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
   }
}