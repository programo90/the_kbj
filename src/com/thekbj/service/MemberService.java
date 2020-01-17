package com.thekbj.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.thekbj.comm.DBConnection;
import com.thekbj.dto.MemberDTO;

public class MemberService {
	
	private static MemberService memberservice = new MemberService();
	
	private MemberService() {}

	public static MemberService getMemberservice() {
		return memberservice;
	}

	public boolean MemberLogin(String mid, String newmpw) {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		
		try {
			DBConnection dbconn = DBConnection.getinstance();
			conn = dbconn.getConnection();
			conn.setAutoCommit(false);
			
			
			
			conn.commit();
		}catch(SQLException | NamingException e) {
			System.out.println(e);
		}
		
		return false;
	}
	
	
	
}
