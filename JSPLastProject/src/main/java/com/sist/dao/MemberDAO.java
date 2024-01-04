package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.dbcp.*;
import com.sist.vo.*;
public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private CreateDBCPConnection dbconn=new CreateDBCPConnection();
	private static MemberDAO dao;
	/*
	 * 
	 * try {
			conn=dbconn.getConnection();
			String sql="";
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
	 * 
	 * 
	 * */
	public static MemberDAO newInstance()
	{
		if(dao==null)
			dao=new MemberDAO();
		return dao;
	}
	// id중복체크
	public int memberIdCheck(String id)
	{
		int count=0;
		try {
			conn=dbconn.getConnection();
			String sql="SELECT COUNT(*) FROM project_member "
					+ "WHERE id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			count=rs.getInt(1);
			rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
		
		return count;
	}
	public List<ZipcodeVO> postfind(String dong)
	{
		List<ZipcodeVO> list=new ArrayList<ZipcodeVO>();
		try {
			conn=dbconn.getConnection();
			String sql="SELECT zipcode,sido,gugun,dong,NVL(bunji,' ') FROM zipcode "
					+ "WHERE dong LIKE '%'||?||'%'";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dong);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
			   ZipcodeVO vo=new ZipcodeVO();
			   vo.setZipcode(rs.getString(1));
			   vo.setSido(rs.getString(2));
			   vo.setGugun(rs.getString(3));
			   vo.setDong(rs.getString(4));
			   vo.setBunji(rs.getString(5));
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
	public int postFindCount(String dong)
	{
		int count=0;
		try {
			conn=dbconn.getConnection();
			String sql="SELECT COUNT(*) FROM zipcode "
					+ "WHERE dong LIKE '%'||?||'%'";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dong);
			ResultSet rs=ps.executeQuery();
			rs.next();
			count=rs.getInt(1);
			rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
		return count;
	}
	public void MemberInsert(MemberVO vo)
	{
		try {
			conn=dbconn.getConnection();
			String sql="INSERT INTO project_member VALUES(?,?,?,?,?,?,?,?,?,?,?,'n',SYSDATE)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPwd());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getSex());
			ps.setString(5, vo.getBirthday());
			ps.setString(6, vo.getEmail());
			ps.setString(7, vo.getPost());
			ps.setString(8, vo.getAddr1());
			ps.setString(9, vo.getAddr2());
			ps.setString(10, vo.getPhone());
			ps.setString(11, vo.getContent());
			ps.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
	}
	public MemberVO memberLogin(String id,String pwd)
	{
		MemberVO vo=new MemberVO();
		try {
			conn=dbconn.getConnection();
			String sql="SELECT COUNT(*) FROM project_member WHERE id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			int count=rs.getInt(1);
			rs.close();
			
			if(count==0)
			{
				vo.setMsg("NOID");
			}
			else {
				sql="SELECT id,name,pwd,admin FROM project_member "
						+ "WHERE id=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				rs=ps.executeQuery();
				rs.next();
				String db_id=rs.getString(1);
				String db_name=rs.getString(2);
				String db_pwd=rs.getString(3);
				String db_admin=rs.getString(4);

				 if(db_pwd.equals(pwd))
				  {
					  vo.setId(db_id);
					  vo.setName(db_name);
					  vo.setAdmin(db_admin);
					  vo.setMsg("OK");
				  }
				  else
				  {
					  vo.setMsg("NOPWD");
				  }
				
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
		return vo;
	}
	
}