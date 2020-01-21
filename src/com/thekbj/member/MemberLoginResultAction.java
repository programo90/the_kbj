package com.thekbj.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.MemberDTO;

public class MemberLoginResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MemberLoginResultAction Load"); 
		
		HttpSession session = request.getSession();
	
		int mno = (int)session.getAttribute("mno");
		String mnick = (String)session.getAttribute("mnick");
		System.out.println("MemberLoginResultAction : mno =>" + mno);
		System.out.println("MemberLoginResultAction : mnick =>" + mnick);
				
		ForwardAction forward = new ForwardAction();
		
		if(mnick != null && mno > 0)
		{
			//Login success
			forward.setForward(true);
			forward.setUrl("/WEB-INF/comm/index.jsp");
		}
		else
		{
			//Login fail
			forward.setForward(false);
			forward.setUrl("memberLogin.do");
		}
		
		return forward;
	}

}

