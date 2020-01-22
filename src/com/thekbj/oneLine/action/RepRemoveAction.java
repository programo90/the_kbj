package com.thekbj.oneLine.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.service.OneLineService;

public class RepRemoveAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("RepRemoveAction load");
		
		int rno = Integer.parseInt(request.getParameter("rno"));
		
		OneLineService service = OneLineService.getService();
		int result = service.repRemove(rno);
		System.out.println("RepRemoveAction rno : " + rno);
		
		request.setAttribute("result", result);
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(true);
		forward.setUrl("/WEB-INF/oneLine/repdel.jsp");
		 
		return forward;
	}

}
