package com.thekbj.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.thekbj.comm.DBConnection;
import com.thekbj.dto.ReplyDTO;
import com.thekbj.dto.TableDTO;
import com.thekbj.enter.dao.BoardDAO;

public class EnterService {
	private static EnterService service=new EnterService();
	private EnterService() {}
	public static EnterService geEnterService() {
		return service;
	}
	public List<TableDTO> boardList(int startrow, int pagepercount, String search, String txtsearch) {
		Connection conn=null;
		List<TableDTO> list=null;
		try {
			DBConnection db=DBConnection.getinstance();
			conn=db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao=BoardDAO.getBoardDAO();
			list=dao.boardListData(conn, startrow, pagepercount, search, txtsearch);
		}catch(NamingException | SQLException e) {
			try {conn.rollback();} catch(Exception e2) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return list;
	}
	public void boardInsertResult(TableDTO dto) {
		// TODO Auto-generated method stub
		DBConnection db=DBConnection.getinstance();
		Connection conn=null;
		try {
			conn=db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao=BoardDAO.getBoardDAO();
			dao.boardInsertData(conn, dto);
			
			conn.commit();
		}catch(NamingException | SQLException e) {
			try {conn.rollback();} catch(SQLException e2) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
	}
	public TableDTO boardDetail(int boardnum) {
		// TODO Auto-generated method stub
		DBConnection db=DBConnection.getinstance();
		Connection conn=null;
		TableDTO dto=new TableDTO();
		
		try {
			conn=db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao=BoardDAO.getBoardDAO();
			
			dao.recount(conn, boardnum);
			System.out.println("boardnum : "+boardnum);
			
			dto=dao.boardDetailData(conn, boardnum);

			conn.commit();
		}catch(NamingException | SQLException e) {
			try {conn.rollback();} catch(Exception e2) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return dto;
	}
	public int boardModifyResult(TableDTO dto) {
		// TODO Auto-generated method stub
		DBConnection db=DBConnection.getinstance();
		Connection conn=null;
		int modifyresult=0;
		try {
			conn=db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao=BoardDAO.getBoardDAO();
			modifyresult=dao.boardModifyResultData(conn, dto);
			conn.commit();
		}catch(NamingException|SQLException e) {
			try {conn.rollback();} catch(Exception e2) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return modifyresult;
	}
	public int boardRemove(int bno) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		int result=0;
		
		try {
			DBConnection db=DBConnection.getinstance();
			conn=db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao=BoardDAO.getBoardDAO();
			result=dao.boardRemoveData(conn, bno);
			conn.commit();
		}catch(NamingException | SQLException e) {
			try {conn.rollback();} catch(Exception e2) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return result;
	}
	public int getTotalCount(String search, String txtsearch) {
		// TODO Auto-generated method stub
		Connection conn=null;
		int count=0;
		
		try {
			DBConnection db=DBConnection.getinstance();
			conn=db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao=BoardDAO.getBoardDAO();
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
		// TODO Auto-generated method stub
		Connection conn=null;
		
		try {
			DBConnection db=DBConnection.getinstance();
			conn=db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao=BoardDAO.getBoardDAO();
			dao.repInsertData(conn, dto);
			
			conn.commit();
		}catch(NamingException | SQLException e) {
			System.out.println(e);
			try {conn.rollback();} catch(SQLException e2) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
	}
	public List<ReplyDTO> repList(int bno) {
		// TODO Auto-generated method stub
		Connection conn=null;
		List<ReplyDTO> repdto=null;
		try {
			DBConnection db=DBConnection.getinstance();
			conn=db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao=BoardDAO.getBoardDAO();
			repdto=dao.repListData(conn, bno);
			
		}catch(NamingException|SQLException e) {
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return repdto;
	}
	public void repRemove(int rno, int mno) {
		// TODO Auto-generated method stub
		Connection conn=null;
		
		try {
			DBConnection db=DBConnection.getinstance();
			conn=db.getConnection();
			BoardDAO dao=BoardDAO.getBoardDAO();
			dao.repRemoveData(conn, rno, mno);
		}catch(NamingException | SQLException e) {
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
	}
	public void repRemoveSel(int rno, int mno) {
		// TODO Auto-generated method stub
		
	}
}
