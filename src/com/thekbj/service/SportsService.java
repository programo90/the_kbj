package com.thekbj.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.thekbj.comm.DBConnection;
import com.thekbj.dto.ReplyDTO;
import com.thekbj.dto.TableDTO;
import com.thekbj.sports.dao.BoardDAO;

public class SportsService {
	private static SportsService service=new SportsService();
	private SportsService() {}
	public static SportsService getService()
	{
		return service;
	}
	public List<TableDTO> boardList(String bview, int startrow, int pagepercount, String search, String txtsearch) {
		// TODO Auto-generated method stub
		DBConnection db=DBConnection.getinstance();
		Connection conn=null;
		List<TableDTO> list=new ArrayList<>();
		try {
			conn=db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao=BoardDAO.getDAO();
			list=dao.boardListData(bview,conn, startrow, pagepercount, search, txtsearch);
			conn.commit();
		}catch(NamingException| SQLException e)
		{
			System.out.println(e);
			try {conn.rollback();}catch(Exception e2) {}
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return list;
	}
	public void IsertData(TableDTO dto) {
		// TODO Auto-generated method stub
		DBConnection db=DBConnection.getinstance();
		Connection conn=null;
		try {
			conn=db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao=BoardDAO.getDAO();
			dao.boardInsertData(conn, dto);
			conn.commit();
		}catch(NamingException| SQLException e)
		{
			System.out.println(e);
			try {conn.rollback();}catch(Exception e2) {}
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
	}
	public TableDTO boardDetail(int boardnum) {
		System.out.println(service);
		DBConnection db=DBConnection.getinstance();
		Connection conn=null;
		TableDTO dto=null;
		try {
			conn=db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao=BoardDAO.getDAO();
			dao.recount(conn, boardnum);
			dto=dao.boardDetailData(conn, boardnum);
			conn.commit();
		}catch(NamingException | SQLException e)
		{
			System.out.println(e);
			try {conn.rollback();}catch(Exception e2) {}
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return dto;
	}
	public void boardRemove(int bno) {
		Connection conn=null;
		int result=0;
		try {
			DBConnection db=DBConnection.getinstance();
			conn = db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao=BoardDAO.getDAO();
			dao.boardRemoveData(conn, bno);
			conn.commit();
		}catch(NamingException|SQLException e) {
			System.out.println(e);
			try{conn.rollback();}catch(Exception e2) {}
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
	}
	public void boardModifyResultData(TableDTO dto) {
		// TODO Auto-generated method stub
		DBConnection dbconn=DBConnection.getinstance();
		Connection conn=null;
		try {
			conn=dbconn.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao= BoardDAO.getDAO();
			dao.boardModifyResultData(conn, dto);
			conn.commit();
		}catch(NamingException|SQLException e)
		{
			System.out.println(e);
			try {conn.rollback();}catch(SQLException e2) {}
		}finally {
			if(conn!=null)try {conn.close();} catch(SQLException e) {System.out.println(e);}
		}
		
	}
	public List<ReplyDTO> repList(int bno) {
		DBConnection db=DBConnection.getinstance();
		Connection conn=null;
		List<ReplyDTO> list=null;
		try {
			conn=db.getConnection();
			BoardDAO dao=BoardDAO.getDAO();
			list = dao.repListData(conn,bno);
		}catch(NamingException|SQLException e)
		{
			System.out.println(e);
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return list;
	}
	public int getTotalCount(String search, String txtsearch) {
		// TODO Auto-generated method stub
		Connection conn=null;
		int count=0;
		
		try {
			DBConnection db=DBConnection.getinstance();
			conn=db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao=BoardDAO.getDAO();
			count=dao.getTotalCountData(conn, search, txtsearch);
			
			conn.commit();
		}catch(NamingException|SQLException e) {
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return count;
	}
	public void repInsert(ReplyDTO dto) {
		DBConnection db=DBConnection.getinstance();
		Connection conn=null;
		try {
			conn=db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao=BoardDAO.getDAO();
			dao.boardRecountIncrease(conn, dto);
			dao.repInsertData(conn, dto);
			conn.commit();
		}catch(NamingException | SQLException e)
		{
			System.out.println(e);
			try {conn.rollback();}catch(Exception e2) {}
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
	}
	public void repRemove(int rno, int mno, int bno) {
		DBConnection db = DBConnection.getinstance();
		Connection conn = null;
		
		try {
			conn=db.getConnection();
			conn.setAutoCommit(false);
			
			BoardDAO dao = BoardDAO.getDAO();
			dao.boardRecountDecrease(conn, bno);
			dao.repRemoveData(conn, rno);
			
			conn.commit();
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {e.printStackTrace();}
		}
		
	}
}
