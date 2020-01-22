package com.thekbj.sports.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.service.ItService;
import com.thekbj.service.SportsService;

public class RepRemoveAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int rno = Integer.parseInt(request.getParameter("rno"));
		int mno=Integer.parseInt(request.getParameter("mno"));
		int bno=Integer.parseInt(request.getParameter("bno"));
		
		System.out.println(rno+","+mno+","+bno);
		SportsService service = SportsService.getService();
		service.repRemove(rno,mno,bno);
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(false);
		forward.setUrl("sportsDetail.do?bno="+bno);
		
		return forward;
	}

}
