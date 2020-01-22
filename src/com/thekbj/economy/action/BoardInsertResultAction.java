package com.thekbj.economy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.TableDTO;
import com.thekbj.service.EconomyService;

public class BoardInsertResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();		
		int mno = (Integer)session.getAttribute("mno");
		
		String bctg=request.getParameter("bctg");
		String btitle=request.getParameter("btitle");
		String bcontent=request.getParameter("bcontent");
		
		TableDTO dto=new TableDTO();
		dto.setBctg(bctg);
		dto.setBtitle(btitle);
		dto.setBcontent(bcontent);
		dto.setMno(mno);
		
		EconomyService service=EconomyService.getService();
		service.boardInesertResult(dto);
		
		ForwardAction f=new ForwardAction();
		f.setForward(false);
		f.setUrl("economyList.do");
		
		
		return f;
	}

}
