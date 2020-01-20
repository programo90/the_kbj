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
		//id ����
		String mid = request.getParameter("login_id");
		//pw ����
		String mpw = request.getParameter("login_pw");
		
		//��Ʈ ����
		String salt = SHA.generateSalt();
		
		//���߿� �ּ� Ǯ����
		//��й�ȣ+��Ʈ => �ؽð����� ��ȯ
		//String newmpw = SHA.getEncrypt(mpw, salt);
		
		MemberService service = MemberService.getMemberservice();
		MemberDTO dto =  service.LoginComfirm(mid,mpw);
		
		String sql_mid = dto.getMid();
		String sql_mpw = dto.getMpw();
		System.out.println(sql_mid);
		System.out.println(sql_mpw);
		System.out.println("MemberLoginSessionAction : id�� ������ �ִ��� Ȯ�� => "+"sql_mid : "+sql_mid + ", sql_mpw : "+ sql_mpw);
		
		//���̵� ��й�ȣ Ȯ��
		if(mid.equals(sql_mid) && mpw.equals(sql_mpw))
		{
			HttpSession session = request.getSession();
			session.setAttribute("dto", dto);

			//2�ð� ��������
			session.setMaxInactiveInterval(60*60*2);
		}
		
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(false);
		forward.setUrl("memberLoginResult.do");
		
		return forward;
	}

}
