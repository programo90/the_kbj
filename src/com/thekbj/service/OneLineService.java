package com.thekbj.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.thekbj.comm.DBConnection;
import com.thekbj.dto.ReplyDTO;
import com.thekbj.dto.TableDTO;
import com.thekbj.dto.TableReplyMemberDTO;
import com.thekbj.oneLine.dao.BoardDAO;

public class OneLineService {
	private static OneLineService service = new OneLineService();
	
	private OneLineService() {}

	public static OneLineService getService() {
		return service;
	}

	public List<TableDTO> boardList(int startrow, int endrow) {
		System.out.println("OneLineService boardList oneLine Service start");
		
		Connection conn = null;
		
		List<TableDTO> list = null;
		
		try 
		{
			DBConnection dbconn = DBConnection.getinstance();
			conn = dbconn.getConnection();
			conn.setAutoCommit(false);
			
			BoardDAO dao = BoardDAO.getBoardDAO();
			list = dao.boardListData(conn, startrow, endrow);
			
			conn.commit();
		}
		catch(SQLException | NamingException e)
		{
			try { conn.close(); }catch(SQLException e2) {}
			System.out.println("OneLineService boardList : "+ e);
		}finally {
			if(conn!=null) try { conn.close(); }catch(SQLException e2) {}
			System.out.println("OneLineService boardList oneLine Service end");
		}
		return list;
	}

	public int totalcount() {
		System.out.println("OneLineService totalcount oneLine Service start");
		
		Connection conn = null;
		int totalcount = 0;
		
		try 
		{
			DBConnection dbconn = DBConnection.getinstance();
			conn = dbconn.getConnection();
			conn.setAutoCommit(false);
			
			BoardDAO dao = BoardDAO.getBoardDAO();
			totalcount = dao.getTotalCountData(conn);
			
			conn.commit();
		}
		catch(SQLException | NamingException e)
		{
			try { conn.close(); }catch(SQLException e2) {}
			System.out.println("OneLineService totalcount : "+ e);
		}finally {
			if(conn!=null) try { conn.close(); }catch(SQLException e2) {}
			System.out.println("OneLineService totalcount oneLine Service end");
		}
		return totalcount;
	}

	
	
	public List<ReplyDTO> replyList() {
		System.out.println("OneLineService replyList oneLine Service start");
		
		Connection conn = null;
		
		List<ReplyDTO> list = null;
		
		try 
		{
			DBConnection dbconn = DBConnection.getinstance();
			conn = dbconn.getConnection();
			conn.setAutoCommit(false);
			
			BoardDAO dao = BoardDAO.getBoardDAO();
			list = dao.repListData(conn);
			
			conn.commit();
		}
		catch(SQLException | NamingException e)
		{
			try { conn.close(); }catch(SQLException e2) {}
			System.out.println("OneLineService replyList : "+ e);
		}finally {
			if(conn!=null) try { conn.close(); }catch(SQLException e2) {}
			System.out.println("OneLineService replyList oneLine Service end");
		}
		return list;
	}

	public List<TableReplyMemberDTO> boardscrollList(int startrow, int endrow) {
		System.out.println("OneLineService boardscrollList oneLine Service start");
		
		Connection conn = null;
		
		List<TableReplyMemberDTO> list = null;
		
		try 
		{
			DBConnection dbconn = DBConnection.getinstance();
			conn = dbconn.getConnection();
			conn.setAutoCommit(false);
			
			BoardDAO dao = BoardDAO.getBoardDAO();
			list = dao.scrollList(conn, startrow, endrow);
			
			conn.commit();
		}
		catch(SQLException | NamingException e)
		{
			try { conn.close(); }catch(SQLException e2) {}
			System.out.println("OneLineService boardscrollList : "+ e);
		}finally {
			if(conn!=null) try { conn.close(); }catch(SQLException e2) {}
			System.out.println("OneLineService boardscrollList oneLine Service end");
		}
		return list;
	}

	public int boardRemove(int bno) {
		System.out.println("OneLineService boardRemove oneLine Service start");
		
		Connection conn = null;
		
		int result = 0;
		
		try 
		{
			DBConnection dbconn = DBConnection.getinstance();
			conn = dbconn.getConnection();
			conn.setAutoCommit(false);
			
			BoardDAO dao = BoardDAO.getBoardDAO();
			result = dao.boardRemoveData(conn, bno);
			
			conn.commit();
		}
		catch(SQLException | NamingException e)
		{
			try { conn.close(); }catch(SQLException e2) {}
			System.out.println("OneLineService boardRemove : "+ e);
		}finally {
			if(conn!=null) try { conn.close(); }catch(SQLException e2) {}
			System.out.println("OneLineService boardRemove oneLine Service end");
		}
		return result;
	}

	public int repInsert(String content, int mno, int bno) {
		System.out.println("OneLineService repInsert oneLine Service start");
		
		Connection conn = null;
		
		int result = 0;
		
		try 
		{
			DBConnection dbconn = DBConnection.getinstance();
			conn = dbconn.getConnection();
			conn.setAutoCommit(false);
			
			BoardDAO dao = BoardDAO.getBoardDAO();
			result = dao.repInsertData(conn, content, mno, bno);
			
			conn.commit();
		}
		catch(SQLException | NamingException e)
		{
			try { conn.close(); }catch(SQLException e2) {}
			System.out.println("OneLineService repInsert : "+ e);
		}finally {
			if(conn!=null) try { conn.close(); }catch(SQLException e2) {}
			System.out.println("OneLineService repInsert oneLine Service end");
		}
		return result;
	}

	public int repRemove(int rno) {
		System.out.println("OneLineService repRemove oneLine Service start");
		
		Connection conn = null;
		
		int result = 0;
		
		try 
		{
			DBConnection dbconn = DBConnection.getinstance();
			conn = dbconn.getConnection();
			conn.setAutoCommit(false);
			
			BoardDAO dao = BoardDAO.getBoardDAO();
			result = dao.repRemoveData(conn, rno);
			
			conn.commit();
		}
		catch(SQLException | NamingException e)
		{
			try { conn.close(); }catch(SQLException e2) {}
			System.out.println("OneLineService repRemove : "+ e);
		}finally {
			if(conn!=null) try { conn.close(); }catch(SQLException e2) {}
			System.out.println("OneLineService repRemove oneLine Service end");
		}
		return result;
	}
	
	
}
