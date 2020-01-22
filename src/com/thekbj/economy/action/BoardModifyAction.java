package com.thekbj.economy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.TableDTO;
import com.thekbj.service.EconomyService;

public class BoardModifyAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bno=Integer.parseInt(request.getParameter("num"));
		EconomyService service=EconomyService.getService();
		TableDTO dto=service.boardDetail(bno);
		request.setAttribute("dto", dto);
		
		ForwardAction f=new ForwardAction();
		f.setForward(true);
		f.setUrl("/WEB-INF/eco/modify.jsp");
		return f;
	}
}