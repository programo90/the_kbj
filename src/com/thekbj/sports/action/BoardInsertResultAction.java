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
		System.out.println("1111");
		String bctg=request.getParameter("bctg");
		String btitle=request.getParameter("btitle");
		int mno=Integer.parseInt(request.getParameter("mno"));
		String bcontent = request.getParameter("bcontent");
		String bimg = request.getParameter("bimg");
		String btag = request.getParameter("btag");
		String mnick = request.getParameter("mnick");
		TableDTO dto=new TableDTO();
		dto.setBctg(bctg);
		dto.setBtitle(btitle);
		dto.setMno(mno);
		dto.setBtag(btag);
		dto.setBimg(bimg);
		dto.setBcontent(bcontent);
		dto.setMnick(mnick);
		System.out.println(dto);
		SportsService service=SportsService.getService();
		service.IsertData(dto);
		ForwardAction forward=new ForwardAction();
		forward.setForward(false);
		forward.setUrl("sportsList.do");
		return forward;
	}
}