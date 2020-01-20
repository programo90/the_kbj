package com.thekbj.sports.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.TableDTO;
import com.thekbj.service.SportsService;

public class BoardModifyResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bno=Integer.parseInt(request.getParameter("bno"));
		String bctg=request.getParameter("bctg");
		String btitle=request.getParameter("btitle");
		
		TableDTO dto=new TableDTO();
		dto.setBno(bno);
		dto.setBctg(bctg);
		dto.setBtitle(btitle);
		
		SportsService service=SportsService.getService();
		service.boardModifyResultData(dto);
		
		ForwardAction forward=new ForwardAction();
		forward.setForward(false);
		forward.setUrl("sportsList.do");
		return forward;
	}
}