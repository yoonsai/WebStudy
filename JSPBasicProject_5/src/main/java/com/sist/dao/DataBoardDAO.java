package com.sist.dao;
import java.util.*;
import java.sql.*;

import com.sist.dao.*;
import com.sist.common.*;
//재사용이 많은 경우, 유효한 내용이 있는 경우
/* 
 *   1. JDBC
 *   2. DBCP ==> 
 *   3. Spring.jar
 *   =============== 라이브러리 => List, VO => 전체 통합
 *                           => MyBatis
 *                           
 * 
 */
public class DataBoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private CreateConnection dbconn=new CreateConnection();
	
	public List<DataBoardBean> boardListData(int page)
	{
		List<DataBoardBean> list=new ArrayList<DataBoardBean>();
		try {
			conn=dbconn.getConnection();
			String sql="SELECT no,subject,name,regdate,hit "
					+ "FROM dataBoard ORDER BY no ASC";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				DataBoardBean vo=new DataBoardBean();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setRegdate(rs.getDate(4));
				vo.setHit(rs.getInt(5));
				list.add(vo);
			}
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			dbconn.disConnection(conn, ps);
		}
		return list;
	}
	public void boardInsert(DataBoardBean vo){
		try{
			conn=dbconn.getConnection();
			String sql="INSERT INTO dataBoard(no,name,subject,content,pwd,filename,filesize) "
					+ "VALUES(db_no_seq.nextval,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,vo.getName());
			ps.setString(2,vo.getSubject());
			ps.setString(3,vo.getContent());
			ps.setString(4,vo.getPwd());
			ps.setString(5,vo.getFilename());
			ps.setInt(6,vo.getFilesize());
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
	}
	
	//상세보기
	public DataBoardBean boardDetailData(int no){
		DataBoardBean vo=new DataBoardBean();
		try {
			conn=dbconn.getConnection();
			String sql="UPDATE databoard SET "
					+ "hit=hit+1 "
					+ "WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();
			
			sql="SELECT no,subject,name,regdate,hit,filename,filesize,content "
					+ "FROM databoard "
					+ "WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setSubject(rs.getString(2));
			vo.setName(rs.getString(3));
			vo.setRegdate(rs.getDate(4));
			vo.setHit(rs.getInt(5));
			vo.setFilename(rs.getString(6));
			vo.setFilesize(rs.getInt(7));		
			vo.setContent(rs.getString(8));
			rs.close();
		}catch(Exception e)
		{e.printStackTrace();}
		finally {
			dbconn.disConnection(conn, ps);
		}
		return vo;
	}
	public void boardDelete(int no)
	{
		try {
			conn=dbconn.getConnection();
			String sql="DELETE FROM dataBoard WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();

		}catch(Exception e)
		{e.printStackTrace();}
		finally {
			dbconn.disConnection(conn, ps);
		}
	}
	public DataBoardBean boardFileInfoData(int no)
	{
		DataBoardBean vo=new DataBoardBean();
		try {
			conn=dbconn.getConnection();
			String sql="SELECT filename,filesize FROM dataBoard WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setFilename(rs.getString(1));
			vo.setFilesize(rs.getInt(2));
			rs.close();
			
			sql="";
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
		return vo;
	}
}
