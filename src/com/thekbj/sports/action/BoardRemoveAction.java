package com.thekbj.sports.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.service.SportsService;

public class BoardRemoveAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bno=Integer.parseInt(request.getParameter("no"));
		SportsService service=SportsService.getService();
		service.boardRemove(bno);
		request.setAttribute("bno", bno);
		ForwardAction forward=new ForwardAction();
		forward.setForward(false);
		forward.setUrl("sportsList.do");
		return forward;
	}

}
