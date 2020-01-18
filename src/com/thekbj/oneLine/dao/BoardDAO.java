package com.thekbj.oneLine.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thekbj.dto.MemberDTO;
import com.thekbj.dto.ReplyDTO;
import com.thekbj.dto.TableDTO;

public class BoardDAO {
	private static BoardDAO boardDAO = new BoardDAO();
	
	private BoardDAO(){};
	
	public static BoardDAO getBoardDAO() {
		return boardDAO;
	}


	public int getTotalCountData(Connection conn) throws SQLException{
		System.out.println("BoardDAO getTotalCountData : 게시글 갯수 DAO 요청");
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("	select count(*) as totalcount ");
		sql.append(" 	from oneLine_board			  ");
		
		
		int totalcount = 0;
		ResultSet rs = null;
		
		try ( PreparedStatement pstmt = conn.prepareStatement(sql.toString()); )
		{
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				totalcount = rs.getInt("totalcount");
			}
			
		}finally {
			if(rs!=null) try {rs.close();}catch(SQLException e) {}
			System.out.println("BoardDAO getTotalCountData : 게시글 갯수 DAO 요청 정상 종료");
		}
		
		return totalcount;
	}

	public List<TableDTO> boardListData(Connection conn, int startrow, int endrow) throws SQLException{
		System.out.println("BoardDAO boardListData : 게시글 갯수 DAO 요청");
		StringBuilder sql = new StringBuilder();	
		sql.append("	select R1.* FROM(					  		 ");
		sql.append(" 		select 	bno, bctg, btitle,  	 	 	 ");
		sql.append(" 				bcontent,bwrdate,bviewcount,  	 ");
		sql.append(" 				btag, brecount, blikecount,  	 ");
		sql.append(" 				bimg, mnick  	 			 	 ");
		sql.append(" 		from 	oneLine_board as ob	  	 		 ");
		sql.append(" 		join 	member as mb	 				 ");
		sql.append(" 		on 		ob.mno = mb.mno	 				 ");
		sql.append(" 		order by bwrdate desc					 ");
		sql.append("		) R1									 ");
		sql.append(" 		LIMIT ?, ?								 ");

		
		ResultSet rs = null;
		
		
		List<TableDTO> list = new ArrayList<TableDTO>();
		
		try ( PreparedStatement pstmt = conn.prepareStatement(sql.toString()); ){
			
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{ 			
				TableDTO dto = new TableDTO();
				int bno = rs.getInt("bno");
				String bctg = rs.getString("bctg");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");    
				String bwrdate = rs.getString("bwrdate");      
				int bviewcount = rs.getInt("bviewcount");    
				String btag= rs.getString("btag");      
				int brecount = rs.getInt("brecount");       
				int blikecount = rs.getInt("blikecount"); 
				String bimg= rs.getString("bimg");    
				String mnick= rs.getString("mnick");
				
				dto.setBno(bno);       
				dto.setBctg(bctg);      
				dto.setBtitle(btitle);    
				dto.setBcontent(bcontent);  
				dto.setBwrdate(bwrdate);   
				dto.setBviewcount(bviewcount);
				dto.setBtag(btag);      
				dto.setBrecount(brecount);  
				dto.setBlikecount(blikecount);
				dto.setBimg(bimg);      
			    dto.setMnick(mnick);
			    
			    list.add(dto);
			}
			
			
		}finally {
			try { if(rs != null) rs.close(); }catch(SQLException e){}
			System.out.println("BoardDAO boardListData : 게시글 갯수 DAO 요청 정상 종료");
		}
		
		return list;
	}

	public List<ReplyDTO> repListData(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("BoardDAO repListData : 게시글 갯수 DAO 요청");
		StringBuilder sql = new StringBuilder();	
		sql.append(" 		select 	rno, bno, rcontent, rwrdate, mnick 	 	 ");
		sql.append(" 		from 	oneLine_reply as ore	 			 	 ");
		sql.append(" 		join 	member as me			 	     		 ");
		sql.append(" 		on 	    ore.mno = me.mno			 			 ");
		sql.append(" 		order   by bno desc, rwrdate desc		 		 ");

		ResultSet rs = null;
		
		
		List<ReplyDTO> list = new ArrayList<ReplyDTO>();
		
		try ( PreparedStatement pstmt = conn.prepareStatement(sql.toString()); ){
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{ 			
				ReplyDTO dto = new ReplyDTO();
				
				int rno = rs.getInt("rno");
				int bno = rs.getInt("bno");
				String rcontent = rs.getString("rcontent");
				String rwrdate = rs.getString("rwrdate");
				String mnick = rs.getString("mnick");
				
				dto.setBno(rno);       
				dto.setBno(bno);      
				dto.setRcontent(rcontent);  
				dto.setRwrdate(rwrdate);
				dto.setMnick(mnick);
				
			    list.add(dto);
			}
			
			
		}finally {
			try { if(rs != null) rs.close(); }catch(SQLException e){}
			System.out.println("BoardDAO repListData : 게시글 갯수 DAO 요청 정상 종료");
		}
		
		return list;
	}
}
