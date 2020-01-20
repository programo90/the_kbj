package com.thekbj.enter.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.TableDTO;
import com.thekbj.service.EnterService;

public class BoardListAction implements Action{

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int currpage=1;
		String curr=request.getParameter("curr");
		if(curr!=null) {
			currpage=Integer.parseInt(curr);
		}
		
		//검색
		String search=request.getParameter("search");
		String txtsearch=request.getParameter("txtsearch");
		if(search==null) {
			search="";
		}
		if(txtsearch==null) {
			txtsearch="";
		}
		
		EnterService service=EnterService.geEnterService();
		
		int totalcount=service.getTotalCount(search, txtsearch);
		int pagepercount=5;
		int totalpage=(int)Math.ceil((float)totalcount/pagepercount);
		/*int startrow=(currpage-1)*pagepercount+1; 원래*/
		/*int startrow=(currpage-1)*pagepercount+1;
		int endrow=startrow+pagepercount-1;
		if(endrow>totalcount) endrow=totalcount;*/
		
		int startrow=(currpage-1)*pagepercount;
		
		int blockcount=5;
		int startblock=(currpage-1)/blockcount*blockcount+1;
		int endblock=startblock+blockcount-1;
		if(endblock>totalpage) {
			endblock=totalpage;
		}
		
		List<TableDTO> list =service.boardList(startrow, pagepercount, search, txtsearch);
		request.setAttribute("list", list);
		request.setAttribute("currpage", currpage);
		request.setAttribute("startblock", startblock);
		request.setAttribute("endblock", endblock);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("search", search);
		request.setAttribute("txtsearch", txtsearch);
		request.setAttribute("pagepercount", pagepercount);
		System.out.println("pagepercount"+pagepercount);
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(true);
		forward.setUrl("/WEB-INF/enter/list.jsp");
		
		return forward;
	}

}
