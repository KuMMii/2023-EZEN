package com.ezen.g14_Board.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.g14_Board.dto.BoardVO;
import com.ezen.g14_Board.dto.Paging;
import com.ezen.g14_Board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService bs;

	@RequestMapping("/main")
	public ModelAndView main(HttpServletRequest request) {
      ModelAndView mav = new ModelAndView();
      
      HttpSession session = request.getSession();
      if( session.getAttribute("loginUser") == null)   
         mav.setViewName("loginform");
      else {
    	  
    	  /*
    	  int page=1;
    	  if(request.getParameter("page")!=null) {
    		  page=Integer.parseInt(request.getParameter("page"));
    		  session.setAttribute("page", page);
    	  }else if(session.getAttribute("page")!=null) {
    		  page=(Integer)session.getAttribute("page");
    	  }else {
    		  session.removeAttribute("page");
    	  }
    	  Paging paging =new Paging();
    	  //request에 담겨 있는 page 파라미터를 service의 getBoardList() 메서드에 보내서 해당 게시물 리스트를 리턴
    	  // ... Paging 까지 controller에서 처리하기엔 내용이 복잡해짐
    	  */
    	  
         
    	  //page 파라미터를 품고 있는 request service에 보내서 페이지 처리 및 해당 게시물 조회 후 HashMap에 모두 담아 리턴받을 예정
         HashMap<String, Object> result = bs.getBoardList( request );
         
//         List<BoardVO>list=(List<BoardVO>)result.get("boardList");
//         Paging paging=(Paging) result.get("paging");
         
         mav.addObject("boardList", (List<BoardVO>)result.get("boardList") );
         mav.addObject("paging", (Paging)result.get("paging") );
         mav.setViewName("board/main");
         
      }
      return mav;
   }
}
