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
	public List<TableDTO> boardListData(String bview, Connection conn, int startrow, int pagepercount, String search, String txtsearch) throws SQLException {
		StringBuilder sql=new StringBuilder();
		sql.append(" select bctg ,bno, btitle, bwrdate, bviewcount, btag,  blikecount, bimg, m.mnick, m.mno,brecount	");
		sql.append(" from sp_board b inner join member m												");
		sql.append(" on	b.mno = m.mno																	");
		if(!search.equals("") && !txtsearch.equals("")) {
			if(search.equals("title")) {
				sql.append(" where btitle like ? ");
			}else if(search.equals("mnick")) {
				sql.append(" where mnick like ? ");
			}else if(search.equals("bcontent")) {
				sql.append(" where bcontent like ? ");
			}
		}
		if(bview.equals("view")) {
	         sql.append("  order   by   bviewcount desc ");
	      }else if(bview.equals("reply")) {
	    	  sql.append(" order by brecount desc");
	      }
		else {
	    	  sql.append(" 		order by bno  desc		");
	      }
		sql.append(" limit ?,?										");
		
		List<TableDTO> list = new ArrayList<>();
		ResultSet rs=null;
		System.out.println(sql);
		try (PreparedStatement psmt=conn.prepareStatement(sql.toString())
			){
				if(!search.equals("") && !txtsearch.equals("")) {
					psmt.setString(1, "%"+txtsearch+"%");
					psmt.setInt(2, startrow);
					psmt.setInt(3, pagepercount);
				}else {
					psmt.setInt(1, startrow);
					psmt.setInt(2, pagepercount);
				}

				rs=psmt.executeQuery();
				while(rs.next()) {
					TableDTO dto=new TableDTO();
					dto.setBno(rs.getInt("bno"));
					dto.setBctg(rs.getString("bctg"));
					dto.setBtag(rs.getString("btag"));
					dto.setBwrdate(rs.getString("bwrdate"));
					dto.setBtitle(rs.getString("btitle"));
					dto.setBviewcount(rs.getInt("bviewcount"));
					dto.setMnick(rs.getString("mnick"));
					dto.setMno(rs.getInt("mno"));
					dto.setBimg(rs.getString("bimg"));
					dto.setBrecount(rs.getInt("brecount"));
					list.add(dto);
				}
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
		}
		
		return list;

	}
	public void boardInsertData(Connection conn, TableDTO dto) throws SQLException{
		StringBuilder sql=new StringBuilder();
		sql.append(" insert into sp_board(blikecount,bctg, btitle, bcontent, bwrdate, bviewcount, btag, brecount, bimg, mno)	");
		sql.append(" values( 0, ?, ?, ?, sysdate(), 0, ?, 0, ?, ?) 																	");
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getBctg());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setString(3, dto.getBcontent());
			pstmt.setString(4, dto.getBtag());
			pstmt.setString(5, dto.getBimg());
			pstmt.setInt(6, dto.getMno());
			pstmt.executeUpdate();
		}finally {
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
		}
	}
	
	public TableDTO boardDetailData(Connection conn, int boardnum) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append(" select bctg,bno, btitle, bcontent, bwrdate, btag, bviewcount, brecount, blikecount, bimg, m.mnick, m.mno  ");
		sql.append(" from sp_board b inner join member m																		");
		sql.append(" on b.mno = m.mno																							");
		sql.append(" where bno = ?																								");

		TableDTO dto = new TableDTO();
		ResultSet rs = null;
		System.out.println(boardnum);
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			pstmt.setInt(1, boardnum);

			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setBctg(rs.getString("bctg"));
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
				dto.setMno(rs.getInt("m.mno"));
			}
			System.out.println("rs입니다!"+dto);
		} finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {e.printStackTrace();}
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
		sql.append(" update sp_board										");
		sql.append(" set bctg=? ,btag=? ,btitle=?, bcontent=?, bimg=?		");
		sql.append(" where bno = ?											");
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, dto.getBctg());
			pstmt.setString(2, dto.getBtag());
			pstmt.setString(3, dto.getBtitle());
			pstmt.setString(4, dto.getBcontent());
			pstmt.setString(5, dto.getBimg());
			pstmt.setInt(6, dto.getBno());
			pstmt.executeUpdate();
		}
	}
	public List<ReplyDTO> repListData(Connection conn, int bno) throws SQLException {
		StringBuilder sql=new StringBuilder();
		sql.append(" select rno, sp_reply.bno, rcontent, rwrdate, member.mnick, member.mno ");
		sql.append(" from sp_reply join member						");
		sql.append(" on sp_reply.mno=member.mno					");
		sql.append(" where bno=? 									");
		sql.append(" order by rwrdate desc							");
		
		ArrayList<ReplyDTO> arr=new ArrayList<>();
		ResultSet rs=null;
		try (
				PreparedStatement psmt=conn.prepareStatement(sql.toString());
			){
			psmt.setInt(1, bno);
			rs=psmt.executeQuery();
			while(rs.next()) {
				ReplyDTO repdto=new ReplyDTO();
				repdto.setBno(rs.getInt("bno"));
				repdto.setRno(rs.getInt("rno"));
				repdto.setRcontent(rs.getString("rcontent"));
				repdto.setRwrdate(rs.getString("rwrdate"));
				repdto.setMnick(rs.getString("mnick"));
				repdto.setMno(rs.getInt("mno"));
				arr.add(repdto);
			}
		}finally {
			if(rs!=null) try{rs.close();} catch(SQLException e) {}
		}
		return arr;
	}
	public int getTotalCountData(Connection conn, String search, String txtsearch) throws SQLException {
		StringBuilder sql= new StringBuilder();
		sql.append(" select count(*)	");
		sql.append(" from sp_board		");
		if(!search.equals("") && !txtsearch.equals("")) {
			if(search.equals("btitle")) {
				sql.append(" where btitle like ?		");
			}
		}
		ResultSet rs=null;
		int count=0;
		
		try (
				PreparedStatement psmt=conn.prepareStatement(sql.toString());
			){
				if(!search.equals("") && !txtsearch.equals("")) {
					psmt.setString(1, "%"+txtsearch+"%");
				}
				rs=psmt.executeQuery();
				if(rs.next()) {
					count=rs.getInt(1);
			}
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
		}
		return count;
	}
	public void repInsertData(Connection conn, ReplyDTO dto) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into sp_reply 		");
		sql.append(" (rno, bno, rcontent, rwrdate, mno) 	");
		sql.append(" values( null,?,?,sysdate(),? )	");
		try(
				PreparedStatement psmt=conn.prepareStatement(sql.toString());
			){
				psmt.setInt(1, dto.getBno());
				psmt.setString(2, dto.getRcontent());
				psmt.setInt(3, dto.getMno());
				psmt.executeUpdate();
		}
	}
	public void recount(Connection conn, int boardnum) {
		// TODO Auto-generated method stub
		StringBuilder sql=new StringBuilder();
		sql.append(" update sp_board					");
		sql.append(" set bviewcount=IFNULL(bviewcount,0)+1	");
		sql.append(" where bno=?						");
		
		try (
				PreparedStatement psmt=conn.prepareStatement(sql.toString());
			){
				psmt.setInt(1, boardnum);
				psmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void boardRecountIncrease(Connection conn, ReplyDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" update sp_board					");
		sql.append(" set brecount = brecount+1		");
		sql.append(" where bno = ?						");

		try(PreparedStatement psmt=conn.prepareStatement(sql.toString());
				) {
			psmt.setInt(1, dto.getBno());
			psmt.executeUpdate();
		}
	}
	public void boardRecountDecrease(Connection conn, int bno) throws SQLException {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" update sp_board					");
		sql.append(" set brecount = brecount-1		");
		sql.append(" where bno = ?						");

		try(PreparedStatement psmt = conn.prepareStatement(sql.toString());
				) {
			psmt.setInt(1, bno);
			psmt.executeUpdate();
		}
	}
	public void repRemoveData(Connection conn, int rno) throws SQLException {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" delete from sp_reply		");
		sql.append(" where rno = ?				");

		try(PreparedStatement psmt = conn.prepareStatement(sql.toString()); 
				) {
			psmt.setInt(1, rno);

			psmt.executeUpdate();
		}
	}
}