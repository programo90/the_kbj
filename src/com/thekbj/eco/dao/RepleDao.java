package com.thekbj.eco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thekbj.dto.ReplyDTO;
import com.thekbj.dto.TableDTO;

public class RepleDao {
	private static RepleDao dao=new RepleDao();
	public static RepleDao getDAO()
	{
		return dao;
	}
	public List<ReplyDTO> repListData(Connection conn, int bno) {
		List<ReplyDTO> list = new ArrayList<>();
		ResultSet rs=null;
		StringBuilder sql=new StringBuilder();
		
		sql.append("select re.rno, re.rcontent, re.rwrdate, re.bno, re.mno ");
		sql.append(",mem.mnick								               ");
		sql.append("from eco_reply re                                      ");
		sql.append("left outer join eco_board bo on bo.bno = re.bno        ");
		sql.append("left outer join member mem on mem.mno = bo.mno     ");
		sql.append("where bo.bno = ?                                      ");
		sql.append("order by 1 desc                                        ");
		
		try (PreparedStatement psmt=conn.prepareStatement(sql.toString())
			){
				psmt.setInt(1, bno);

				rs=psmt.executeQuery();
				while(rs.next()) {
					ReplyDTO dto=new ReplyDTO();
					dto.setRno(rs.getInt("rno"));
					dto.setRcontent(rs.getString("rcontent"));
					dto.setRwrdate(rs.getString("rwrdate"));
					dto.setBno(rs.getInt("bno"));
					dto.setMno(rs.getInt("mno"));
					dto.setMnick(rs.getString("mnick"));
					
					list.add(dto);
				}
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
		}
		
		return list;
	}
	public void repInsertData(Connection conn, ReplyDTO dto) throws SQLException {
		PreparedStatement pstmt=null;
		StringBuilder sql=new StringBuilder();
		sql.append(" insert into eco_reply(         	      ");
		sql.append(" 					 rcontent               ");
		sql.append(" 					,rwrdate             ");
		sql.append(" 					,bno	              ");
		sql.append(" 					,mno	              ");		
		sql.append(" 					)                     ");
		sql.append(" values (?,NOW(),?,?)                         ");
		
		
		try {
				pstmt=conn.prepareStatement(sql.toString());
				pstmt.setString(1, dto.getRcontent());
				pstmt.setInt(2, dto.getBno());
				pstmt.setInt(3, dto.getMno());
				pstmt.executeUpdate();
		}finally {
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
		}	
		
	}
	public int repRemoveData(Connection conn, int bno, int rno, int mno) throws SQLException {
		ReplyDTO dto=new ReplyDTO();
		StringBuilder sql=new StringBuilder();
		 sql.append(" delete                   ");
		 sql.append(" from eco_reply           ");
		 sql.append(" where bno=?              ");
		 sql.append(" and   rno=?              ");
		 sql.append(" and   mno=?              ");
		int result=0;
		try (PreparedStatement pstmt=conn.prepareStatement(sql.toString());
				)
			{
				 pstmt.setInt(1, bno);
				 pstmt.setInt(2, rno);
				 pstmt.setInt(3, mno);
				 result=pstmt.executeUpdate();
			}
		return result;
	}
	
}
