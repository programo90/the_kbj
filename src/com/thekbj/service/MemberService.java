package com.thekbj.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.thekbj.comm.DBConnection;
import com.thekbj.dto.MemberDTO;
import com.thekbj.member.dao.MemberDAO;

public class MemberService {
	
	private static MemberService memberservice = new MemberService();
	
	private MemberService() {}

	public static MemberService getMemberservice() {
		return memberservice;
	}

	public MemberDTO LoginComfirm(String mid, String newmpw) {
		// TODO Auto-generated method stub
		System.out.println("MemberLoginSessionAction LoginComfirm service start");
		Connection conn = null;
		
		MemberDTO dto = null;
		try {
			DBConnection dbconn = DBConnection.getinstance();
			conn = dbconn.getConnection();
			conn.setAutoCommit(false);
			
			MemberDAO dao = MemberDAO.getDao();
			dto = dao.LoginComfirmData(conn, mid, newmpw);
			
			conn.commit();
		}catch(SQLException | NamingException e) {
			try {conn.close();}catch(Exception e2) {}
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();}catch(Exception e2) {}
			System.out.println("MemberLoginSessionAction LoginComfirm service end");
		}
		
		return dto;
	}

	public int memberJoin(MemberDTO dto) {
		System.out.println("MemberJoinResultAction memberJoin service start");
		Connection conn = null;
		int result = 0;
		
		try {
			DBConnection dbconn = DBConnection.getinstance();
			conn = dbconn.getConnection();
			conn.setAutoCommit(false);
			
			MemberDAO dao = MemberDAO.getDao();
			 result = dao.MemberJoinData(conn, dto);
			
			conn.commit();
		}catch(SQLException | NamingException e) {
			try {conn.close();}catch(Exception e2) {}
			System.out.println("MemberJoinResultAction Exception : "+e);
		}finally {
			if(conn!=null) try {conn.close();}catch(Exception e2) {}
			System.out.println("MemberJoinResultAction memberJoin service end");
		}
			
		return result;
	}
	
	
	
}
