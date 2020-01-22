package com.thekbj.economy.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.ReplyDTO;
import com.thekbj.dto.TableDTO;
import com.thekbj.service.EconomyService;

public class RepRemoveAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();		
		int mno = (Integer)session.getAttribute("mno");
		int rno = Integer.parseInt(request.getParameter("rno"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		String rcontent = request.getParameter("rcontent");
				
		ReplyDTO dto=new ReplyDTO();
		dto.setBno(bno);
		dto.setRcontent(rcontent);
		dto.setMno(mno);
		
		EconomyService service=EconomyService.getService();
		service.repRemove(bno,rno,mno);
		
		TableDTO dto2=service.boardDetail(bno);
		request.setAttribute("dto", dto2);
		
		List<ReplyDTO> repl = service.repList(dto2.getBno());
		request.setAttribute("repl", repl);
		
				
		ForwardAction f=new ForwardAction();
		f.setForward(true);
		f.setUrl("/WEB-INF/eco/detail.jsp");
		
		return f;
	}

}
