package com.thekbj.enter.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.ReplyDTO;
import com.thekbj.service.EnterService;

public class RepInsertAction implements Action{

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bno=Integer.parseInt(request.getParameter("bno"));
		String rcontent=request.getParameter("rcontent");
		int mno=Integer.parseInt(request.getParameter("mno"));
		
		ReplyDTO dto= new ReplyDTO();
		dto.setBno(bno);
		dto.setRcontent(rcontent);
		dto.setMno(mno);
		
		EnterService service=EnterService.geEnterService();
		service.repInsert(dto);
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(false);
		forward.setUrl("enterDetail.do?bno="+bno);
		
		return forward;
	}

}
