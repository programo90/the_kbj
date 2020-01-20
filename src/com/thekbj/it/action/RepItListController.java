package com.thekbj.it.action;

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
import com.thekbj.service.ItService;

/**
 * Servlet implementation class RepListController
 */
@WebServlet("/replyList.do")
public class RepItListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RepItListController() {
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
	protected void doReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();

		int bno = Integer.parseInt(request.getParameter("num"));
		ItService service = ItService.getInstance();
		List<ReplyDTO> list = service.repList(bno);
		
		JSONArray arr = new JSONArray();
		for(ReplyDTO dto:list) {
			JSONObject jobj = new JSONObject();
			jobj.put("rno", dto.getRno());
			jobj.put("rcontent", dto.getRcontent());
			jobj.put("mnick", dto.getMnick());
			jobj.put("rwrdate", dto.getRwrdate());
			jobj.put("bno", dto.getBno());
			
			arr.add(jobj);
		}
		
		out.print(arr);
		
		
		
	}
}
