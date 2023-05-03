package com.ezen.upload.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.upload.dao.ProductDao;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao pdao=ProductDao.getInstance();
		
		int code=Integer.parseInt(request.getParameter("code"));
		
		pdao.deleteProduct(code);
		
		RequestDispatcher rd = request.getRequestDispatcher("product.do?command=index");
		rd.forward(request, response);

	}

}
