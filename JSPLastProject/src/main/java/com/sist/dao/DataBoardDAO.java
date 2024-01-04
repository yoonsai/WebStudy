package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.*;
import java.io.*;
public class DataBoardDAO {
   private static SqlSessionFactory ssf;
   static
   {
	   // xml => parse
	   try
	   {
		   Reader reader=Resources.getResourceAsReader("Config.xml");
		   ssf=new SqlSessionFactoryBuilder().build(reader);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
   }
   // => 단순 (1. JOIN , 2. 동적쿼리) 
   //  목록 출력 
   public static List<DataboardVO> databoardListData(Map map)
   {
	   SqlSession session=null;
	   List<DataboardVO> list=new ArrayList<DataboardVO>();
	   try
	   {
		   session=ssf.openSession();
		   list=session.selectList("databoardListData",map);
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
   public static int databoardRowCount()
   {
	   SqlSession session=null;
	   int count=0;
	   try
	   {
		   // getConnection()
		   session=ssf.openSession();
		   count=session.selectOne("databoardRowCount");
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close(); // 반환 => disConnection()
		   // => Connection/PreparedStatement
	   }
	   return count;
   }
   public static void databoardInsert(DataboardVO vo)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession(true);//autocommit
		   session.insert("databoardInsert",vo);
		   //session.commit(); => update,delete
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
   
   public static DataboardVO databoardDetailData(int no)
   {
	   /*
	    *   if(type==1)
		   {
			   String sql="UPDATE project_board SET "
					     +"hit=hit+1 "
					     +"WHERE no="+no;
			   ps=conn.prepareStatement(sql);
			   ps.executeUpdate();
			   ps.close();
		   }
		   
		   String sql="SELECT no,name,subject,content,"
				     +"TO_CHAR(regdate,'YYYY-MM-DD'),hit "
				     +"FROM project_board "
				     +"WHERE no="+no;
	    */
	   DataboardVO vo=new DataboardVO();
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession(true);
		   session.update("hitIncrement",no);
		   vo=session.selectOne("databoardDetailData",no);
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
   public static DataboardVO databoardFileInfoData(int no)
   {
	   DataboardVO vo=new DataboardVO();
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   vo=session.selectOne("databoardFileInfoData",no);
	   }catch(Exception e) {
		   e.printStackTrace();
	   }finally {
		   if(session!=null)
			   session.close();
	   }
	   return vo;
   }
   public static String databoardDelete(int no,String pwd) {
	   String res="no";
	   SqlSession session=ssf.openSession(true);
	   String db_pwd=session.selectOne("databoardGetPassword",no);
	   if(db_pwd.equals(pwd))
	   {
		   res="yes";
		   session.delete("databoardDelete",no);
	   }
		/*
		 * try {
		 * 
		 * }catch(Exception e) { e.printStackTrace(); }finally { if(session!=null)
		 * session.close(); }
		 */
	   return res;
   }
   public static DataboardVO databoardUpdateData(int no) {
	   SqlSession session=ssf.openSession();
	   DataboardVO vo=session.selectOne("databoardDetailData",no);
	   session.close();
	   return vo;
   }
   
   public static String databoardUpdate(DataboardVO vo) {
	   String result="no";
	   SqlSession session=ssf.openSession(true);
	   String db_pwd=session.selectOne("databoardGetPassword",vo.getNo());
	   if(db_pwd.equals(vo.getPwd()))
	   {
		   result="yes";
		   session.update("databoardUpdate",vo);
	   }
	   else {
		   result="no";
	   }
	   session.close();
	   return result;
   }
}