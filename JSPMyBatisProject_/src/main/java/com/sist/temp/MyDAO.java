package com.sist.temp;
import java.util.*;
import java.sql.*;
import com.sist.vo.FoodVO;
import com.sist.vo.ReserveDayVO;
public class MyDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	public MyDAO()
	  {
		  try
		  {
			  Class.forName("oracle.jdbc.driver.OracleDriver");
		  }catch(Exception ex) {}
	  }
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void disConnection() {
		try {
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public List<Integer> foodNumberData()
	{
		 List<Integer> list=new ArrayList<Integer>();
		 try {
			 getConnection();
			 String sql="SELECT fno FROM food_menu_house "
			 		+ "ORDER BY fno ASC";
			 ps=conn.prepareStatement(sql);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next())
			 {
				 int fno=rs.getInt(1);
				 list.add(fno);
				 
			 }
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }finally {
			 disConnection();
		 }
		 return list;
	}
	public void foodDayInsert(FoodVO vo)
	{
		 try {
			 getConnection();
			 String sql="UPDATE food_menu_house SET "
			 		+ "rday=? "
			 		+ "WHERE fno=?";
			 ps=conn.prepareStatement(sql);
			 ps.setString(1, vo.getRday());
			 ps.setInt(2, vo.getFno());
			 ps.executeUpdate();
			 
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }finally {
			 disConnection();
		 }
	}
	public void reserveTimeInsert(ReserveDayVO vo)
	{
		 try {
			 getConnection();
			 String sql="INSERT INTO reserve_day VALUES(?,?)";
			 ps=conn.prepareStatement(sql);
			 ps.setInt(1, vo.getRno());
			 ps.setString(2, vo.getRtime());
			 ps.executeUpdate();
			 
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }finally {
			 disConnection();
		 }
	}
}
