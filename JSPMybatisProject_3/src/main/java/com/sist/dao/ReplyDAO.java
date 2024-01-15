package com.sist.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sist.vo.ReplyVO;

import oracle.jdbc.internal.OracleTypes;

public class ReplyDAO {
	private Connection conn;
	  private CallableStatement cs;
	  private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	  private static ReplyDAO dao;
	  // Config.xml
	  public ReplyDAO()
	  {
		  try
		  {
			  Class.forName("oracle.jdbc.driver.OracleDriver");
		  }catch(Exception ex) {}
	  }
	  public void getConnection()
	  {
		  try
		  {
			  conn=DriverManager.getConnection(URL,"hr","happy");
		  }catch(Exception ex) {}
	  }
	  public void disConnection()
	  {
		  try
		  {
			  if(cs!=null) cs.close();
			  if(conn!=null) conn.close();
		  }catch(Exception ex) {}
	  }
	  public static ReplyDAO newInstance() {
		   if (dao==null)
			   dao = new ReplyDAO();
			return dao;		   
	   }
	  public List<ReplyVO> replyListData(int type,int cno)
	  {
		  List<ReplyVO> list=new ArrayList<ReplyVO>();
		  try {
			  getConnection();
			  String sql="{CALL replyListData(?,?,?)}";
			  cs=conn.prepareCall(sql);
			  cs.setInt(1, cno);
			  cs.setInt(2, type);
			  // 문자,숫자,커서 => out변수인 경우ㅠ에만 사용
			  // OracleTypes.VARCHAR2
			  // OracleTypes.INTEGER => int
			  // OracleTypes.CURSOR => ResultSet
			  cs.registerOutParameter(3, OracleTypes.CURSOR);
			  cs.executeQuery();
			  ResultSet rs=(ResultSet)cs.getObject(3);
			  while(rs.next())
			  { 
				   //no,type,cno,id,name,msg,TO_CHAR
				  ReplyVO vo=new ReplyVO();
				  vo.setNo(rs.getInt(1));
				  vo.setType(rs.getInt(2));
				  vo.setCno(rs.getInt(3));
				  vo.setId(rs.getString(4));
				  vo.setName(rs.getString(5));
				  vo.setMsg(rs.getString(6));
				  vo.setDbday(rs.getString(7));
				  
				  list.add(vo);
			  }
		  }catch(Exception e) {
			  e.printStackTrace();
		  }finally {
			  disConnection();
		  }
		  return list;
		  
	  }
	  /*
	   * pType reply_all.type%TYPE,
         pCno reply_all.cno%TYPE,
         pId reply_all.id%TYPE,
         pName reply_all.name%TYPE,
         pMsg reply_all.msg%TYPE
	   * 
	   */
	  public void replyInsert(ReplyVO vo) {
		 try {
			 getConnection();
			 String sql="{CALL replyInsert(?,?,?,?,?)}";
			 cs=conn.prepareCall(sql);
			 cs.setInt(1, vo.getType());
			 cs.setInt(2, vo.getCno());
			 cs.setString(3, vo.getId());
			 cs.setString(4, vo.getName());
			 cs.setString(5, vo.getMsg());
			 cs.executeQuery();
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }finally {
			 disConnection();
		 }
	  }
}
