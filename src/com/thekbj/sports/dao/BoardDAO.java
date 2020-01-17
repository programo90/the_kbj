package com.thekbj.sports.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		sql.append(" insert into sp_board  (bno,bctg, btitle   )    ");
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
}