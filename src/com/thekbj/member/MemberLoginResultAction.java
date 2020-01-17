package com.thekbj.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.service.MemberService;
import com.thekbj.dto.MemberDTO;

public class MemberLoginResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		//id 받음
		String mid = request.getParameter("login_id");
		//pw 받음
		String mpw = request.getParameter("login_pw");
		
		//솔트 생성
		String salt = SHA.generateSalt();
		
		//비밀번호+솔트 => 해시값으로 변환
		//String newmpw = SHA.getEncrypt(request.getParameter("login_pw"), salt);
		
		MemberService service = MemberService.getMemberservice();
		MemberDTO dto =  service.LoginComfirm(mid,mpw);
		
		String sql_mid = dto.getMid();
		String sql_mpw = dto.getMpw();
		
		//아이디 비밀번호 확인
		if(mid.equals(sql_mid) && mpw.equals(sql_mpw))
		{
			HttpSession session = request.getSession();
			session.setAttribute("id", mid);

			//2시간 세션유지
			session.setMaxInactiveInterval(60*60*2);
		}
		
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(true);
		forward.setUrl("/WEB-INF/comm/index.jsp");
		
		return forward;
	}

}
