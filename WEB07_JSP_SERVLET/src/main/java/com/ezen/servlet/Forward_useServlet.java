package com.ezen.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Forward_useServlet
 */
@WebServlet("/Forward_useServlet")
public class Forward_useServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forward_useServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//method="get"으로 호출됐을 때 실행되는 멤버 메서드
				//매개변수가 jsp파일에서 보내준 request와 response를 받아서 사용
				
				//전달된 파라미터에 한글이 있다면, 또는 다시 내보내질 데이터에 한글이 있다고 인코딩방식을 설정함
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				
				//전달된 파라미터 변수에 저장
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				
				if(id.equals("hong")&&pwd.equals("1234")) {
					request.setAttribute("name", "홍길동");
					RequestDispatcher dp = request.getRequestDispatcher("02/092_Forward_UseServlet_ok.jsp");
					dp.forward(request, response);
				}else {
					response.sendRedirect("02/091_Forward_UseServlet.jsp");
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
