package com.thekbj.it.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.TableDTO;
import com.thekbj.service.ItService;

public class BoardInsertResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		int mno = Integer.parseInt(request.getParameter("mno"));
		String mnick = request.getParameter("mnick");
		String bctg = request.getParameter("ctg-sel");
		String btag = request.getParameter("tag-sel");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bimg = request.getParameter("bimg");
		
		System.out.println(bcontent);
		
		
		TableDTO dto = new TableDTO();
		dto.setMno(mno);
		dto.setMnick(mnick);
		dto.setBctg(bctg);
		dto.setBtag(btag);
		dto.setBtitle(btitle);
		dto.setBcontent(bcontent);
		dto.setBimg(bimg);
		
		ItService service = ItService.getInstance();
		service.boardInsertResult(dto);
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(false);
		forward.setUrl("itList.do");
		
		return forward;
	}

}
