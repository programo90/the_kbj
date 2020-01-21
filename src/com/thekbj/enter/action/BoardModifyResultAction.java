package com.thekbj.enter.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.TableDTO;
import com.thekbj.service.EnterService;

public class BoardModifyResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("test");
		
		int bno=Integer.parseInt(request.getParameter("bno"));
		String ctg=request.getParameter("bctg");
		String title=request.getParameter("btitle");
		String content=request.getParameter("bcontent");
		String tag=request.getParameter("btag");
		
		TableDTO dto=new TableDTO();
		dto.setBno(bno);
		dto.setBctg(ctg);
		dto.setBtitle(title);
		dto.setBcontent(content);
		dto.setBtag(tag);
		
		EnterService service = EnterService.geEnterService();
		int modifyresult=service.boardModifyResult(dto);
		request.setAttribute("modifyresult", modifyresult);
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(true);
		forward.setUrl("/WEB-INF/enter/modifyResult.jsp");
		
		return forward;
	}

}
