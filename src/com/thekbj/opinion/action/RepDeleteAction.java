package com.thekbj.opinion.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.service.OpinionService;

public class RepDeleteAction implements Action{

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
				int rno = Integer.parseInt(request.getParameter("rno"));
				int bno = Integer.parseInt(request.getParameter("bno"));
				System.out.println("action rno , bno : "+ rno +", " + bno );
				
				OpinionService service = OpinionService.getService();
				service.repRemove(rno,bno);
				
				ForwardAction forward = new ForwardAction();
				forward.setForward(false);
				forward.setUrl("opiniondetail.do?bno="+bno);
				
				return forward;
	}

}
