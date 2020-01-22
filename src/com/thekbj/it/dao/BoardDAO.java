package com.thekbj.it.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thekbj.dto.ReplyDTO;
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
				dto.setMnick(rs.getString("mnick"));
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

	public TableDTO boardDetailData(Connection conn, int bno) throws SQLException{
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();

		sql.append(" select bno, btitle, bcontent, bwrdate, btag, bviewcount, brecount, blikecount, bimg, mnick, mscore, m.mno  ");
		sql.append(" from it_board b inner join it_member m																		");
		sql.append(" on b.mno = m.mno																							");
		sql.append(" where bno = ?																								");

		TableDTO dto = new TableDTO();
		ResultSet rs = null;
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			pstmt.setInt(1, bno);

			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setBno(rs.getInt("bno"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBcontent(rs.getString("bcontent"));
				dto.setBwrdate(rs.getString("bwrdate"));
				dto.setBtag(rs.getString("btag"));
				dto.setBviewcount(rs.getInt("bviewcount"));
				dto.setBrecount(rs.getInt("brecount"));
				dto.setBlikecount(rs.getInt("blikecount"));
				dto.setBimg(rs.getString("bimg"));
				dto.setMnick(rs.getString("mnick"));
				dto.setMscore(rs.getInt("mscore"));
				dto.setMno(rs.getInt("m.mno"));
			}
		} finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {e.printStackTrace();}
		}
		return dto;
	}

	public List<ReplyDTO> repListData(Connection conn, int bno) throws SQLException{
		// TODO Auto-generated method stub
		List<ReplyDTO> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();

		sql.append(" select rno, bno, rcontent, rwrdate, m.mnick, m.mno	");
		sql.append(" from it_reply r inner join it_member m				");
		sql.append(" on r.mno = m.mno									");
		sql.append(" where bno = ?										");


		ResultSet rs = null;

		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			pstmt.setInt(1, bno);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				ReplyDTO dto = new ReplyDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setRno(rs.getInt("rno"));
				dto.setRwrdate(rs.getString("rwrdate"));
				dto.setRcontent(rs.getString("rcontent"));
				dto.setMnick(rs.getString("mnick"));
				dto.setMno(rs.getInt("mno"));

				list.add(dto);
			}
		} finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {e.printStackTrace();}
		}

		return list;
	}

	public void updateViewcountData(Connection conn, int bno) throws SQLException{
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" update it_board					");
		sql.append(" set bviewcount = bviewcount+1		");
		sql.append(" where bno = ?						");

		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
		}

	}

	public void repInsertData(Connection conn, ReplyDTO dto) throws SQLException{
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into it_reply( bno, rcontent, rwrdate, mno)		");
		sql.append(" value( ?, ?, now(), ?);								");

		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString()); 
				) {
			pstmt.setInt(1, dto.getBno());
			pstmt.setString(2, dto.getRcontent());
			pstmt.setInt(3, dto.getMno());

			pstmt.executeUpdate();
		}
	}
	public void boardRecountIncrease(Connection conn, ReplyDTO dto) throws SQLException{
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" update it_board					");
		sql.append(" set brecount = brecount+1			");
		sql.append(" where bno = ?						");

		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			pstmt.setInt(1, dto.getBno());
			pstmt.executeUpdate();
		}
	}


	public void repRemoveData(Connection conn, int rno) throws SQLException{
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from it_reply		");
		sql.append(" where rno = ?				");

		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString()); 
				) {
			pstmt.setInt(1, rno);

			pstmt.executeUpdate();
		}

	}
	
	public void boardRecountDecrease(Connection conn, int bno) throws SQLException{
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" update it_board					");
		sql.append(" set brecount = brecount-1		");
		sql.append(" where bno = ?						");

		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
		}
	}

	public void boardInsertData(Connection conn, TableDTO dto) throws SQLException{
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		
		if("".equals(dto.getBimg())) {
			sql.append(" insert into it_board(bctg, btitle, bcontent, bwrdate, bviewcount, btag, brecount, blikecount, mno)	");
			sql.append(" values( ?, ?, ?, now(), 0, ?, 0, 0, ?) 																	");
			
		} else {
			sql.append(" insert into it_board(bctg, btitle, bcontent, bwrdate, bviewcount, btag, brecount, blikecount, bimg, mno)	");
			sql.append(" values( ?, ?, ?, now(), 0, ?, 0, 0, ?, ?) 																	");
			
		}
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString()); 
				) {

			pstmt.setString(1, dto.getBctg());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setString(4, dto.getBtag());
			if("".equals(dto.getBimg())) { 
				pstmt.setInt(5, dto.getMno());
			} else {
				pstmt.setString(5, dto.getBimg());
				pstmt.setInt(6, dto.getMno());				
			}

			pstmt.executeUpdate();
		}
	}

	public void boardRemoveData(Connection conn, int bno) throws SQLException{
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from it_board		");
		sql.append(" where bno = ?				");
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString()); 
				) {
			pstmt.setInt(1, bno);

			pstmt.executeUpdate();
		}
	}

	public TableDTO boardModifyData(Connection conn, int bno) throws SQLException {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();

		sql.append(" select bno, btitle, bcontent, bwrdate, btag, bviewcount, brecount, blikecount, bimg, mnick, mscore, m.mno  ");
		sql.append(" from it_board b inner join it_member m																		");
		sql.append(" on b.mno = m.mno																							");
		sql.append(" where bno = ?																								");

		TableDTO dto = new TableDTO();
		ResultSet rs = null;
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			pstmt.setInt(1, bno);

			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setBno(rs.getInt("bno"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBcontent(rs.getString("bcontent"));
				dto.setBwrdate(rs.getString("bwrdate"));
				dto.setBtag(rs.getString("btag"));
				dto.setBviewcount(rs.getInt("bviewcount"));
				dto.setBrecount(rs.getInt("brecount"));
				dto.setBlikecount(rs.getInt("blikecount"));
				dto.setBimg(rs.getString("bimg"));
				dto.setMnick(rs.getString("mnick"));
				dto.setMscore(rs.getInt("mscore"));
				dto.setMno(rs.getInt("m.mno"));
			}
		} finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {e.printStackTrace();}
		}
		return dto;
	}

	public void boardModifyResultData(Connection conn, TableDTO dto) throws SQLException{
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" update it_board										");
		sql.append(" set bctg=? ,btag=? ,btitle=?, bcontent=?, bimg=?		");
		sql.append(" where bno = ?											");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			pstmt.setString(1, dto.getBctg());
			pstmt.setString(2, dto.getBtag());
			pstmt.setString(3, dto.getBtitle());
			pstmt.setString(4, dto.getBcontent());
			pstmt.setString(5, dto.getBimg());
			pstmt.setInt(6, dto.getBno());
			pstmt.executeUpdate();
		}
	}

	public void increseLikecount(Connection conn, int bno) throws SQLException {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" update it_board				 ");
		sql.append(" set blikecount = blikecount+1	 ");
		sql.append(" where bno = ?					 ");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
		}
	}

	public int getLikecount(Connection conn, int bno) throws SQLException{
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" select blikecount		");
		sql.append(" from it_board			");
		sql.append(" where bno = ?			");

		int blikecount = 0;
		ResultSet rs = null;
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString()); 
					) {
			
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				blikecount = rs.getInt(1);
			}
		} finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {e.printStackTrace();}
		}
		
		return blikecount;
	}

	public boolean searchLike(Connection conn, int bno, int mno) throws SQLException{
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" select count(*)				");
		sql.append(" from it_like					");
		sql.append(" where bno = ?	and mno =?		");

		boolean tf = true;
		ResultSet rs = null;
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString()); 
					) {
			pstmt.setInt(1, bno);
			pstmt.setInt(2, mno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getInt(1)!=0)
				tf = false;
			}
		} finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {e.printStackTrace();}
		}
		return tf;
	}

	public void likeInsertData(Connection conn, int bno, int mno) throws SQLException{
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into it_like(bno, mno)	");
		sql.append(" values( ? , ? )				");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			pstmt.setInt(1, bno);
			pstmt.setInt(2, mno);
			pstmt.executeUpdate();
		}
	}

	public void increaseMscore(Connection conn, int mno) throws SQLException {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" update it_member					");
		sql.append(" set mscore = mscore+1			");
		sql.append(" where mno = ?						");

		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			pstmt.setInt(1, mno);
			pstmt.executeUpdate();
		}
	}

}
