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
	
		MemberDTO dto = (MemberDTO)session.getAttribute("dto");
		System.out.println("MemberLoginResultAction : dto =>" + dto);
				
		ForwardAction forward = new ForwardAction();
		
		if(dto == null)
		{
			//로그인 실패시
			forward.setForward(false);
			forward.setUrl("memberLogin.do");
		}
		else
		{
			//로그인 성공시
			forward.setForward(true);
			forward.setUrl("/WEB-INF/comm/index.jsp");
		}
		
		return forward;
	}

}
