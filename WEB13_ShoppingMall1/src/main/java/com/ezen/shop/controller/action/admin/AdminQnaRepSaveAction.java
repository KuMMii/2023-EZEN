package com.ezen.shop.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.shop.controller.action.Action;
import com.ezen.shop.dao.QnaDao;
import com.ezen.shop.dto.AdminVO;
import com.ezen.shop.dto.QnaVO;

public class AdminQnaRepSaveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="shop.do?command=adminQnaDetail";
		HttpSession session=request.getSession();
		AdminVO avo=(AdminVO)session.getAttribute("loginAdmin");
		if(avo==null) {
			url="shop.do?command=admin";
		}else {
		
			if(request.getParameter("changeMenu")!=null) {
				session.removeAttribute("page");
				session.removeAttribute("key");
			}
			
		int qseq=Integer.parseInt(request.getParameter("qseq"));
		
		String reply=request.getParameter("reply");
		QnaDao qdao=QnaDao.getInstance();
		QnaVO qvo=new QnaVO();
		qvo.setQseq(Integer.parseInt(request.getParameter("qseq")));
		qvo.setReply(request.getParameter("reply"));
		qdao.updateQna(qvo);
		url=url+"&qseq="+qvo.getQseq();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
