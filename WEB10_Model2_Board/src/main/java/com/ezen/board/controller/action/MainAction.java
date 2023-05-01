package com.ezen.board.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;

public class MainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//게시물들을 조회해서 ArrayList에 담고, 그를 다시 request에 담아서 main.jsp로 포워딩
		BoardDao bdao = BoardDao.getInstance();
		
		ArrayList<BoardDto> list = bdao.selectBoard();
		
		request.setAttribute("bList", list);
		
		RequestDispatcher rd= request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
		
		

	}

}
