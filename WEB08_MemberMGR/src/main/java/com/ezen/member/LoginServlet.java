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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//get으로 호출되었을 때 실행되는 곳
		
		String url = "member/loginForm.jsp";
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")!=null) {
			url="main.jsp";
		}
		
		RequestDispatcher rd= request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		//전달된 아이디 비번 변수에 저장
		String userid=request.getParameter("userid");
		String pwd=request.getParameter("pwd");
		
		//전달된 userid로 member 테이블에서 회원정보를 조회해서 리턴받고, 검색결과에 따라 pwd도 비교해서 정상로그인 여부를 결정함
		
		
		//로그인이 실패했을 때를 대비해서 포워딩 할 경로를 먼저 설정함
		String url="member/loginForm.jsp";
		
		//전달된 userid를 전달인수로 하는 getMember()메서드를 호출해서 해당 회원의 정보를 dto에 담아서 리턴받기
		MemberDao mdao = MemberDao.getInstance();
		MemberDto mdto = mdao.getMember(userid);
		
		//getMember에 의해 리턴된 결과에 따라 로그인의 결과도 결정되어 해당 페이지로 이동함
		if(mdto==null) {
			request.setAttribute("message", "아이디가 없습니다.");
		}else if(mdto.getPwd()==null) {
			request.setAttribute("message", "DB오류. 관리자에게 문의하세요.");
		}else if(!mdto.getPwd().equals(pwd)) {
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		}else if(mdto.getPwd().equals(pwd)) {
			//여기만 정상로그인
			url="member/main.jsp";
			//로그인한 사람의 정보(mdto)를 session에 저장함
			//session은 각 페이지에 있는 request 객체에서 얻어 쓸 수 있는데, jsp페이지에서는 그 페이지가  갖고 있는
			//request 안의 session을 별도 작업없이 그냥 사용해도 되지만, 서블릿에서는 request를 전달인수로 받아서
			//매개변수에 저장된 형태로 쓰기 때문에 별도로 추출하는 동작이 필요함.
			HttpSession session = request.getSession();
			session.setAttribute("loginUser",mdto);
		}else {
			//무슨이유에서인지 모르겠지만 로그인이 안되는 경우
			request.setAttribute("message", "로그인이 안되는데 이유를 모르겠네용. 관리자에게 문의하세요.");
		}
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
		
	}

}














