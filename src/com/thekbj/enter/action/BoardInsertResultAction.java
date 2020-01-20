package com.thekbj.enter.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.TableDTO;
import com.thekbj.service.EnterService;

public class BoardInsertResultAction implements Action{

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title=request.getParameter("btitle");
		String ctg=request.getParameter("bctg");
		String content=request.getParameter("bcontent");
		
		TableDTO dto=new TableDTO();
		dto.setBtitle(title);
		dto.setBctg(ctg);
		dto.setBcontent(content);
		EnterService service = EnterService.geEnterService();
		service.boardInsertResult(dto);
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(false);
		forward.setUrl("enterList.do");
		
		return forward;
	}
	
}
