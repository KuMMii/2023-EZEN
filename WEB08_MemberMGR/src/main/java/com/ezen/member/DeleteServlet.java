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
 * Servlet implementation class WithdrawServlet
 */
@WebServlet("/withdraw.do")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//세션에서 로그인 한 사람의 아이디를 추출하고 테이블에서 해당 레코드 삭제
		//dao의 메서드 이름은 deleteMember
		
		HttpSession session = request.getSession();
		MemberDto mdto= (MemberDto)session.getAttribute("loginUser");
		
		MemberDao mdao=MemberDao.getInstance();
		int result =mdao.deleteMember(mdto.getUserid());
		
		//삭제 성공하면 "회원 탈퇴가 완료되었습니다" 메서지를 가지고 로그인폼으로 돌아가기
		if(result==1) {
			session.invalidate();
			request.setAttribute("message", "회원 탈퇴가 완료되었습니다.");
		}
		RequestDispatcher dp = request.getRequestDispatcher("member/loginForm.jsp");
		dp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
