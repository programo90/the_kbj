package com.thekbj.oneLine.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.thekbj.dto.ReplyDTO;
import com.thekbj.dto.TableDTO;
import com.thekbj.dto.TableReplyMemberDTO;
import com.thekbj.service.OneLineService;

/**
 * Servlet implementation class BoardListResultController
 */
@WebServlet("/oneLineListResult.do")
public class BoardListResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListResultController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doReq(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doReq(request, response);
	}
	
	public void doReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currpage = Integer.parseInt(request.getParameter("currpage"));
		int totalcount = Integer.parseInt(request.getParameter("totalcount"));
		int pageperSize = Integer.parseInt(request.getParameter("pageperSize"));
		
		//first page ~ last page
		int startrow = ((currpage-1) * pageperSize);
		int endrow = startrow + pageperSize - 1;
		if(endrow > totalcount) endrow = totalcount;
				
		System.out.println("oneLineListResult currpage : " + currpage);
		System.out.println("oneLineListResult totalcount : " + totalcount);
		System.out.println("oneLineListResult pageperSize : " + pageperSize);
		System.out.println("oneLineListResult startrow : " + startrow);
		System.out.println("oneLineListResult endrow : " + endrow);
		
		PrintWriter out = response.getWriter();
		
		//service object create
		OneLineService service = OneLineService.getService();
		
		//board list
		List<TableReplyMemberDTO> list= service.boardscrollList(startrow,endrow);
		
		System.out.println("BoardListResultController : list=>" + list.toString());
		
		JSONArray arr = new JSONArray();
		
		for(TableReplyMemberDTO dto : list)
		{
			JSONObject ob = new JSONObject();
			
			ob.put("bno",dto.getBno());                 
			ob.put("bctg",dto.getBctg());          
			ob.put("btitle",dto.getBtitle());        
			ob.put("bcontent",dto.getBcontent());      
			ob.put("bwrdate",dto.getBwrdate());       
			ob.put("bviewcount",dto.getBviewcount());       
			ob.put("btag",dto.getBtag());          
			ob.put("brecount",dto.getBrecount());         
			ob.put("blikecount",dto.getBlikecount());       
			ob.put("bimg",dto.getBimg());          
			ob.put("bnick",dto.getBnick());         
			ob.put("rno",dto.getRno());              
			ob.put("rcontent",dto.getRcontent());      
			ob.put("rwrdate",dto.getRwrdate());       
			ob.put("rnick",dto.getRnick());
			
			arr.add(ob);
		}			      
					          
		out.print(arr);       
	}

	
	
	
	
	
	
	
	
	
	
}
