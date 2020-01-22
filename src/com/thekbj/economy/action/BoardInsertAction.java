package com.thekbj.economy.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;

public class BoardInsertAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String curr = request.getParameter("curr");
		
		request.setAttribute("curr", curr);
		
		ForwardAction f=new ForwardAction();
		f.setForward(true);
		f.setUrl("/WEB-INF/eco/insert.jsp");
		
		return f;
	}

}