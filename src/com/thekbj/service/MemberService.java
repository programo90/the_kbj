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
		System.out.println("MemberLoginSessionAction LoginComfirm : 로그인 Service 요청");
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
			if(conn!=null) try {conn.close();}catch(Exception e2) {}
			System.out.println(e);
		}finally {
			System.out.println("MemberLoginSessionAction LoginComfirm : 로그인 Service 요청 정상 종료");
		}
		
		return dto;
	}

	public int memberJoin(MemberDTO dto) {
		System.out.println("MemberJoinResultAction memberJoin : 회원가입 Service 요청");
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
			if(conn!=null) try {conn.close();}catch(Exception e2) {}
			System.out.println("MemberJoinResultAction Exception : "+e);
		}finally {
			System.out.println("MemberJoinResultAction memberJoin : 회원가입 Service 요청 정상 종료");
		}
			
		return result;
	}
	
	
	
}
