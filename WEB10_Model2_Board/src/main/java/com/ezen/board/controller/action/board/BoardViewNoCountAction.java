package com.ezen.board.controller.action.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.board.controller.action.Action;
import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;
import com.ezen.board.dto.ReplyDto;

public class BoardViewNoCountAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		BoardDao bdao = BoardDao.getInstance();
		
		ArrayList<ReplyDto> list=bdao.selectReply(num);
		request.setAttribute("replyList", list);
		
		BoardDto bdto=bdao.getBoard(num);
		request.setAttribute("board", bdto);
		RequestDispatcher rd=request.getRequestDispatcher("board/boardView.jsp");
		rd.forward(request, response);


	}

}
