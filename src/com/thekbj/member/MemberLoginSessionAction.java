package com.thekbj.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.MemberDTO;
import com.thekbj.service.MemberService;

public class MemberLoginSessionAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MemberLoginSessionAction Load"); 
		
		//login id 
		String mid = request.getParameter("login_id");
		//login pw 
		String mpw = request.getParameter("login_pw");
		
		//create salt
		String salt = SHA.generateSalt();
		
		//comming soon
		//salt + pw => HashCode
		//String newmpw = SHA.getEncrypt(mpw, salt);
		
		MemberService service = MemberService.getMemberservice();
		MemberDTO dto =  service.LoginComfirm(mid,mpw);
		
		String sql_mid = dto.getMid();
		String sql_mpw = dto.getMpw();
		
		System.out.println("MemberLoginSessionAction : id,pw equals => "+"sql_mid : "+sql_mid + ", sql_mpw : "+ sql_mpw);
		
		//original id, pw <=> select id, pw
		if(mid.equals(sql_mid) && mpw.equals(sql_mpw))
		{
			HttpSession session = request.getSession();
			session.setAttribute("mno", dto.getMno());
			session.setAttribute("mnick", dto.getMnick());

			//2 hour session
			session.setMaxInactiveInterval(60*60*2);
		}
		
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(false);
		forward.setUrl("memberLoginResult.do");
		
		return forward;
	}

}
