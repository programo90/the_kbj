package com.thekbj.oneLine.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.TableDTO;
import com.thekbj.service.ItService;
import com.thekbj.service.OneLineService;

public class BoardInsertResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int mno = Integer.parseInt(request.getParameter("mno"));
		String mnick = request.getParameter("mnick");
		String bctg = request.getParameter("ctg-sel");
		String btag = request.getParameter("tag-sel");
		String bcontent = request.getParameter("bcontent");
		
		String bimg = request.getParameter("bimg");
		
		System.out.println(bcontent);
		
		
		TableDTO dto = new TableDTO();
		dto.setMno(mno);
		dto.setMnick(mnick);
		dto.setBctg(bctg);
		dto.setBtag(btag);
		dto.setBcontent(bcontent);
		dto.setBimg(bimg);
		
		System.out.println("mno : "+dto.getMno());
		System.out.println("mnick : "+dto.getMnick());
		System.out.println("bctg : "+dto.getBctg());
		System.out.println("btag : "+dto.getBtag());
		System.out.println("bcontent : "+dto.getBcontent());
		System.out.println("bimg  : "+dto.getBimg());
		
		OneLineService service = OneLineService.getService();
		int result = service.boardInsertResult(dto);
		
		request.setAttribute("result", result);
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(false);
		forward.setUrl("oneLineList.do");
		
		return forward;
	}

}
