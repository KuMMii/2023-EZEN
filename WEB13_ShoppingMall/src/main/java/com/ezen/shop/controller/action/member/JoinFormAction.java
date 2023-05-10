package com.ezen.shop.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.shop.controller.action.Action;

public class JoinFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd=request.getRequestDispatcher("member/join.jsp");
		rd.forward(request, response);
	}

}
