package com.thekbj.it.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.TableDTO;
import com.thekbj.service.ItService;

public class BoardDetailAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String bnum = request.getParameter("bno");
		int bno = 1;
		if(bnum!=null && !bnum.equals("")) {
			bno = Integer.parseInt(bnum);
		}
		
		ItService service = ItService.getInstance();
		//incre view count
		
		TableDTO dto = null;
		dto = service.boardDetail(bno);
		
		HttpSession session = request.getSession();
		int mno=0;
		
		if(session.getAttribute("mno")!=null) {
			mno = (int)session.getAttribute("mno");
		}
		
		request.setAttribute("mmno", mno);
		request.setAttribute("bdto", dto);
		
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(true);
		forward.setUrl("/WEB-INF/it/detail.jsp");
		return forward;
	}

}
