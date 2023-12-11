package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.dbcp.*;
public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private CreateDBCPConnection  dbconn=new CreateDBCPConnection();
	private static MemberDAO dao;
	
    //1.로그인
	public MemberVO isLogin(String id,String pwd)
	{
		//String에서 변경 => 암호화/복호화
		MemberVO vo=new MemberVO();
		try {
			conn=dbconn.getConnection();
			String sql="SELECT COUNT(*) FROM jspMember "
					+"WHERE id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			int count=rs.getInt(1);
			rs.close();
			if(count==0) //id가 없는 상태
			{
				vo.setMsg("NOID");
			}
			else {
				//session에 저장할 데이터
				sql="SELECT id,name,admin,pwd "
						+ "FROM jspMember "
						+ "WHERE id=?";
				//where id=+id => 오류남
				ps=conn.prepareStatement(sql);
				ps.setString(1,id);
				rs=ps.executeQuery();
				rs.next();
				String db_id=rs.getString(1);
				String name=rs.getString(2);
				String admin=rs.getString(3);
				String db_pwd=rs.getString(4);
				
				if(db_pwd.equals(pwd))
				{
					vo.setMsg("OK");
					vo.setId(db_id);
					vo.setName(name);
					vo.setAdmin(admin);
				}
				else {
					vo.setMsg("NOPWD");
				}
				rs.close();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			
		}
		return vo;
		
	}
}
