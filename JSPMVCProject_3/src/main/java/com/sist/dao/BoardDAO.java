package com.sist.dao;
import java.util.*;
import java.sql.*;

import com.sist.dbcp.*;
import com.sist.vo.*;
public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private CreateDBCPConnection dbconn=new CreateDBCPConnection();
	private static BoardDAO dao;
	private final int ROWSIZE=10;
	
	// 기존 newInstance 메서드 수정
    public static BoardDAO newInstance() {
        if (dao == null)
            dao = new BoardDAO();
        return dao;
    }
	
	public List<BoardVO> BoardListData(int page){
		List<BoardVO> list=new ArrayList<BoardVO>();
try {
			
			conn=dbconn.getConnection();
			String sql="SELECT no,subject,name,To_CHAR(regdate,'yyyy-MM-dd'),hit,num "
					+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
					+ "FROM (SELECT no,subject,name,regdate,hit FROM jspBoard ORDER BY no DESC)) "
					+ "WHERE num BETWEEN ? AND ?";
		    ps=conn.prepareStatement(sql);
		    int start=(ROWSIZE*page)-(ROWSIZE-1);
		    int end=ROWSIZE*page;
		    ps.setInt(1, start);
		    ps.setInt(2, end);
		    ResultSet rs=ps.executeQuery();
		    while(rs.next())
		    {
		    	BoardVO vo=new BoardVO();
		    	vo.setNo(rs.getInt(1));
		    	vo.setSubject(rs.getString(2));
		    	vo.setName(rs.getString(3));
		    	vo.setDbday(rs.getString(4));
		    	vo.setHit(rs.getInt(5));
		    	list.add(vo);
		    }
		    rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			dbconn.disConnection(conn, ps);
		}
        return list;
        
	}
	public int boardTotalPage()
	{
		int total=0;
		try {
			conn=dbconn.getConnection();
			String sql="SELECT CEIL(COUNT(*)/10.0) FROM jspBoard";
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
	
	public void boardInsert(BoardVO vo)
	{
		try {
			conn=dbconn.getConnection();
			String sql="INSERT INTO jspBoard(no,name,subject,content,pwd) "
					+ "VALUES(jb_no_seq.nextval,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,vo.getName());
			ps.setString(2,vo.getSubject());
			ps.setString(3,vo.getContent());
			ps.setString(4,vo.getPwd());
			ps.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
	}
	
	public BoardVO boardDetailData(int no)
	{
		BoardVO vo=new BoardVO();
		try {
			conn=dbconn.getConnection();
			String sql="SELECT no,name,subject,content,hit,TO_CHAR(regdate,'yyyy-MM-dd') "
					+ "FROM jspBoard "
					+ "WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setHit(rs.getInt(5));
			vo.setDbday(rs.getString(6));
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
