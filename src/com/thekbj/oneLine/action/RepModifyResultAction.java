package com.thekbj.oneLine.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.ReplyDTO;
import com.thekbj.dto.TableDTO;
import com.thekbj.service.OneLineService;

public class RepModifyResultAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("BoardModifyResultAction load");
		
		int rno = Integer.parseInt(request.getParameter("rno"));
		String rcontent = request.getParameter("bcontent");
		
		ReplyDTO dto = new ReplyDTO();
		dto.setRno(rno);
		dto.setRcontent(rcontent);
		
		OneLineService service = OneLineService.getService();
		int result = service.repModifyResult(dto);
		
		System.out.println(dto.getRno());
		System.out.println(dto.getRcontent());
		request.setAttribute("result", result);
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(false);
		forward.setUrl("oneLineList.do");
		
		return forward;
	}

}
