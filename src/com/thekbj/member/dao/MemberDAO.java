package com.thekbj.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.thekbj.dto.MemberDTO;

public class MemberDAO {
	private static MemberDAO dao = new MemberDAO();
	
	private MemberDAO() {}

	public static MemberDAO getDao() {
		return dao;
	}

	public MemberDTO LoginComfirmData(Connection conn, String id, String newmpw) throws SQLException{
		// TODO Auto-generated method stub
		System.out.println("MemberLoginSessionAction : 로그인 DAO 요청");
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from member 	 ");
		sql.append(" where mid = ?			 ");
		
		ResultSet rs = null;
		
		
		MemberDTO dto = new MemberDTO();
		
		try ( PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
			pstmt.setString(1, id); 
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				int mno = rs.getInt("mno");
				String mpw = rs.getString("mpw");
				String mid = rs.getString("mid");    
				String mname = rs.getString("mname");      
				String mbdate = rs.getString("mbdate");    
				String memail= rs.getString("memail");      
				String mnick = rs.getString("mnick");       
				int mscore = rs.getInt("mscore"); 
				String mjoindate= rs.getString("mjoindate");    
				String mimg= rs.getString("mimg");
				
				dto.setMno(mno);
				dto.setMid(mid);
				dto.setMpw(mpw);
				dto.setMname(mname);
				dto.setMbdate(mbdate);
				dto.setMemail(memail);
				dto.setMnick(mnick);
				dto.setMscore(mscore);
				dto.setMjoindate(mjoindate);
				dto.setMimg(mimg);
			}
			
			
		}finally {
			try { if(rs != null) rs.close(); }catch(SQLException e){}
		}
		
		return dto;
	}

		
	
}
