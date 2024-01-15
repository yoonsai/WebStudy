package com.sist.dao;
import java.util.*;

import com.sist.dbcp.CreateDBCPConnection;
import com.sist.vo.SeoulVO;

import java.sql.*;
public class SeoulDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static SeoulDAO dao;
	private CreateDBCPConnection dbconn=new CreateDBCPConnection();
	private String[] tables= {"","seoul_location","seoul_nature","seoul_shop"};
	private final int ROWSIZE=12;
	public List<SeoulVO> seoulLocationListData(int page, String tab)
	{
		List<SeoulVO> list=new ArrayList<SeoulVO>();
		try {
			conn=dbconn.getConnection();
			String sql="SELECT no,title,poster,num "
					+ "FROM (SELECT no,title,poster,rownum as num "
					+ "FROM (SELECT no,title,poster FROM "+tab
					+ " ORDER BY no ASC)) "
					+ "WHERE num BETWEEN ? AND ?";
			ps=conn.prepareStatement(sql);
			int start=(ROWSIZE*page)-(ROWSIZE-1);
			int end=ROWSIZE*page;
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				SeoulVO vo=new SeoulVO();
				vo.setNo(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPoster(rs.getString(3));
				list.add(vo);		
			}
			rs.close();
		}catch(Exception e){
			
		}finally {
			dbconn.disConnection(conn, ps);
		}
		return list;
	}
	public int seoulLocationTotalPage(String tab)
	{
		int total=0;
		try {
			conn=dbconn.getConnection();
			String sql="SELECT CEIL(COUNT(*)/12.0) FROM "+tab;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
		}catch(Exception e){
			
		}finally {
			dbconn.disConnection(conn, ps);
		}
		return total;
	}
	
}
