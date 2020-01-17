package com.thekbj.service;

import java.util.List;

import com.thekbj.dto.MemberDTO;

public class MemberService {
	
	private static MemberService memberservice = new MemberService();
	
	private MemberService() {}

	public static MemberService getMemberservice() {
		return memberservice;
	}
	
	public int getCount(String search, String txtsearch) {
		// TODO @일진 수정 중입니다. 
		return 0;
	}

	public List<MemberDTO> getList(int startrow, int endrow, String search, String txtsearch) {
		// TODO @일진 수정 중입니다.
		return null;
	}

	
	
	
}
