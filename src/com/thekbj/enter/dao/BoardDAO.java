package com.thekbj.enter.dao;

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
	public static BoardDAO getBoardDAO() {
		return dao;
	}
	public List<TableDTO> boardListData(Connection conn, int startrow, int pagepercount, String search, String txtsearch) throws SQLException{
		StringBuilder sql=new StringBuilder();
		/*sql.append(" select bno, bctg ,btitle, bcontent	");
		sql.append("  , bviewcount ,btag ,brecount, blikecount, bimg ");
		sql.append(" from ent_board");*/
		
//		sql.append(" select @rownum:=@rownum+1 as rnum, b.*			");
//		sql.append(" from (											");
		sql.append(" 		select bno, bctg, btitle, bcontent, bviewcount		");
		sql.append("		from ent_board							");
		System.out.println("ddddd"+search);
		System.out.println("ddddd"+txtsearch);
		
		if(!search.equals("") && !txtsearch.equals("")) {
			if(search.equals("title")) {
				sql.append(" where btitle like ? ");
			}else if(search.equals("content")) {
				sql.append(" where bcontent like ? ");
			}
		}
		
		sql.append(" 		order by bno 							");
//		sql.append(" )b												");
//		sql.append(" where @rownum:=?								");
		sql.append(" limit ?,?										");
		
		List<TableDTO> list = new ArrayList<>();
		ResultSet rs=null;
		System.out.println(sql);
		try (PreparedStatement psmt=conn.prepareStatement(sql.toString())
			){
				if(!search.equals("") && !txtsearch.equals("")) {
					psmt.setString(1, "%"+txtsearch+"%");
//					psmt.setInt(2, pagepercount);
					psmt.setInt(2, startrow);
					psmt.setInt(3, pagepercount);
				}else {
//					psmt.setInt(1, pagepercount);
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
					System.out.println("여기기기"+dto.getBno());
					list.add(dto);
				}
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
		}
		
		return list;
	}
	public void boardInsertData(Connection conn, TableDTO dto) throws SQLException {
		StringBuilder sql=new StringBuilder();
		sql.append(" insert into ent_board(	");
		sql.append(" bctg, btitle, bcontent)	");
		sql.append(" values(?,?,?)	");
		try (
				PreparedStatement psmt=conn.prepareStatement(sql.toString());
			){
			psmt.setString(1, dto.getBctg());
			psmt.setString(2, dto.getBtitle());
			psmt.setString(3, dto.getBcontent());
			psmt.executeUpdate();

		}catch (Exception e) {
			System.out.println(e);
		}
	}
	public TableDTO boardDetailData(Connection conn, int boardnum) throws SQLException {
		StringBuilder sql=new StringBuilder();
		sql.append(" select bno, bctg, btitle, bcontent, bviewcount	");
		sql.append(" from ent_board						");
		sql.append(" where bno=?						");
		
		ResultSet rs=null;
		TableDTO dto=new TableDTO();
		
		try(PreparedStatement psmt=conn.prepareStatement(sql.toString());){
			psmt.setInt(1, boardnum);
			rs=psmt.executeQuery();
			if(rs.next()) {
				dto.setBno(rs.getInt("bno"));
				dto.setBctg(rs.getString("bctg"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBviewcount(rs.getInt("bviewcount"));
				dto.setBcontent(rs.getString("bcontent"));
			}
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
		}
		return dto;
	}
	public int boardModifyResultData(Connection conn, TableDTO dto) throws SQLException{
		// TODO Auto-generated method stub
		StringBuilder sql=new StringBuilder();
		sql.append(" update ent_board 					");
		sql.append(" set bctg=?, btitle=?, 	bcontent=?	");
		sql.append(" where bno=?						");
		
		int modifyresult=0;
		try(PreparedStatement psmt=conn.prepareStatement(sql.toString());){
			psmt.setString(1, dto.getBctg());
			psmt.setString(2, dto.getBtitle());
			psmt.setString(3, dto.getBcontent());
			psmt.setInt(4, dto.getBno());
			modifyresult=psmt.executeUpdate();
		}
		return modifyresult;
	}
	public int boardRemoveData(Connection conn, int bno) throws SQLException{
		// TODO Auto-generated method stub
		StringBuilder sql=new StringBuilder();
		sql.append(" delete from ent_board	");
		sql.append(" where bno=?			");
		int result=0;
		
		try (
				PreparedStatement psmt=conn.prepareStatement(sql.toString());
			){
			psmt.setInt(1, bno);
			result=psmt.executeUpdate();
		}
		return result;
	}
	public int getTotalCountData(Connection conn, String search, String txtsearch)throws SQLException {
		// TODO Auto-generated method stub
		StringBuilder sql= new StringBuilder();
		sql.append(" select count(*)	");
		sql.append(" from ent_board		");
		if(!search.equals("") && !txtsearch.equals("")) {
			if(search.equals("btitle")) {
				sql.append(" where btitle like ?		");
			}else if(search.equals("bcontent")) {
				sql.append(" where bcontent like ?	");
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
	public void recount(Connection conn, int boardnum) throws SQLException {
		// TODO Auto-generated method stub
		StringBuilder sql=new StringBuilder();
		sql.append(" update ent_board					");
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

}
