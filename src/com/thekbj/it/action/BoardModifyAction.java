package com.thekbj.it.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.TableDTO;
import com.thekbj.service.ItService;

public class BoardModifyAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String bnum = request.getParameter("bno");
		int bno = 1;
		if(bnum!=null && !bnum.equals("")) {
			bno = Integer.parseInt(bnum);
		}
		
		ItService service = ItService.getInstance();
		TableDTO dto = null;
		
		dto = service.boardModify(bno);
		
		request.setAttribute("dto", dto);
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(true);
		forward.setUrl("/WEB-INF/it/modify.jsp");
		return forward;
	}

}
