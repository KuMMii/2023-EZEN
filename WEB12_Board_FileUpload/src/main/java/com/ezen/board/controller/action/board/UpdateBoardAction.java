package com.ezen.board.controller.action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.board.controller.action.Action;
import com.ezen.board.dao.BoardDao;
import com.ezen.board.dto.BoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class UpdateBoardAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전송된 내용을 Dto에 담고 수정을 완성해주기
		BoardDao bdao=BoardDao.getInstance();
		BoardDto bdto=new BoardDto();
		
//		bdto.setUserid(request.getParameter("userid"));
//		bdto.setPass(request.getParameter("pass"));
//		bdto.setEmail(request.getParameter("email"));
//		bdto.setTitle(request.getParameter("title"));
//		bdto.setContent(request.getParameter("content"));
//		bdto.setNum(Integer.parseInt(request.getParameter("num")));
		
		//MultipartRequest를 생성해서 게시물 수정하기
		
		HttpSession session= request.getSession();
		ServletContext context = session.getServletContext();
		
		String path= context.getRealPath("upload");
		
		MultipartRequest multi=new MultipartRequest(
				request, path, 20*1024*1024, "UTF-8", new DefaultFileRenamePolicy()
				);
		
		bdto.setUserid(multi.getParameter("userid"));
		bdto.setPass(multi.getParameter("pass"));
		bdto.setEmail(multi.getParameter("email"));
		bdto.setTitle(multi.getParameter("title"));
		bdto.setContent(multi.getParameter("content"));
		bdto.setNum(Integer.parseInt(multi.getParameter("num")));
		bdto.setImgfilename(multi.getFilesystemName("uploadFile"));
		
		if(multi.getFilesystemName("newFile")==null) bdto.setImgfilename(multi.getParameter("oldFile"));
		else bdto.setImgfilename(multi.getFilesystemName("newFile"));
		
		bdao.updateBoard(bdto);
		
		String url="board.do?command=boardViewNoCount&num="+bdto.getNum();
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);

	}

}
