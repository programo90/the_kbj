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
		//id 받음
		String mid = request.getParameter("login_id");
		//pw 받음
		String mpw = request.getParameter("login_pw");
		
		//솔트 생성
		String salt = SHA.generateSalt();
		
		//나중에 주석 풀꺼임
		//비밀번호+솔트 => 해시값으로 변환
		//String newmpw = SHA.getEncrypt(mpw, salt);
		
		MemberService service = MemberService.getMemberservice();
		MemberDTO dto =  service.LoginComfirm(mid,mpw);
		
		String sql_mid = dto.getMid();
		String sql_mpw = dto.getMpw();
		System.out.println("MemberLoginSessionAction : id가 같은값 있는지 확인 => "+"sql_mid : "+sql_mid + ", sql_mpw : "+ sql_mpw);
		
		//아이디 비밀번호 확인
		if(mid.equals(sql_mid) && mpw.equals(sql_mpw))
		{
			HttpSession session = request.getSession();
			session.setAttribute("dto", dto);

			//2시간 세션유지
			session.setMaxInactiveInterval(60*60*2);
		}
		
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(false);
		forward.setUrl("memberLoginResult.do");
		
		return forward;
	}

}
