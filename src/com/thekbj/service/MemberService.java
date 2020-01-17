package com.thekbj.service;

import java.util.List;

import com.thekbj.dto.MemberDTO;

public class MemberService {
	
	private static MemberService memberservice = new MemberService();
	
	private MemberService() {}

	public static MemberService getMemberservice() {
		return memberservice;
	}


	public int getTotalCount(String search, String txtsearch) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<MemberDTO> boardList(int startrow, int endrow, String search, String txtsearch) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
