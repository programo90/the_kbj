package com.thekbj.enter.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.service.EnterService;

public class BoardRemoveAction implements Action{

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bno=Integer.parseInt(request.getParameter("bno")) ;
		System.out.println("del"+ bno);
		EnterService service=EnterService.geEnterService();
		int result = service.boardRemove(bno);
		request.setAttribute("result", result);
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(true);
		forward.setUrl("/WEB-INF/enter/remove.jsp");
		
		return forward;
	}

}
