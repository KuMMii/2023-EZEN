package com.ezen.board.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;
import com.ezen.board.util.Paging;

public class MainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//게시물들을 조회해서 ArrayList에 담고, 그를 다시 request에 담아서 main.jsp로 포워딩
		BoardDao bdao = BoardDao.getInstance();
		
		int page=1;//처음 게시판을 열려고 할 때 ->page값은 1
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		//그렇게 결정된 현재페이지 번호를 Paging 객체를 만들고 멤버변수에 저장함
		Paging paging = new Paging();
		paging.setPage(page);
		
		//데이터베이스에 Access해서 총 레코드 개수를 리턴받음
		int count = bdao.getAllCount();
		//리턴받은 개수를 Paging 객체의 totalCount 변수에 저장함
		paging.setTotalCount(count); //paging()메서드가 같이 호출됨. ->각 멤버변수 값 계산
		
//		ArrayList<BoardDto> list = bdao.selectBoard(paging.getStartNum(),paging.getEndNum());
		ArrayList<BoardDto> list = bdao.selectBoard(paging);
		
		request.setAttribute("bList", list);
		request.setAttribute("paging", paging);

		
		RequestDispatcher rd= request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
		
		

	}

}
