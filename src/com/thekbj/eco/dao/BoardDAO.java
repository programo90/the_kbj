package com.thekbj.eco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thekbj.dto.TableDTO;

public class BoardDAO {
	private static BoardDAO dao=new BoardDAO();
	public static BoardDAO getDAO()
	{
		return dao;
	}
	private BoardDAO() {}
	public List<TableDTO> boardListData(String bview,Connection conn,int startrow,int pagepercount, String search, String txtsearch) throws SQLException {
		
		StringBuilder sql=new StringBuilder();
		
		sql.append(" 		select bno, bctg, btitle, bcontent, bviewcount, bimg, brecount,bwrdate	");
		sql.append("		from eco_board 															");
		if(!search.equals("") && !txtsearch.equals("")) {
			if(search.equals("title")) {
				sql.append(" where btitle like ?   ");
			}else if(search.equals("content")) {
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
					dto.setBtitle(rs.getString("btitle"));
					dto.setBcontent(rs.getString("bcontent"));
					dto.setBviewcount(rs.getInt("bviewcount"));
					dto.setBimg(rs.getString("bimg"));
					dto.setBwrdate(rs.getString("bwrdate"));
					dto.setBwrdate(rs.getString("brecount"));
					list.add(dto);
				}
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
		}
		
		return list;
	}
	
	public void boardInsertData(Connection conn, TableDTO dto)throws SQLException {
			PreparedStatement pstmt=null;
			StringBuilder sql=new StringBuilder();
			sql.append(" insert into eco_board(         	      ");
			sql.append(" 					bctg                  ");
			sql.append(" 					,btitle               ");
			sql.append(" 					,bcontent             ");
			sql.append(" 					,mno	              ");
			sql.append(" 					)                     ");
			sql.append(" values (?,?,?,?)                         ");
		try {
				pstmt=conn.prepareStatement(sql.toString());
				pstmt.setString(1, dto.getBctg());
				pstmt.setString(2, dto.getBtitle());
				pstmt.setString(3, dto.getBcontent());
				pstmt.setInt(4, dto.getMno());
				pstmt.executeUpdate();
		}finally {
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
		}	
	}
	public TableDTO boardDetailData(Connection conn, int boardnum)throws SQLException {
		StringBuilder sql=new StringBuilder();
		 sql.append(" select  bno               ");
		 sql.append("        ,btitle            ");
		 sql.append("        ,bctg              ");
		 sql.append("        ,bcontent          ");
		 sql.append("        ,mno		        ");
		 sql.append("        ,bviewcount        ");
		 sql.append(" from eco_board            ");
		 sql.append(" where  bno=?              ");
		ResultSet rs=null;
		TableDTO dto=new TableDTO();
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());){
			pstmt.setInt(1, boardnum);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				dto.setBno(rs.getInt("bno"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBctg(rs.getString("bctg"));
				dto.setBcontent(rs.getString("bcontent"));
				dto.setMno(rs.getInt("mno"));
				dto.setBviewcount(rs.getInt("bviewcount"));
			}
		}finally {
			if(rs!=null) try {rs.close();}catch(SQLException e) {}
		}
		return dto;
	}
	
	public int boardRemoveData(Connection conn, int bno) throws SQLException {
		TableDTO dto=new TableDTO();
		StringBuilder sql=new StringBuilder();
		 sql.append(" delete                   ");
		 sql.append(" from eco_board           ");
		 sql.append(" where bno=?              ");
		int result=0;
		try (PreparedStatement pstmt=conn.prepareStatement(sql.toString());
				)
			{
				 pstmt.setInt(1, bno);
			result=pstmt.executeUpdate();
			}
		return result;
	}
	public int boardModifyData(Connection conn, TableDTO dto) throws SQLException{
		StringBuilder sql=new StringBuilder();
		sql.append(" update eco_board  		");
		sql.append(" set bcontent=? 	    ");
		sql.append(" 	,btitle=?	 	    ");
		sql.append(" 	where bno=?		    ");
		int result=0;
		try(PreparedStatement pstmt=conn.prepareStatement(sql.toString());
				)
		{
			pstmt.setString(1, dto.getBcontent());
			pstmt.setString(2, dto.getBtitle());
			pstmt.setInt(3, dto.getBno());
			result=pstmt.executeUpdate();
		}
		return result;
	}
	
	public int getTotalCountData(Connection conn, String search, String txtsearch) throws SQLException {
		StringBuilder sql=new StringBuilder();
		sql.append(" select count(*) from eco_board  ");
		if(!search.equals("") && !txtsearch.equals("")) {
			if(search.equals("btitle")) {
				sql.append(" where btitle like ?		");
			}else if(search.equals("bcontent")) {
				sql.append(" where bcontent like ?	");
			}
		}
		ResultSet rs=null;
		int totalcount=0;
		
		try (
				PreparedStatement psmt=conn.prepareStatement(sql.toString());
			){
				if(!search.equals("") && !txtsearch.equals("")) {
					psmt.setString(1, "%"+txtsearch+"%");
				}
				rs=psmt.executeQuery();
				if(rs.next()) {
					totalcount=rs.getInt(1);
			}
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
		}
		return totalcount;
	}
	
	public void recount(Connection conn, int boardnum) throws SQLException {
		// TODO Auto-generated method stub
		StringBuilder sql=new StringBuilder();
		sql.append(" update eco_board					");
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
	
	public void viewcount(Connection conn, int boardnum) {
		StringBuilder sql = new StringBuilder();
		sql.append(" update eco_board								");
		sql.append(" set bviewcount = IFNULL(bviewcount,0)+1		");
		sql.append(" where bno = ?									");
		try (PreparedStatement psmt=conn.prepareStatement(sql.toString());
			){
				psmt.setInt(1, boardnum);
				psmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
	}	
}