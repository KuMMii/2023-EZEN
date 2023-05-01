package com.ezen.board.controller.action.member;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.board.controller.action.Action;
import com.ezen.board.dao.MemberDao;
import com.ezen.board.dto.MemberDto;


public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberDto mdto=new MemberDto();
		
		mdto.setName(request.getParameter("name"));
		mdto.setUserid(request.getParameter("userid"));
		mdto.setPwd(request.getParameter("pwd"));
		mdto.setEmail(request.getParameter("email"));
		mdto.setPhone(request.getParameter("phone"));
		mdto.setAdmin(Integer.parseInt(request.getParameter("admin")));
		
		MemberDao mdao=MemberDao.getInstance();
		int result = mdao.insertMember(mdto);
		
		String message="";
		if(result==1)message="회원가입이 완료되었습니다. 로그인하세요.";
		else message="회원가입에 실패하셨습니다. 관리자에게 문의하세요.";
		
		//forward 메서드로 이동한 최종 도착 페이지에서는 새로 고침을 하면 데이터도 한번 더 추가되려고 시도함.
		//새로고침에 의해 포워딩 이전 코드가 다시 실행되지 않으려면 sendRedirect를 이용함
		//레코드가 추가될때만 sendRedirect를 쓰면 됨
		//forward를 사용하고 새고를 하면 같은 아이디로 중복해서 추가가 되어 에러가 남
		//request를 사용하면 안됨-그 다음 페이지까지 정보 전달이 안된다고 함
		response.sendRedirect("board.do?command=loginForm&message="+URLEncoder.encode(message,"UTF-8"));
	}

}
