package com.thekbj.it.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.thekbj.dto.ReplyDTO;
import com.thekbj.service.ItService;

/**
 * Servlet implementation class BoardLikeController
 */
@WebServlet("/itLikeCount.do")
public class BoardLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardLikeController() {
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
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		int mno = Integer.parseInt(request.getParameter("mno"));
				
		ItService service = ItService.getInstance();
		int blikecount = service.boardLike(bno,mno);
		JSONObject jobj = new JSONObject();
		jobj.put("blikecount", blikecount);
		
		out.print(jobj);
		
		
		/*
		HttpSession session = request.getSession();
		if(session.getAttribute("likelist")==null) {
			System.out.println("insert liketable");
			List<Integer> likelist = new ArrayList<Integer>();
			session.setAttribute("likelist", likelist);
			likelist.add(bno);
			System.out.println(bno);
		} else {
			System.out.println("get likelist");
			System.out.println(bno);
			List<Integer> likelist = (List<Integer>)session.getAttribute("likelist");
			likelist.add(bno);
		}*/
		
		
		
	}
}
