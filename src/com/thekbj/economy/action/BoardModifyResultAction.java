package com.thekbj.economy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.TableDTO;
import com.thekbj.service.EconomyService;


public class BoardModifyResultAction implements Action {

	
	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title=request.getParameter("btitle");
		String content=request.getParameter("bcontent");
		String writer=request.getParameter("bwriter");
		int bno=Integer.parseInt(request.getParameter("bno"));
		
		TableDTO dto=new TableDTO();
		dto.setBno(bno);
		dto.setBtitle(title);
		dto.setBcontent(content);
		
		ForwardAction f=new ForwardAction();
		f.setForward(true);
		
		EconomyService service=EconomyService.getService();
		int result=service.boardModify(dto);
		if (result==1) {
			f.setUrl("economyDetail.do?num="+String.valueOf(dto.getBno()));
		}
		else {
			f.setUrl("/list.do");
		}
		return f;
	}
}