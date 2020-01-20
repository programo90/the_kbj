package com.thekbj.enter.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.TableDTO;
import com.thekbj.service.EnterService;

public class BoardDetailAction implements Action{

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bno=request.getParameter("bno");
	      int boardnum=1;
	      if(bno!=null && !bno.equals(""))
	      {
	         boardnum=Integer.parseInt(bno);
	         System.out.println("bno"+bno);
	      }
		EnterService service=EnterService.geEnterService();
		TableDTO dto=service.boardDetail(boardnum);
		request.setAttribute("dto", dto);
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(true);
		forward.setUrl("/WEB-INF/enter/detail.jsp");
		
		return forward;
	}

}
