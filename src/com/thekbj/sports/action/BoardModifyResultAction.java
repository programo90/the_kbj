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
		int bno = Integer.parseInt(request.getParameter("bno"));
		int mno = Integer.parseInt(request.getParameter("mno"));
		String mnick = request.getParameter("mnick");
		String bctg = request.getParameter("bctg");
		String btag = request.getParameter("btag");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bimg = request.getParameter("bimg");
		
		TableDTO dto=new TableDTO();
		dto.setBno(bno);
		dto.setMno(mno);
		dto.setMnick(mnick);
		dto.setBctg(bctg);
		dto.setBtag(btag);
		dto.setBtitle(btitle);
		dto.setBcontent(bcontent);
		dto.setBimg(bimg);
		
		SportsService service=SportsService.getService();
		service.boardModifyResultData(dto);
		
		ForwardAction forward=new ForwardAction();
		forward.setForward(false);
		forward.setUrl("sportsList.do");
		return forward;
	}
}