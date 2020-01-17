package com.thekbj.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thekbj.service.MemberService;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/Member*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
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
response.setContentType("application/json;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		MemberService service = MemberService.getMemberservice();
//		List<SubBoardDTO> sublist = service.subData(no);
//		
//		JSONArray arr = new JSONArray();
//		
//		for(SubBoardDTO dto:sublist)
//		{
//			JSONObject ob = new JSONObject();
//			ob.put("subno", dto.getSubno());
//			ob.put("subtitle", dto.getSubtitle());
//			ob.put("writer", dto.getWriter());
//			ob.put("boardno", dto.getBoardno());
//			
//			arr.add(ob);
//		}
//		
//		out.print(arr);
	}

}
