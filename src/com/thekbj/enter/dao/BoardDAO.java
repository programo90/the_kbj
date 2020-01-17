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
	public static BoardDAO getBoardDAO() {
		return dao;
	}
	public List<TableDTO> boardListData(Connection conn) throws SQLException{
		StringBuilder sql=new StringBuilder();
		sql.append(" select bno, btitle, bcontent, bwrdate 	");
		/*sql.append(" , bctg , bviewcount ,btag ,brecount, blikecount, bimg ");*/
		sql.append(" from ent_board");
		
		List<TableDTO> list = new ArrayList<>();
		ResultSet rs=null;
		
		try (PreparedStatement psmt=conn.prepareStatement(sql.toString())
			){
				rs=psmt.executeQuery();
				while(rs.next()) {
					TableDTO dto=new TableDTO();
					dto.setBno(rs.getInt("bno"));
					dto.setBtitle(rs.getString("btitle"));
					dto.setBcontent(rs.getString("bcontent"));
					dto.setBwrdate(rs.getString("bwrdate"));
					list.add(dto);
				}
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
		}
		
		return list;
	}
	


}
