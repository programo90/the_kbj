package com.thekbj.oneLine.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.service.OneLineService;

public class BoardRemoveAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("BoardRemoveAction load");
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		OneLineService service = OneLineService.getService();
		int result = service.boardRemove(bno);
		System.out.println("BoardRemoveAction bno : " + bno);
		
		request.setAttribute("result", result);
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(true);
		forward.setUrl("/WEB-INF/oneLine/del.jsp");
		 
		return forward;
	}

}
