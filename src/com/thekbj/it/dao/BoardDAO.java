package com.thekbj.it.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thekbj.dto.TableDTO;

public class BoardDAO {
	private static BoardDAO dao = new BoardDAO();
	public static BoardDAO getInstance() {
		return dao;
	}
	public List<TableDTO> boardListData(Connection conn, int startRow, int endRow, String searchTag, String searchtxt) throws SQLException{
		// TODO Auto-generated method stub
		List<TableDTO> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" select bno, btitle, bwrdate, bviewcount, btag, brecount, blikecount, bimg, mnick	");
		sql.append(" from it_board b inner join it_member m												");
		sql.append(" on	b.mno = m.mno																	");
		sql.append(" where bno = ?																		");
		
		ResultSet rs = null;
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				TableDTO dto = new TableDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBwrdate(rs.getString("bwrdate"));
				dto.setBviewcount(rs.getInt("bviewcount"));
				dto.setBtag(rs.getString("btag"));
				dto.setBrecount(rs.getInt("brecount"));
				dto.setBlikecount(rs.getInt("blikecount"));
				dto.setBimg(rs.getString("bimg"));
				//dto.setBwriter(rs.getString("mnick"))
				list.add(dto);
			}
		} finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {e.printStackTrace();}
		}
		
		return list;
	}
	
	
}
