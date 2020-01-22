package com.thekbj.oneLine.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.ReplyDTO;
import com.thekbj.dto.TableDTO;
import com.thekbj.service.OneLineService;

public class RepModifyAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("RepModifyAction");
		
		int rno = Integer.parseInt(request.getParameter("rno"));
		
		OneLineService service = OneLineService.getService();
		ReplyDTO dto = service.replyModify(rno);
		
		request.setAttribute("dto", dto);

		ForwardAction forward = new ForwardAction();
		forward.setForward(true);
		forward.setUrl("/WEB-INF/oneLine/repmodify.jsp");
		return forward;
	}

}
