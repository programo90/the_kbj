package com.thekbj.it.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;

public class BoardListAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String searchTag = request.getParameter("searchTag");
		String searchtxt= request.getParameter("searchtxt");
		
		if(searchTag==null) {
			searchTag="";
		}
		if(searchtxt==null) {
			searchtxt = "";
		}
		
		
		String curr = request.getParameter("curr");
		int currPage = 1;
		
		if(curr!=null) {
			currPage = Integer.parseInt(curr);
		}
		
		int total_row;
		
		
		
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(true);
		forward.setUrl("/it/list.jsp");
		
		return forward;
	}

}
