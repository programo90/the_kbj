package com.thekbj.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thekbj.dto.MemberDTO;
import com.thekbj.service.MemberService;

/**
 * Servlet implementation class MemberLoginResultController
 */
@WebServlet("/MemberLoginResult.do")
public class MemberLoginResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginResultController() {
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
		
		System.out.println("MemberLoginResultController Load"); 
		
		//login id 
		String mid = request.getParameter("login_id");
		//login pw 
		String mpw = request.getParameter("login_pw");
		
		//create salt
		String salt = SHA.generateSalt();
		
		//comming soon
		//salt + pw => HashCode
		//String newmpw = SHA.getEncrypt(mpw, salt);
		
		
		
		MemberService service = MemberService.getMemberservice();
		MemberDTO dto =  service.LoginComfirm(mid,mpw);
		
		String sql_mid = dto.getMid();
		String sql_mpw = dto.getMpw();
		
		System.out.println("MemberLoginResultController : id,pw sql result => "+"sql_mid : "+sql_mid + ", sql_mpw : "+ sql_mpw);
		
		/*session check*/
		if(dto.getMnick() != null && dto.getMno() > 0 && dto != null)
		{
			//original id, pw <=> select id, pw
			if(mid.equals(dto.getMid()) && mpw.equals(dto.getMpw()))
			{
				/*Login success*/
				System.out.println("MemberLoginResultController Login success : dto =>" + dto.toString());
				System.out.println("MemberLoginResultController Login success : mno =>" + dto.getMno());
				System.out.println("MemberLoginResultController Login success : mnick =>" + dto.getMnick());
				
				/*session create*/
				HttpSession session = request.getSession();
				session.setAttribute("dto", dto);
				session.setAttribute("mno", dto.getMno());
				session.setAttribute("mnick", dto.getMnick());
				
				//2 hour session
				session.setMaxInactiveInterval(60*60*2);
			}
			else
			{
				//Login fail
				response.getWriter().write("loginFail");
			}
		}
		else
		{
			response.getWriter().write("loginFail");
		}
		
	}

}
