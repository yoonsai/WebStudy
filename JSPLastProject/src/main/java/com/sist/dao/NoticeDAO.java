package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.sist.dbcp.CreateDBCPConnection;
import com.sist.vo.*;

public class NoticeDAO {
	private Connection conn;
    private PreparedStatement ps;
    private CreateDBCPConnection dbconn=new CreateDBCPConnection();
    private static NoticeDAO dao;
    
    public static NoticeDAO newInstance() {
    	if(dao==null)
    		dao=new NoticeDAO();
    	return dao;
    }
    public List<NoticeVO> noticeTop7(){
    	List<NoticeVO> list=new ArrayList<NoticeVO>();
    	try {
    		conn=dbconn.getConnection();
    		String sql="SELECT no,type,subject,rownum "
    				+ "FROM (SELECT no,type,subject "
    				+ "FROM project_notice ORDER BY hit DESC) "
    				+ "WHERE rownum<=7";
    		ps=conn.prepareStatement(sql);
    		ResultSet rs=ps.executeQuery();
    		while(rs.next())
    		{
    			NoticeVO vo=new NoticeVO();
    			vo.setNo(rs.getInt(1));
    			vo.setType(rs.getString(2));
    			vo.setSubject(rs.getString(3));
    			list.add(vo);
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		dbconn.disConnection(conn, ps);
    	}
    	return list;
    }
}
