package com.thekbj.it.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.TableDTO;
import com.thekbj.service.ItService;

public class BoardListAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//search
		String searchTag = request.getParameter("searchTag");
		String searchtxt= request.getParameter("searchtxt");
		
		if(searchTag==null) {
			searchTag="";
		}
		if(searchtxt==null) {
			searchtxt = "";
		}
		
		//paging
		String curr = request.getParameter("curr");
		int currPage = 1;
		
		if(curr!=null) {
			currPage = Integer.parseInt(curr);
		}
		
		int totalRow = 1;
		int startRow = 1;
		int endRow = 1;
		if(endRow>totalRow) {
			endRow = totalRow;
		}
		
		int totalPage = 6;
		int startPage = 1;
		int endPage = 5;
		
		if( endPage > totalPage) {
			endPage = totalPage;
		}
		
		//get list
		ItService service = ItService.getInstance();
		List<TableDTO> list = service.boardList(startRow, endRow, searchTag, searchtxt);
		
		//forward
		ForwardAction forward = new ForwardAction();
		forward.setForward(true);
		forward.setUrl("/WEB-INF/it/list.jsp");
		
		return forward;
	}

}
