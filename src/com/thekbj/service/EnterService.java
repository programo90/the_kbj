package com.thekbj.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.thekbj.comm.DBConnection;
import com.thekbj.dto.TableDTO;
import com.thekbj.enter.dao.BoardDAO;

public class EnterService {
	private static EnterService service=new EnterService();
	private EnterService() {}
	public static EnterService geEnterService() {
		return service;
	}
	public List<TableDTO> boardList() {
		Connection conn=null;
		List<TableDTO> list=null;
		try {
			DBConnection db=DBConnection.getinstance();
			conn=db.getConnection();
			conn.setAutoCommit(false);
			BoardDAO dao=BoardDAO.getBoardDAO();
			list=dao.boardListData(conn);
		}catch(NamingException | SQLException e) {
			try {conn.rollback();} catch(Exception e2) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		return list;
	}
	
}
