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
}
