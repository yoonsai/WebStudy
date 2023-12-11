package com.sist.dao;
import java.sql.*;
import java.util.*;
import com.sist.dbcp.*;
import com.sist.dao.*;
public class FoodDAO {
	private Connection conn;
	private PreparedStatement ps;
	private CreateDBCPConnection dbconn=new CreateDBCPConnection();
	private static FoodDAO dao;
	
	public static FoodDAO newInstance() {
		if(dao==null)
			dao=new FoodDAO();
		return dao;
	}
	
	public List<FoodVO> foodListData(int page, String fd, String ss)
	{
		List<FoodVO> list=new ArrayList<FoodVO>();
		try{
			conn=dbconn.getConnection();
			String sql="SELECT fno,poster,name,address,num "
					+ "FROM (SELECT fno,poster,name,address,rownum as num "
					+ "FROM (SELECT fno,poster,name,address "
					+ "FROM food_menu_house "
					+ "WHERE "+fd+" LIKE '%'||?||'%' "
					+ "ORDER BY fno ASC)) "
					+ "WHERE num BETWEEN ? AND ?";
			// 컬럼명 / 테이블명은 ? 로 처리할 수 없다
			// ps.setString(1,fd) => filedata 컬럼명 => address
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
				vo.setPoster(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setAddress(rs.getString(4));
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
	// 총페이지
	public int foodTotalPage(String fd,String ss)
	{
		int total=0;
		try {
			conn=dbconn.getConnection();
			String sql="SELECT CEIL(COUNT(*)/12.0) "
					+ "FROM food_menu_house "
					+ "WHERE "+fd+" LIKE '%'||?||'%'";
			ps=conn.prepareStatement(sql);
			ps.setString(1,ss);
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
	// 상세보기
	public FoodVO foodDetailData(int fno)
	{
		FoodVO vo=new FoodVO();
		try {
			conn=dbconn.getConnection();
			String sql="SELECT fno,Poster,name,type,address,phone,score,theme,price,time,seat,content "
					+ "FROM food_menu_house "
					+ "WHERE fno="+fno;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setFno(rs.getInt(1));
			vo.setPoster(rs.getString(2));
			vo.setName(rs.getString(3));
			vo.setType(rs.getString(4));
			vo.setAddress(rs.getString(5));
			vo.setPhone(rs.getString(6));
			vo.setScore(rs.getDouble(7));
			vo.setTheme(rs.getString(8));
			vo.setPrice(rs.getString(9));
			vo.setTime(rs.getString(10));
			vo.setSeat(rs.getString(11));
			vo.setContent(rs.getString(12));
			rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
		return vo;
		
	}
}
