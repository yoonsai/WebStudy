package com.sist.dao;
import java.util.*;

import com.sist.bean.BoardBean;

import java.sql.*;
public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	public BoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void getConnection()
	{
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception e)
		{
			
		}
	}
	public void disConnection() {
		try {
			if(conn!=null) conn.close();
			if(ps!=null) ps.close();
		}catch(Exception e)
		{
			
		}
	}
	public List<BoardBean> boardListData(){
		List<BoardBean> list=new ArrayList<BoardBean>();
		try{
			getConnection();
			String sql="SELECT no,subject,name,regdate,hit "
					+ "FROM jspBoard ORDER BY no ASC";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				BoardBean vo=new BoardBean();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setRegdate(rs.getDate(4));
				vo.setHit(rs.getInt(5));
				list.add(vo);
			}
			rs.close();
		 }
		catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return list;
	}
	
	public void boardInsert(BoardBean vo){
		try{
			getConnection();
			String sql="INSERT INTO jspBoard(no,name,subject,content,pwd) "
					+ "VALUES(jb_no_seq.nextval,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,vo.getName());
			ps.setString(2,vo.getSubject());
			ps.setString(3,vo.getContent());
			ps.setString(4,vo.getPwd());
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			disConnection();
		}
	}
	
}
