package com.thekbj.economy.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.TableDTO;
import com.thekbj.service.EconomyService;


public class BoardListAction implements Action{

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bview= request.getParameter("bview");
		int currpage=1;
		String curr=request.getParameter("curr");
		if(curr!=null) {
			currpage=Integer.parseInt(curr);
		}
		
		if(bview==null) {
			bview="";
		}
		
		//�˻�
		String search=request.getParameter("search");
		String txtsearch=request.getParameter("txtsearch");
		if(search==null) {
			search="";
		}
		if(txtsearch==null) {
			txtsearch="";
		}
		
		EconomyService service=EconomyService.getService();
		
		int totalcount=service.getTotalCount(search,txtsearch);
		int pagepercount=5;
		int totalpage=(int)Math.ceil((float)totalcount/pagepercount);
				
		int startrow=(currpage-1)*pagepercount;
		
		int blockcount=5;
		int startblock=(currpage-1)/blockcount*blockcount+1;
		int endblock=startblock+blockcount-1;
		if(endblock>totalpage) {
			endblock=totalpage;
		}
		
		List<TableDTO> list =service.boardList(bview,startrow, pagepercount, search, txtsearch);
		request.setAttribute("list", list);
		request.setAttribute("currpage", currpage);
		request.setAttribute("startblock", startblock);
		request.setAttribute("endblock", endblock);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("search", search);
		request.setAttribute("txtsearch", txtsearch);
		request.setAttribute("bview", bview);
		request.setAttribute("pagepercount", pagepercount);
	
		
		ForwardAction f = new ForwardAction();
		f.setForward(true);
		f.setUrl("/WEB-INF/eco/list.jsp");
		
		return f;
	}
}