package com.thekbj.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.thekbj.comm.DBConnection;
import com.thekbj.dto.ReplyDTO;
import com.thekbj.dto.TableDTO;
import com.thekbj.eco.dao.BoardDAO;
import com.thekbj.eco.dao.RepleDao;


public class EconomyService {
	private static EconomyService service=new EconomyService();
	private EconomyService() {}
	
	public static EconomyService getService() {
		return service;
	}
	
	public List<TableDTO> boardList(int startrow, int pagepercount, String search, String txtsearch) {
		Connection conn=null;
		List<TableDTO> list=null;
		try {
			DBConnection db=DBConnection.getinstance();
			conn=db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao=BoardDAO.getDAO();
			list=dao.boardListData(conn, startrow, pagepercount, search, txtsearch);
		}catch(NamingException | SQLException e) {
			try {conn.rollback();} catch(Exception e2) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return list;
	}

	public void boardInesertResult(TableDTO dto)
	{
		DBConnection db=DBConnection.getinstance();
		Connection conn=null;
		try {
			conn=db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao=BoardDAO.getDAO();
			dao.boardInsertData(conn,dto);
			conn.commit();
		}catch(NamingException|SQLException e)
		{
			System.out.println(e);
			try{conn.rollback();}catch(Exception e2){}
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}	
	}

	public TableDTO boardDetail(int boardnum) {
		DBConnection db=DBConnection.getinstance();
		Connection conn=null;
		TableDTO dto=new TableDTO();
		try {
			conn=db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao=BoardDAO.getDAO();
			dto=dao.boardDetailData(conn, boardnum);
			dao.viewcount(conn, boardnum);
			conn.commit();
		}catch(NamingException|SQLException e)
		{
			System.out.println(e);
			try {conn.rollback();}catch(Exception e2) {}
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return dto;
	}

	public int boardRemove(int bno) {
		DBConnection db=DBConnection.getinstance();
		Connection conn=null;
		int result=0;
		try {
			conn=db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao=BoardDAO.getDAO();
			result=dao.boardRemoveData(conn,bno);
			conn.commit();
		}catch(NamingException|SQLException e)
		{
			System.out.println(e);
			try {conn.rollback();}catch(Exception e2) {}
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return bno;
	}

	public int boardModify(TableDTO dto)  {
		Connection conn=null;
		int result=0;
		try {
			DBConnection db=DBConnection.getinstance();
			conn=db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao=BoardDAO.getDAO();
	
			result=dao.boardModifyData(conn, dto);
			
			conn.commit();
		}catch(NamingException|SQLException e)
		{
			System.out.println(e);
			try {conn.rollback();}catch(Exception e2) {}
		}finally {
			if(conn!=null) try {conn.close();}catch(SQLException e) {}
		}
		return result;
	}
	
	public int getTotalCount(String search, String txtsearch) {
		Connection conn=null;
		int totalcount=0;
		try {
			DBConnection db=DBConnection.getinstance();
			conn=db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao=BoardDAO.getDAO();
			totalcount=dao.getTotalCountData(conn,search, txtsearch);
			
		}catch(NamingException|SQLException e)
		{
			System.out.println(e);
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return totalcount;
	}


	public List<ReplyDTO> repList(int bno) {
		Connection conn=null;
		List<ReplyDTO> list=null;
		try {
			DBConnection db=DBConnection.getinstance();
			conn=db.getConnection();
			conn.setAutoCommit(false);
			
			RepleDao dao=RepleDao.getDAO();
			list=dao.repListData(conn, bno);
			
		}catch(NamingException | SQLException e) {
			try {conn.rollback();} catch(Exception e2) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return list;
	}

	public void repInsert(ReplyDTO dto) {
		DBConnection db=DBConnection.getinstance();
		Connection conn=null;
		try {
			conn=db.getConnection();
			conn.setAutoCommit(false);
			RepleDao dao=RepleDao.getDAO();
			dao.repInsertData(conn,dto);
			conn.commit();
		}catch(NamingException|SQLException e)
		{
			System.out.println(e);
			try{conn.rollback();}catch(Exception e2){}
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}	
	}

	public int repRemove(int bno,int rno, int mno) {
		DBConnection db=DBConnection.getinstance();
		Connection conn=null;
		int result=0;
		try {
			conn=db.getConnection();
			conn.setAutoCommit(false);
			RepleDao dao=RepleDao.getDAO();
			result=dao.repRemoveData(conn,bno,rno,mno);
			conn.commit();
		}catch(NamingException|SQLException e)
		{
			System.out.println(e);
			try {conn.rollback();}catch(Exception e2) {}
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return bno;
	}
		
}	