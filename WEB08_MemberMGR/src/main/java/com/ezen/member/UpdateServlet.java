package com.ezen.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.dao.MemberDao;
import com.ezen.dto.MemberDto;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원정보수정의 보통은 회원 아이디를 전달받아 아이디로 조회한 결과를 회원수정폼으로 같이 갖고 감
//		String userid=request.getParameter("userid");
//		MemberDao mdao=MemberDao.getInstance();
//		MemberDto mdto=mdao.getMember(userid);
//		request.setAttribute("curUser", mdto);
	//이건 로그인한 유저가 남의 정보르 바꾸려고 할때 하는 방법
		
		//그러나 현재는 로그인한 유저를 수정할 예정이며, 로그인유저의 정보는 세션에 저장되어 있고, jsp페이지에서도 
		//세션값을 언제나 접근할 수 있으면서 현재는 조회코드가 생략됨
		RequestDispatcher dp = request.getRequestDispatcher("member/updateForm.jsp");
		dp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		MemberDto mdto = new MemberDto();
		
		mdto.setName(request.getParameter("name"));
		mdto.setUserid(request.getParameter("userid"));
		mdto.setPwd(request.getParameter("pwd"));
		mdto.setEmail(request.getParameter("email"));
		mdto.setPhone(request.getParameter("phone"));
		mdto.setAdmin(Integer.parseInt(request.getParameter("admin")));
		
		MemberDao mdao = MemberDao.getInstance();
		
		int result = mdao.updateMember(mdto);
		
		if(result==1) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mdto); //세션 로그인 정보를 수정된 내용으로 교체
		}
		
		RequestDispatcher dp = request.getRequestDispatcher("main.do");
		dp.forward(request, response);
	}

}
