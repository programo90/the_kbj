package com.thekbj.it.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.service.ItService;

public class RepRemoveAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int rno = Integer.parseInt(request.getParameter("rno"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		
		ItService service = ItService.getInstance();
		service.repRemove(rno);
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(false);
		forward.setUrl("itDetail.do?bno="+bno);
		
		return forward;
	}

}
