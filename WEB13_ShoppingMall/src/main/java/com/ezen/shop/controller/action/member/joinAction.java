package com.ezen.shop.controller.action.member;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.shop.controller.action.Action;
import com.ezen.shop.dao.MemberDao;
import com.ezen.shop.dto.MemberVO;

public class joinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberDao mdao=MemberDao.getInstance();
		MemberVO mvo=new MemberVO();
		
		mvo.setId(request.getParameter("id"));
		mvo.setPwd(request.getParameter("pwd"));
		mvo.setName(request.getParameter("name"));
		mvo.setPhone(request.getParameter("phone"));
		mvo.setZip_num(request.getParameter("zip_num"));
		mvo.setAddress1(request.getParameter("address1"));
		mvo.setAddress2(request.getParameter("address2"));
		mvo.setEmail(request.getParameter("email"));
		
		int result=mdao.insertMember(mvo);
		String message="";
		
		if( result==1) message="회원가입 완~!";
		else message="회원가입 실패ㅠ 다시 시도해보고 안되면 관리자한테 문의하세요.";
		
		response.sendRedirect("shop.do?command=loginForm&message="+URLEncoder.encode(message,"UTF-8"));
	}

}
