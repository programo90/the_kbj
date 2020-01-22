package com.thekbj.comm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.dto.TableDTO;
import com.thekbj.service.ItService;

public class MainAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		ItService service = ItService.getInstance();
		
		List<TableDTO> list = service.allList();
		
		request.setAttribute("list", list);
		ForwardAction forward = new ForwardAction();
		forward.setForward(true);
		forward.setUrl("/WEB-INF/comm/index.jsp");
		
		return forward;
	}

}
