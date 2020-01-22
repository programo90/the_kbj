package com.thekbj.oneLine.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.TableDTO;
import com.thekbj.service.OneLineService;

public class BoardModifyAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("BoardModifyAction");
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		OneLineService service = OneLineService.getService();
		TableDTO dto = service.boardModify(bno);
		
		request.setAttribute("dto", dto);
		System.out.println("BoardModifyAction dto.getBno() : " + dto.getBno());
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(true);
		forward.setUrl("/WEB-INF/oneLine/modify.jsp");
		return forward;
	}

}
