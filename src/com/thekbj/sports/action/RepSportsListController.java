package com.thekbj.sports.action;

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
import com.thekbj.service.SportsService;

/**
 * Servlet implementation class RepListController
 */
@WebServlet("/repsportsdetail.do")
public class RepSportsListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RepSportsListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doreq(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doreq(request, response);
	}
	private void doreq(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		response.setContentType("application/json; charset=utf-8"); 
		PrintWriter out=response.getWriter();
		int bno=Integer.parseInt(request.getParameter("bno"));
		SportsService service=SportsService.getService();
		List<ReplyDTO> replyList=service.repList(bno);
		System.err.println(replyList);
		System.out.println("size : "+replyList.size());
		JSONArray arr=new JSONArray();
		for(ReplyDTO repdto:replyList) {
			JSONObject jsonobject=new JSONObject();
			jsonobject.put("rno", repdto.getRno());
			jsonobject.put("rcontent", repdto.getRcontent());
			jsonobject.put("rwrdate", repdto.getRwrdate());
			jsonobject.put("mnick", repdto.getMnick());
			jsonobject.put("bno", repdto.getBno());
			jsonobject.put("mno", repdto.getMno());
			arr.add(jsonobject);
		}
		out.print(arr);
	}


}
