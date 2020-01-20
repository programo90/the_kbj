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
@WebServlet("/sportsRepList.do")
public class RepListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RepListController() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		int bno=Integer.parseInt(request.getParameter("bno"));
		SportsService service=SportsService.getService();
		List<ReplyDTO> list= service.repList(bno);
		
		JSONArray arr=new JSONArray();
		for(ReplyDTO dto:list)
		{
			JSONObject o=new JSONObject();
			o.put("rno", dto.getRno());
			o.put("bno", dto.getBno());
			o.put("rcontent", dto.getRcontent());
			o.put("rwdate", dto.getRwdate());
			arr.add(o);
		}
		out.print(arr);
	}

}
