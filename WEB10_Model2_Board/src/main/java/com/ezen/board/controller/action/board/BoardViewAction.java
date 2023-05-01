package com.ezen.board.controller.action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.board.controller.action.Action;
import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		전달받은 게시물 번호로 게시물을 조회해서 boardDto에 리턴받고, 이를 다시 request에 저장해서 boardView.jsp로 포워딩하기
		
		int num = Integer.parseInt(request.getParameter("num"));
		BoardDao bdao = BoardDao.getInstance();
		BoardDto bdto=bdao.getBoard(num);
		
		request.setAttribute("board", bdto);
		RequestDispatcher rd=request.getRequestDispatcher("board/boardView.jsp");
		rd.forward(request, response);

	}

}
