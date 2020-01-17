package com.thekbj.sports.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.TableDTO;
import com.thekbj.service.SportsService;

public class BoardInsertResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String btitle=request.getParameter("bctg");
		String bctg=request.getParameter("btitle");
		TableDTO dto=new TableDTO();
		dto.setBtitle(btitle);
		dto.setBctg(bctg);
		SportsService service=SportsService.getService();
		service.IsertData(dto);
		ForwardAction forward=new ForwardAction();
		forward.setForward(false);
		forward.setUrl("sportsList.do");
		
		return forward;
	}
}