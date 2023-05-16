package com.ezen.shop.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.shop.controller.action.Action;
import com.ezen.shop.dao.AdminDao;
import com.ezen.shop.dto.AdminVO;

public class AdminOrderSaveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url="shop.do?command=adminOrderList";
		HttpSession session=request.getSession();
		AdminVO avo=(AdminVO)session.getAttribute("loginAdmin");
		if(avo==null) {
			url="shop.do?command=admin";
		}else {
			
			if(request.getParameter("changeMenu")!=null) {
				session.removeAttribute("page");
				session.removeAttribute("key");
			}
			
			String [] odseqs=request.getParameterValues("result"); //주문처리할 주문의 odseq들
			AdminDao adao=AdminDao.getInstance();
			for(String odseq:odseqs) {
				adao.updateOrderResult(Integer.parseInt(odseq));
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
