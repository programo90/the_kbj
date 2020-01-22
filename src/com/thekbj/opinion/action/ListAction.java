package com.thekbj.opinion.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.TableDTO;
import com.thekbj.service.OpinionService;

public class ListAction implements Action {


	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		OpinionService service = OpinionService.getService();
		String bctg = "op";
		String btag = request.getParameter("btag");
		if(btag==null) {
			btag="";
		}
		
		//search
		String searchType = request.getParameter("searchType");
		String searchtxt= request.getParameter("searchtxt");
		
		if(searchType==null) {
			searchType="";
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
		
		int rowPerPage = 5;
		int totalRow = service.getTotalCount();
		int startRow = (currPage-1)*rowPerPage+1;
		int endRow = startRow+rowPerPage-1;
		if(endRow>totalRow) {
			endRow = totalRow;
		}
		
		int pagePerBlock = 5;
		int totalPage = (int)Math.ceil((double)totalRow/pagePerBlock);
		int startPage = ((currPage-1)/pagePerBlock)*pagePerBlock+1;
		int endPage = startPage+pagePerBlock-1;
		if( endPage > totalPage) {
			endPage = totalPage;
		}
		
		//get list
		List<TableDTO> list = service.boardList(bctg,btag,startRow, endRow, searchType, searchtxt);
	
		request.setAttribute("list", list);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("curr", currPage);
		request.setAttribute("searchType", searchType);
		request.setAttribute("searchtxt", searchtxt);
		request.setAttribute("btag", btag);
		System.out.println("list:"+list.get(0).getBno());	
		
		//forward
		ForwardAction forward = new ForwardAction();
		forward.setForward(true);
		forward.setUrl("/WEB-INF/opinion/list.jsp");
		
		return forward;
	}

}
