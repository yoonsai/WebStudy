package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.dbcp.*;
public class FoodDAO {
	private Connection conn;
	private PreparedStatement ps;
	private CreateDBCPConnection  dbconn=new CreateDBCPConnection();
	private static FoodDAO dao;
	
	//기능 => 1.카테고리 읽기
	public List<FoodCategoryVO> food_category_data(){
		List<FoodCategoryVO> list =new ArrayList<FoodCategoryVO>();
		try {
			conn=dbconn.getConnection();
			String sql="SELECT cno,title,poster "
					+ "FROM food_category "
					+ "ORDER BY cno ASC";
			ps=conn.prepareStatement(sql);
		    ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    {
		    	FoodCategoryVO vo=new FoodCategoryVO();
		    	vo.setCno(rs.getInt(1));
		    	vo.setTitle(rs.getString(2));
		    	vo.setPoster(rs.getString(3));
		    	list.add(vo);
		    	
		    }
		    rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
		return list;
	}
	//기능 => 2. 로그인 => session (***)
	//=> 메뉴변경 => session
	//2. 전체 데이터 읽기
	public List<FoodVO> foodAllData(int page)
	{
		List<FoodVO> list =new ArrayList<FoodVO>();
		try {
			conn=dbconn.getConnection();
			String sql="SELECT fno,poster,name,num "
					+ "FROM (SELECT fno,poster,name,rownum as num "
					+ "FROM (SELECT fno,poster,name FROM food_menu_house "
					+ "ORDER BY fno ASC)) "
					+ "WHERE num BETWEEN ? AND ?";
			ps=conn.prepareStatement(sql);
			int rowSize=12;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps.setInt(1, start);
			ps.setInt(2, end);
		    ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    {
		    	FoodVO vo=new FoodVO();
		    	vo.setFno(rs.getInt(1));
		    	vo.setPoster(rs.getString(2));
		    	vo.setName(rs.getString(3));
		    	list.add(vo);
		    }
		    rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
		return list;
	}
	public int foodTotalPage()
	{
		int total=0;
		try {
			conn=dbconn.getConnection();
			String sql="SELECT CEIL(COUNT(*)/12.0) "
					+ "FROM food_menu_house ";
			ps=conn.prepareStatement(sql);
		    ResultSet rs=ps.executeQuery();
		    rs.next();
		    total=rs.getInt(1);
		    rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
		return total;
	}
	// 4. 검색 데이터 읽기
	   public List<FoodVO> foodFindData(int page,String fs,String ss)
	   {
	      List<FoodVO> list=
	            new ArrayList<FoodVO>();
	      try
	      {
	         conn=dbconn.getConnection();
	         String sql="SELECT fno,name,poster,num "
	               + "FROM (SELECT fno,name,poster,rownum as num "
	               + "FROM (SELECT fno,name,poster "
	               + "FROM food_menu_house WHERE "+fs+" LIKE '%'||?||'%' ORDER BY fno ASC)) "
	               + "WHERE num BETWEEN ? AND ?";
	         ps=conn.prepareStatement(sql);
	         int rowSize=12;
	         int start=(rowSize*page)-(rowSize-1);
	         int end=rowSize*page;
	         ps.setString(1, ss);
	         ps.setInt(2, start);
	         ps.setInt(3, end);
	         
	         ResultSet rs=ps.executeQuery();
	         while(rs.next())
	         {
	            FoodVO vo=new FoodVO();
	            vo.setFno(rs.getInt(1));
	            vo.setName(rs.getString(2));
	            vo.setPoster(rs.getString(3));
	            list.add(vo);
	         }
	         rs.close();
	      }catch(Exception ex)
	      {
	         ex.printStackTrace();
	      }
	      finally
	      {
	         dbconn.disConnection(conn, ps);
	      }
	      return list;
	   }
	   // 5. 검색 데이터 총페이지
	   public int foodFindTotalPage(String fs,String ss)
	   {
	      int total=0;
	      try
	      {
	         conn=dbconn.getConnection();
	         String sql="SELECT CEIL(COUNT(*)/12.0) "
	               + "FROM food_menu_house "
	               + "WHERE "+fs+" LIKE '%'||?||'%'";
	         ps=conn.prepareStatement(sql);
	         ps.setString(1, ss);
	         ResultSet rs=ps.executeQuery();
	         rs.next();
	         total=rs.getInt(1);
	         rs.close();
	      }catch(Exception ex)
	      {
	         ex.printStackTrace();
	      }
	      finally
	      {
	         dbconn.disConnection(conn, ps);
	      }
	      return total;
	   }
	}
