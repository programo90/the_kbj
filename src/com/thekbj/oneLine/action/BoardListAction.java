package com.thekbj.oneLine.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.comm.Action;
import com.thekbj.comm.ForwardAction;
import com.thekbj.service.OneLineService;
import com.thekbj.dto.ReplyDTO;
import com.thekbj.dto.TableDTO;

public class BoardListAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("BoardListAction Load");
		
		//service object create
		OneLineService service = OneLineService.getService(); 
		
		//current page
		int currpage=1;
		String curr = request.getParameter("curr");
		if(curr!=null) currpage=Integer.parseInt(curr);
		
		//data total count
		int totalcount = service.totalcount(); //all board count
		
		//one page count
		int pageperSize = 10;	
		//int totalpage = (int) Math.ceil((float)totalcount/pageperSize); //one block count
		
		//first page ~ last page
		int startrow = ((currpage-1) * pageperSize);
		int endrow = startrow + pageperSize - 1;
		if(endrow > totalcount) endrow = totalcount;
		
		/* data set */
		
		//board list
		List<TableDTO> list= service.boardList(startrow,endrow);
		
		//reply list
		List<ReplyDTO> replist = service.replyList();
				
		//request setting
		request.setAttribute("list", list);
		request.setAttribute("replist", replist);
		
		request.setAttribute("currpage", currpage);
		request.setAttribute("totalcount", totalcount);
		request.setAttribute("pageperSize", pageperSize);
		
		//request.setAttribute("startrow", startrow);
		//request.setAttribute("endrow", endrow);
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(true);
		forward.setUrl("/WEB-INF/oneLine/list.jsp");
		 
		return forward;
	}

}
