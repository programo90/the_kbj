package com.thekbj.enter.action;

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
import com.thekbj.service.EnterService;

/**
 * Servlet implementation class RepEnterListController
 */
@WebServlet("/repEnterdetail.do")
public class RepEnterListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RepEnterListController() {
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
	private void doReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8"); 
		PrintWriter out=response.getWriter();
		int bno=Integer.parseInt(request.getParameter("bno"));
		/*int Membermno=Integer.parseInt(request.getParameter("Membermno"));
		System.out.println("mno=============="+Membermno);*/
		EnterService service=EnterService.geEnterService();
		List<ReplyDTO> replyList=service.repList(bno);
		
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
