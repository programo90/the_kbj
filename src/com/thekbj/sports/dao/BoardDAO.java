package com.thekbj.sports.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thekbj.dto.ReplyDTO;
import com.thekbj.dto.TableDTO;

public class BoardDAO {
	private static BoardDAO dao=new BoardDAO();
	private BoardDAO() {}
	public static BoardDAO getDAO()
	{
		return dao;
	}
	public List<TableDTO> boardListData(Connection conn) throws SQLException {
		StringBuilder sql=new StringBuilder();
		sql.append(" select        ");
		sql.append("       bno     ");
		sql.append("      ,bctg  ");
		sql.append("      ,btitle");
		sql.append(" from sp_board    ");
		List<TableDTO> arr=new ArrayList<>();
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());
			ResultSet rs=pstmt.executeQuery();) {
			while(rs.next())
			{
				TableDTO dto=new TableDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setBctg(rs.getString("bctg"));
				dto.setBtitle(rs.getString("btitle"));
				arr.add(dto);
			}
		}
		return arr;
	}
	public void boardInsertData(Connection conn, TableDTO dto) throws SQLException{
		StringBuilder sql=new StringBuilder();
		sql.append(" insert into sp_board  (bno, bctg, btitle   )    ");
		sql.append(" values (null,?,?)                              ");
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getBctg());
			pstmt.setString(2, dto.getBtitle());
			pstmt.executeUpdate();
		}finally {
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
		}
	}
	public TableDTO boardDetailData(Connection conn, int boardnum) throws SQLException {
		StringBuilder sql = new StringBuilder();
		ResultSet rs=null;
		sql.append(" select bno ,bctg     ");
		sql.append("       ,btitle  ");
		sql.append(" from   sp_board       ");
		sql.append(" where  bno=?      ");
		TableDTO dto=new TableDTO(); 
		try (PreparedStatement pstmt=conn.prepareStatement(sql.toString());){
			pstmt.setInt(1, boardnum);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				dto.setBno(rs.getInt("bno"));
				dto.setBctg(rs.getString("bctg"));
				dto.setBtitle(rs.getString("btitle"));
			}
		}finally {
		if(rs!=null)try {rs.close();}catch(SQLException e) {}
		}
		return dto;
	}
	public void boardRemoveData(Connection conn, int bno) throws SQLException {
		StringBuilder sql=new StringBuilder();
		sql.append("  delete from sp_board   ");
		sql.append("  where bno=?    ");
		try (PreparedStatement pstmt=conn.prepareStatement(sql.toString());){
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
		}
	}
	public void boardModifyResultData(Connection conn, TableDTO dto) throws SQLException {
		StringBuilder sql=new StringBuilder();
		sql.append("update sp_board  ");
		sql.append("   set           ");
		sql.append("    bctg=?       ");
		sql.append("   ,btitle=?     ");
		sql.append("   where         ");
		sql.append("   bno=?         ");
		int result=0;
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, dto.getBctg());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setInt(3, dto.getBno());
			result=pstmt.executeUpdate();
		}
	}
	public List<ReplyDTO> repListData(Connection conn, int bno) throws SQLException {
		StringBuilder sql=new StringBuilder();
		sql.append(" select sp_reply      ");
		sql.append("        ,rno  ");
		sql.append("        ,rcontent ");
		sql.append("        ,rwdate   ");
		sql.append(" from   repboard   ");
		sql.append(" where  bno=?  ");
		ResultSet rs=null;
		ArrayList<ReplyDTO> arr=new ArrayList<>();
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, bno);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				ReplyDTO dto=new ReplyDTO();
				dto.setRno(rs.getInt("rno"));
				dto.setRcontent(rs.getString("rcontent"));
				dto.setRwdate(rs.getString("rwdate"));
				dto.setBno(rs.getInt("bno"));
				arr.add(dto);
			}
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
		}
		return arr;
	}
}