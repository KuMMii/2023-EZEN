package com.ezen.board.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.board.controller.action.Action;
import com.ezen.board.dao.MemberDao;
import com.ezen.board.dto.MemberDto;


public class UpdateMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			session.setAttribute("loginUser", mdto); 
		}
		//update는 새로고침을 해서 원래 있는 정보를 불러오는 것이기 때문에 forward를 써도 아무 문제가 없음
		RequestDispatcher dp = request.getRequestDispatcher("board.do?command=main");
		dp.forward(request, response);
	}

}
