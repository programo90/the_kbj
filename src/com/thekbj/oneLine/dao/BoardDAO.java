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
import com.thekbj.dto.TableReplyMemberDTO;

public class BoardDAO {
	private static BoardDAO boardDAO = new BoardDAO();
	
	private BoardDAO(){};
	
	public static BoardDAO getBoardDAO() {
		return boardDAO;
	}


	public int getTotalCountData(Connection conn) throws SQLException{
		System.out.println("BoardDAO getTotalCountData oneLine DAO start");
		
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
			System.out.println("BoardDAO getTotalCountData DAO end");
		}
		
		return totalcount;
	}

	public List<TableDTO> boardListData(Connection conn, int startrow, int endrow) throws SQLException{
		System.out.println("BoardDAO boardListData DAO start");
		StringBuilder sql = new StringBuilder();	
		sql.append("	select R1.* FROM(					  				");
		sql.append(" 		select 	bno, bctg, btitle,  	 	 	 		");
		sql.append(" 				bcontent,bwrdate,bviewcount,  	 		");
		sql.append(" 				btag, brecount, blikecount,  			");
		sql.append(" 				bimg, mb.mnick, mscore, ob.mno, mb.mimg ");
		sql.append(" 		from 	oneLine_board as ob	  	 		 		");
		sql.append(" 		join 	member as mb	 				 		");
		sql.append(" 		on 		ob.mno = mb.mno	 				 		");
		sql.append(" 		order by bwrdate desc					 		");
		sql.append("		) R1									 		");
		sql.append(" 		LIMIT ?, ?								 		");

		
		ResultSet rs = null;
		
		
		List<TableDTO> list = new ArrayList<TableDTO>();
		
		try ( PreparedStatement pstmt = conn.prepareStatement(sql.toString()); ){
			
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{ 			
				TableDTO dto = new TableDTO();
				int bno = rs.getInt("bno");
				int mno = rs.getInt("mno");
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
				int mscore= rs.getInt("mscore");
				String mimg= rs.getString("mimg");
				
				dto.setBno(bno);
				dto.setMno(mno);
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
			    dto.setMscore(mscore);
			    dto.setMimg(mimg);
			    
			    list.add(dto);
			}
			
			
		}finally {
			try { if(rs != null) rs.close(); }catch(SQLException e){}
			System.out.println("BoardDAO boardListData DAO end");
		}
		
		return list;
	}

	public List<ReplyDTO> repListData(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("BoardDAO repListData DAO start");
		StringBuilder sql = new StringBuilder();	
		sql.append(" 		select 	rno, bno, rcontent, rwrdate, me.mnick as mnick, me.mimg as mimg ,ore.mno	 ");
		sql.append(" 		from 	oneLine_reply as ore	 			 		 	 		 					 ");
		sql.append(" 		join 	member as me			 	     				 							 ");
		sql.append(" 		on 	    ore.mno = me.mno			 			 									 ");
		sql.append(" 		order   by bno desc, rwrdate desc		 		 				 					 ");

		ResultSet rs = null;
		
		
		List<ReplyDTO> list = new ArrayList<ReplyDTO>();
		
		try ( PreparedStatement pstmt = conn.prepareStatement(sql.toString()); ){
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{ 			
				ReplyDTO dto = new ReplyDTO();
				
				int rno = rs.getInt("rno");
				int bno = rs.getInt("bno");
				int mno = rs.getInt("mno");
				String rcontent = rs.getString("rcontent");
				String rwrdate = rs.getString("rwrdate");
				String mnick = rs.getString("mnick");
				String rimg = rs.getString("mimg");
				
				dto.setRno(rno);       
				dto.setBno(bno);
				dto.setMno(mno); 
				dto.setRcontent(rcontent);  
				dto.setRwrdate(rwrdate);
				dto.setMnick(mnick);
				dto.setRimg(rimg);
				
			    list.add(dto);
			}
			
			
		}finally {
			try { if(rs != null) rs.close(); }catch(SQLException e){}
			System.out.println("BoardDAO repListData DAO end");
		}
		
		return list;
	}

	public List<TableReplyMemberDTO> scrollList(Connection conn, int startrow, int endrow) throws SQLException{
		// TODO Auto-generated method stub
		System.out.println("BoardDAO repListData DAO start");
		StringBuilder sql = new StringBuilder();	
		sql.append("		select R1.* FROM(																							 ");
		sql.append(" 		select obo.bno as bno, obo.bctg as bctg, obo.btitle as btitle 												 ");
		sql.append("               ,obo.bcontent as bcontent, obo.bwrdate as bwrdate 													 ");
		sql.append("               ,obo.bviewcount as bviewcount, obo.btag as btag , obo.brecount as brecount							 ");
		sql.append("			   ,obo.blikecount as blikecount , obo.bimg as bimg, mem.mnick as bnick, mem.mno as mno, mem.mimg as mimg");
		sql.append("			   , ore.rno as rno																						 ");
		sql.append("			   ,ore.rcontent as rcontent, ore.rwrdate as rwrdate, mem2.mnick as rnick								 ");
		sql.append(" 		from oneLine_board as obo 	 																				 ");
		sql.append(" 		inner join member as mem																					 ");
		sql.append(" 		on obo.mno = mem.mno	 																					 ");
		sql.append(" 		left outer join oneLine_reply as ore										    							 ");
		sql.append(" 		on ore.bno = obo.bno	 																					 ");
		sql.append(" 		left outer join member as mem2	 																			 ");
		sql.append(" 		on mem2.mno = ore.mno	 																					 ");
		sql.append(" 		order by obo.bno desc, obo.bwrdate desc, ore.rwrdate desc	 												 ");
		sql.append(" 		) R1	 																									 ");
		sql.append(" 		LIMIT ?, ?;	 																								 ");
									
		
		ResultSet rs = null;
		
		
		List<TableReplyMemberDTO> list = new ArrayList<TableReplyMemberDTO>();
		
		try ( PreparedStatement pstmt = conn.prepareStatement(sql.toString()); ){
			
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{ 			
				TableReplyMemberDTO dto = new TableReplyMemberDTO();
				
				int bno = rs.getInt("bno");                 
				String bctg = rs.getString("bctg");     
				String btitle= rs.getString("btitle");        
				String bcontent= rs.getString("bcontent");      
				String bwrdate= rs.getString("bwrdate");       
				int bviewcount= rs.getInt("bviewcount");       
				String btag= rs.getString("btag");          
				int brecount= rs.getInt("brecount");         
				int blikecount= rs.getInt("blikecount");       
				String bimg= rs.getString("bimg");          
				String bnick= rs.getString("bnick");
				int mno = rs.getInt("mno");
				String mimg = rs.getString("mimg");
				int rno= rs.getInt("rno");              
				String rcontent= rs.getString("rcontent");      
				String rwrdate= rs.getString("rwrdate");       
				String rnick= rs.getString("rnick");         
				
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
				dto.setBnick(bnick);
				dto.setMno(mno);
				dto.setMimg(mimg);
				dto.setRno(rno);              
				dto.setRcontent(rcontent);      
				dto.setRwrdate(rwrdate);       
				dto.setRnick(rnick);
				
			    list.add(dto);
			}
			
			
		}finally {
			try { if(rs != null) rs.close(); }catch(SQLException e){}
			System.out.println("BoardDAO repListData DAO end");
		}
		
		return list;
	}

	public int boardRemoveData(Connection conn, int bno) throws SQLException{
		System.out.println("BoardDAO boardRemoveData oneLine DAO start");
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("	delete from oneLine_board where bno=? ");
		
		
		int ressult = 0;
		
		try ( PreparedStatement pstmt = conn.prepareStatement(sql.toString()); )
		{
			pstmt.setInt(1, bno);
			ressult = pstmt.executeUpdate();
			
		}finally {
			System.out.println("BoardDAO boardRemoveData DAO end");
		}
		
		return ressult;
	}

	public int repInsertData(Connection conn, String content, int mno, int bno) throws SQLException{
		System.out.println("BoardDAO repInsertData oneLine DAO start");
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("	insert into oneLine_reply( bno, rcontent, rwrdate, mno)  ");
		sql.append("	value( ?, ?, now(), ?)								     ");
		
		
		int ressult = 0;
		
		try ( PreparedStatement pstmt = conn.prepareStatement(sql.toString()); )
		{
			pstmt.setInt(1, bno);
			pstmt.setString(2, content);
			pstmt.setInt(3, mno);
			ressult = pstmt.executeUpdate();
			
		}finally {
			System.out.println("BoardDAO repInsertData DAO end");
		}
		
		return ressult;
	}

	public int repRemoveData(Connection conn, int rno) throws SQLException{
System.out.println("BoardDAO repRemoveData oneLine DAO start");
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("	delete from oneLine_reply where rno=? ");
		
		
		int ressult = 0;
		
		try ( PreparedStatement pstmt = conn.prepareStatement(sql.toString()); )
		{
			pstmt.setInt(1, rno);
			ressult = pstmt.executeUpdate();
			
		}finally {
			System.out.println("BoardDAO repRemoveData DAO end");
		}
		
		return ressult;
	}

	public int boardInsertData(Connection conn, TableDTO dto) throws SQLException{
		System.out.println("BoardDAO boardInsertData oneLine DAO start");
		
		StringBuilder sql = new StringBuilder();
		
		
		sql.append("	insert into oneLine_board   					");
		sql.append("	values(null,?,?,?,now(),0,?,0,0,?,?,null)	        ");
		
		String title ="one";
		int ressult = 0;
		
		try ( PreparedStatement pstmt = conn.prepareStatement(sql.toString()); )
		{
			pstmt.setString(1, dto.getBctg());
			pstmt.setString(2, title);
			pstmt.setString(3, dto.getBcontent());
			pstmt.setString(4, dto.getBtag());
			pstmt.setString(5,dto.getBimg());
			pstmt.setInt(6,dto.getMno());
			ressult = pstmt.executeUpdate();
			
		}finally {
			System.out.println("BoardDAO repInsertData DAO end");
		}
		
		return ressult;
	}

	public TableDTO boardModifyData(Connection conn, int board_bno) throws SQLException {
		System.out.println("BoardDAO boardModifyData oneLine DAO start");
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("	select * 			");
		sql.append(" 	from oneLine_board	");
		sql.append(" 	where bno=?	");
		
		
		TableDTO dto = new TableDTO();
		ResultSet rs = null;
		
		try ( PreparedStatement pstmt = conn.prepareStatement(sql.toString()); )
		{
			pstmt.setInt(1, board_bno);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				int bno = rs.getInt("bno");        
				int mno = rs.getInt("mno");        
				String bctg = rs.getString("bctg");    
				String bcontent = rs.getString("bcontent");
				String bwrdate = rs.getString("bwrdate"); 
				int bviewcount = rs.getInt("bviewcount"); 
				String btag = rs.getString("btag");    
				int brecount = rs.getInt("brecount");   
				int blikecount = rs.getInt("blikecount"); 
				String bimg = rs.getString("bimg");
				
				dto.setBno(bno);
				dto.setMno(mno);
				dto.setBctg(bctg);
				dto.setBcontent(bcontent);;
				dto.setBwrdate(bwrdate);
				dto.setBviewcount(bviewcount);
				dto.setBtag(btag);
				dto.setBrecount(brecount);
				dto.setBlikecount(blikecount);
				dto.setBimg(bimg);
			}
			
		}finally {
			if(rs!=null) try {rs.close();}catch(SQLException e) {}
			System.out.println("BoardDAO boardModifyData DAO end");
		}
		
		return dto;
		
		
	}

	public int boardModifyResultData(Connection conn, TableDTO dto) throws SQLException {
		System.out.println("BoardDAO boardModifyResultData oneLine DAO start");
		
		StringBuilder sql = new StringBuilder();
		
		
		sql.append("	update oneLine_board set   			 ");
		sql.append("	bctg = ?	      					 ");
		sql.append("	,btitle = ?	       					 ");
		sql.append("	,bcontent = ?	    			     ");
		sql.append("	,btag = ?	        				 ");
		sql.append("	,bimg = ?	        				 ");
		sql.append("	,mno = ?	      				 	 ");
		sql.append("	where bno = ?        				 ");					

		
		String title ="one";
		int result = 0;
		
		try ( PreparedStatement pstmt = conn.prepareStatement(sql.toString()); )
		{
			pstmt.setString(1, dto.getBctg());
			pstmt.setString(2, title);
			pstmt.setString(3, dto.getBcontent());
			pstmt.setString(4,dto.getBtag());
			pstmt.setString(5, dto.getBimg());
			pstmt.setInt(6, dto.getMno());
			pstmt.setInt(7, dto.getBno());
			
			result = pstmt.executeUpdate();
			
		}finally {
			System.out.println("BoardDAO boardModifyResultData DAO end");
		}
		
		return result;
	}

	public ReplyDTO replyModifyData(Connection conn, int board_rno) throws SQLException {
		System.out.println("BoardDAO replyModifyData oneLine DAO start");
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("	select * 			");
		sql.append(" 	from oneLine_reply	");
		sql.append(" 	where rno=?	");
		
		
		ReplyDTO dto = new ReplyDTO();
		ResultSet rs = null;
		
		try ( PreparedStatement pstmt = conn.prepareStatement(sql.toString()); )
		{
			pstmt.setInt(1, board_rno);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				int rno = rs.getInt("rno");        
				int mno = rs.getInt("mno");        
				String rcontent = rs.getString("rcontent");
				String rwrdate = rs.getString("rwrdate"); 
				
				dto.setRno(rno);
				dto.setMno(mno);
				dto.setRwrdate(rwrdate);
				dto.setRcontent(rcontent);
			}
			
		}finally {
			if(rs!=null) try {rs.close();}catch(SQLException e) {}
			System.out.println("BoardDAO replyModifyData DAO end");
		}
		
		return dto;
	}

	public int repModifyResultData(Connection conn, ReplyDTO dto) throws SQLException{
		System.out.println("BoardDAO repModifyResultData oneLine DAO start");
		
		StringBuilder sql = new StringBuilder();
		
		
		sql.append("	update oneLine_reply set   			 ");
		sql.append("	rcontent = ?	    			     ");
		sql.append("	where rno = ?        				 ");					

		
		int result = 0;
		
		try ( PreparedStatement pstmt = conn.prepareStatement(sql.toString()); )
		{
			pstmt.setString(1, dto.getRcontent());
			pstmt.setInt(2, dto.getRno());
			
			result = pstmt.executeUpdate();
			
		}finally {
			System.out.println("BoardDAO repModifyResultData DAO end");
		}
		
		return result;
	}
}
