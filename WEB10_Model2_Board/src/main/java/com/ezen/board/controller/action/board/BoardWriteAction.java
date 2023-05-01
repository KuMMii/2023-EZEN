package com.ezen.board.controller.action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.board.controller.action.Action;
import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//전송된 항목들은 BoardDto에 담아서 BoardDao의 insertBoard메서드로 레코드를 추가하기
		BoardDao bdao=BoardDao.getInstance();
		BoardDto bdto= new BoardDto();
		
		bdto.setUserid(request.getParameter("userid"));
		bdto.setPass(request.getParameter("pass"));
		bdto.setTitle(request.getParameter("title"));
		bdto.setEmail(request.getParameter("email"));
		bdto.setContent(request.getParameter("content"));
		
		bdao.insertBoard(bdto);
		
		RequestDispatcher dp=request.getRequestDispatcher("board.do?command=main");
		dp.forward(request, response);

	}

}
