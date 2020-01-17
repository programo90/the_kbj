package com.thekbj.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.thekbj.comm.DBConnection;
import com.thekbj.dto.TableDTO;
import com.thekbj.sports.dao.BoardDAO;

public class SportsService {
	private static SportsService service=new SportsService();
	private SportsService() {}
	public static SportsService getService()
	{
		return service;
	}
	public List<TableDTO> boardList() {
		// TODO Auto-generated method stub
		DBConnection db=DBConnection.getinstance();
		Connection conn=null;
		List<TableDTO> list=new ArrayList<>();
		try {
			conn=db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao=BoardDAO.getDAO();
			list=dao.boardListData(conn);
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
}
