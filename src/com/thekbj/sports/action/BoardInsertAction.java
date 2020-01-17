package com.thekbj.sports.action;

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
		// TODO Auto-generated method stub
		ForwardAction forward=new ForwardAction();
		forward.setForward(true);
		forward.setUrl("/WEB-INF/sports/insert.jsp");
		return forward;
	}
}