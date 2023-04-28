package com.ezen.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.member.controller.action.Action;
import com.ezen.member.controller.action.LoginFormAction;
import com.ezen.member.controller.action.LogoutAction;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member.do")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String command=request.getParameter("command");
		System.out.println(command);
		
		/*
		if(command.equals("loginForm")) {
			
			String url="member/loginForm.jsp";
			RequestDispatcher dp=request.getRequestDispatcher(url);
			dp.forward(request, response);
			
		}else if(command.equals("logout")) {
			
			HttpSession session = request.getSession();
			session.invalidate();
			RequestDispatcher dp = request.getRequestDispatcher("member/loginForm.jsp");
			dp.forward(request, response);
			
		}
		*/
		/*
		if(command.equals("loginForm")) {
			LoginFormAction lfa = new LoginFormAction();
			lfa.execute(request, response);
			
		}else if(command.equals("logout")) {
			LogoutAction loa =new LogoutAction();
			loa.execute(request, response);
		}*/
		
		Action ac=null;
		
//		if(command.equals("loginForm")) {
//			ac = new LoginFormAction();
//		}else if(command.equals("logout")) {
//			ac =new LogoutAction();
//		}
		
		ActionFactory af=ActionFactory.getInstance();
		ac = af.getAction(command);
		
		
		if(ac != null) ac.execute(request, response);
		else System.out.println("현재 command : "+command+" -command 값을 확인하세요");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
