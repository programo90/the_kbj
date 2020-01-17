package com.thekbj.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.thekbj.comm.DBConnection;
import com.thekbj.dto.TableDTO;
import com.thekbj.it.dao.BoardDAO;

public class ItService {
	private static ItService service = new ItService();
	public static ItService getInstance() {
		return service;
	}
	public List<TableDTO> boardList(int startRow, int endRow, String searchTag, String searchtxt) {
		// TODO Auto-generated method stub
		List<TableDTO> list = null;
		DBConnection db = DBConnection.getinstance();
		Connection conn = null;
		
		try {
			conn = db.getConnection();
			BoardDAO dao = BoardDAO.getInstance();
			
			list = dao.boardListData(conn,startRow,endRow,searchTag,searchtxt);
			
			
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	} 
}
