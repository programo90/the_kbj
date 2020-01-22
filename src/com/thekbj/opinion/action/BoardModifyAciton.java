package com.thekbj.opinion.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.TableDTO;
import com.thekbj.service.OpinionService;

public class BoardModifyAciton implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("djjjdjjjdjjjj");
		String bnum = request.getParameter("bno");
		int bno = 1;
		if(bnum!=null && !bnum.equals("")) {
			bno = Integer.parseInt(bnum);
		}
		
		OpinionService service = OpinionService.getService();
		TableDTO dto = null;
		
		dto = service.boardDetail(bno);
		
		request.setAttribute("dto", dto);
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(true);
		forward.setUrl("/WEB-INF/opinion/modify.jsp");
		return forward;

	}

}
