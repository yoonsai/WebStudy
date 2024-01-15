package com.sist.dao;

import java.sql.*;
import java.util.*;
import com.sist.dbcp.*;
public class FoodDAO {
	private Connection conn;
	private PreparedStatement ps;
	private CreateDBCPConnection dbconn=new CreateDBCPConnection();
	private static FoodDAO dao;
	
	public static FoodDAO newInstance()
	{
		if(dao==null)
			dao=new FoodDAO();
		return dao;
	}
	public List<FoodVO> foodListData(int page)
	{
		List<FoodVO> list=new ArrayList<FoodVO>();
		try {
			conn=dbconn.getConnection();
			String sql="SELECT name,poster,num "
					+ "FROM (SELECT name,poster,rownum as num "
					+ "FROM (SELECT name,poster FROM food_menu_house "
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
				vo.setName(rs.getString(1));
				vo.setPoster("https://www.menupan.com"+rs.getString(2));
				list.add(vo);
			}
			rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			dbconn.disConnection(conn, ps);
		}
		return list;
	}
	public int totalPage()
	{
		int total=0;
		try {
			conn=dbconn.getConnection();
			String sql="SELECT CEIL(COUNT(*)/12.0) "
					+ "FROM food_menu_house";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			dbconn.disConnection(conn, ps);
		}
		return total;
	}
}
