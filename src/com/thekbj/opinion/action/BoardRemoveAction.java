package com.thekbj.opinion.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.service.OpinionService;

public class BoardRemoveAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int bno = Integer.parseInt(request.getParameter("bno"));
		
		OpinionService service = OpinionService.getService();
		service.boardRemove(bno);
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(false);
		forward.setUrl("opinionlist.do");
		return forward;

	}

}
