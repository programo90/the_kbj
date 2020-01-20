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
		
		/*페이징 필요한 변수*/
		
		//서비스 객체 생성
		OneLineService service = OneLineService.getService(); 
		
		//현재 페이지
		int currpage=1;
		String curr = request.getParameter("curr");
		if(curr!=null) currpage=Integer.parseInt(curr);
		
		//total 게시글수 구하기
		int totalcount = service.totalcount(); //총 글 갯수
		
		//한 페이지 글 갯수
		int pageperSize = 10;	
		int totalpage = (int) Math.ceil((float)totalcount/pageperSize); //총 블럭(10개씩) 갯수
		
		//전체 페이지
		int startrow = ((currpage-1) * pageperSize)+1;
		int endrow = startrow + pageperSize - 1;
		if(endrow > totalcount) endrow = totalcount;
		
		/*보내기위한 객체 담기*/
		
		//메인글 담기
		List<TableDTO> list= service.boardList(startrow,endrow);
		
		//리플글 담기
		List<ReplyDTO> replist = service.replyList();
				
		//request 객체에 모두 담기
		request.setAttribute("list", list);
		request.setAttribute("replist", replist);
		
		request.setAttribute("currpage", currpage);
		request.setAttribute("startrow", startrow);
		request.setAttribute("endrow", endrow);
		request.setAttribute("totalpage", totalpage);
		
		ForwardAction forward = new ForwardAction();
		forward.setForward(true);
		forward.setUrl("/WEB-INF/oneLine/list.jsp");
		 
		return forward;
	}

}
