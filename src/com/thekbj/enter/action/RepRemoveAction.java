package com.thekbj.enter.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.service.EnterService;

public class RepRemoveAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int rno=Integer.parseInt(request.getParameter("rno"));
		int mno=Integer.parseInt(request.getParameter("mno"));
		int bno=Integer.parseInt(request.getParameter("bno"));
		EnterService service=EnterService.geEnterService();

		
/*		if(mno==Membermno) {
			
		}*/
		service.repRemove(rno,mno);
		ForwardAction forward = new ForwardAction();
		forward.setForward(false);
		forward.setUrl("enterDetail.do?bno="+bno);
		
		return forward;
	}

}
