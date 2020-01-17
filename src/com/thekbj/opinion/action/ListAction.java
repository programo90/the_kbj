package com.thekbj.opinion.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.dto.MemberDTO;
import com.thekbj.service.MemberService;

public class ListAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int currpage = 1;
		String curr = request.getParameter("curr");
		if(curr!=null) {
			currpage = Integer.parseInt(curr);
		}
		String search = request.getParameter("search");
		String txtsearch = request.getParameter("txtsearch");
		if(search ==null)
			search = "";
		if(txtsearch == null)
			txtsearch = "";
		
		MemberService service = MemberService.getMemberservice()
		int totalcount = service.getCount(search, txtsearch);
		int pagepercount = 10;
		int totalpage = (int) Math.ceil((float)totalcount / pagepercount);
		int startrow = (currpage - 1) * pagepercount +1;
		int endrow= startrow + pagepercount -1;
		
		if(endrow > totalcount)
			endrow = totalcount;
		
		int blockcount = 5;
		int startblock = (currpage -1) / blockcount * blockcount +1;
		int endblock = startblock + blockcount -1;
		if(endblock > totalpage)
			endblock = totalpage;
		
		List<MemberDTO> list = service.getList(startrow, endrow, search, txtsearch);
		
		request.setAttribute("list", list);
		//list.size() 값 확인 할 것 
		request.setAttribute("currpage", currpage);
		request.setAttribute("startblock", startblock);
		request.setAttribute("endblock", endblock);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("search", search);
		request.setAttribute("txtsearch", txtsearch);
		
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(true);
		forward.setUrl("list.jsp");
		return forward;
	}

}
