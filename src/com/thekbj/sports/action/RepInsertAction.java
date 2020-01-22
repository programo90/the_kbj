package com.thekbj.sports.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.ReplyDTO;
import com.thekbj.service.EnterService;
import com.thekbj.service.SportsService;

public class RepInsertAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bno=Integer.parseInt(request.getParameter("bno"));
		String rcontent=request.getParameter("rcontent");
		int mno=Integer.parseInt(request.getParameter("mno"));
		
		ReplyDTO dto= new ReplyDTO();
		dto.setBno(bno);
		dto.setRcontent(rcontent);
		dto.setMno(mno);
		
		SportsService service=SportsService.getService();
		service.repInsert(dto);
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(false);
		forward.setUrl("sportsDetail.do?bno="+bno);
		
		return forward;
	}
}
