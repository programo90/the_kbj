package com.thekbj.economy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.ReplyDTO;
import com.thekbj.dto.TableDTO;
import com.thekbj.service.EconomyService;
import java.util.List;

public class BoardDetailAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bno=request.getParameter("num");
		int boardnum=1;
		if(bno!=null && !bno.equals(""))
		{
			boardnum=Integer.parseInt(bno);
		}
		EconomyService service=EconomyService.getService();
		
		TableDTO dto=service.boardDetail(boardnum);
		request.setAttribute("dto", dto);
		
		List<ReplyDTO> repl = service.repList(dto.getBno());
		request.setAttribute("repl", repl);		
	
		ForwardAction f=new ForwardAction();
		f.setForward(true);
		f.setUrl("/WEB-INF/eco/detail.jsp");
		
		return f;
	}
}