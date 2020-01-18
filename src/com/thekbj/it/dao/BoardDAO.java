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
	
	public List<TableDTO> boardListData(Connection conn, String bctg,String btag,int startRow, int endRow, String searchType, String searchtxt) throws SQLException{
		// TODO Auto-generated method stub
		List<TableDTO> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select bno, btitle, bwrdate, bviewcount, btag, brecount, blikecount, bimg, mnick	");
		sql.append(" from it_board b inner join it_member m												");
		sql.append(" on	b.mno = m.mno																	");
		sql.append(" where bctg = ?																		");
		
		if(!btag.equals("")) {
			sql.append("			and btag = ? 														");
		}
		
		if((!searchType.equals(""))&&(!searchtxt.equals(""))) {
			if(searchType.equals("btitle")) {
				sql.append("		and btitle like ? 													");
			} else if(searchType.equals("bcontent")) {
				sql.append("		and bcontent like ?													");
			} else if(searchType.equals("mnick")) {
				sql.append("			and mnick like ?												");
			} 
		}
		sql.append(" order by bno desc																	");
		sql.append(" limit ?,10;																		");

		
		ResultSet rs = null;
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			
			pstmt.setString(1, bctg);
			
			if(!btag.equals("")) {
				pstmt.setString(2, btag);
				if((!searchType.equals(""))&&(!searchtxt.equals(""))) {
					pstmt.setString(3, "%"+searchtxt+"%");
					pstmt.setInt(4, startRow-1);
				} else {
					pstmt.setInt(3, startRow-1);
				}
			} else {
				if((!searchType.equals(""))&&(!searchtxt.equals(""))) {
					pstmt.setString(2, "%"+searchtxt+"%");
					pstmt.setInt(3, startRow-1);
				} else {
					pstmt.setInt(2, startRow-1);
				}
			}
			

			
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

	public int getTotalCountData(Connection conn) throws SQLException{
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" select count(*)	");
		sql.append(" from it_board		");
		
		int totalCount = 0;
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString()); 
			ResultSet rs = pstmt.executeQuery();	) {
			if(rs.next()) {
				totalCount = rs.getInt(1);
			}
		}
		return totalCount;
	}
	
	
}
