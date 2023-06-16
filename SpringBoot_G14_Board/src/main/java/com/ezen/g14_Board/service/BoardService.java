package com.ezen.g14_Board.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.g14_Board.dao.IBoardDao;
import com.ezen.g14_Board.dto.BoardVO;
import com.ezen.g14_Board.dto.Paging;
import com.ezen.g14_Board.dto.ReplyVO;

@Service
public class BoardService {

   @Autowired
   IBoardDao bdao;

public HashMap<String, Object> getBoardList(HttpServletRequest request) {
	HashMap<String, Object> result=new HashMap<String, Object>();
	HttpSession session = request.getSession();
	int page=1;
	if(request.getParameter("page")!=null) {
		  page=Integer.parseInt(request.getParameter("page"));
		  session.setAttribute("page", page);
	  }else if(session.getAttribute("page")!=null) {
		  page=(Integer)session.getAttribute("page");
	  }else {
		  session.removeAttribute("page");
	  }
	
	//paging 객체 작업
	Paging paging = new Paging();
	paging.setPage(page);
	int count=bdao.getAllCount();
	paging.setTotalCount(count);
	paging.paging(); //private에서 public으로 바뀐 paging메서드를 수동으로 호출
	
	//작업이 끝난 paging객체를 이용해서 해당 게시물 조회
	List<BoardVO> list=bdao.getBoardList(paging);
	
	//조회된 게시물의 댓글 개수 조회
	for(BoardVO bvo: list) {
		int cnt=bdao.getReplyCount(bvo.getNum()); //게시물의 댓글 개수 조회
		bvo.setReplycnt(cnt); //게시물의 댓글 개수를 dto에 저장
	}
	
	result.put("boardList",list);
	result.put("paging",paging);
	
	return result;
}

public HashMap<String, Object> boardView(int num) {
	HashMap<String, Object> result=new HashMap<String, Object>();
    //1. 조회수를 1증가 시킵니다
    bdao.plusOneReadCount(num, "board");  // 테이블 이름을 전달인수로 전송
    //2. 게시물을 조회합니다
    BoardVO bvo = bdao.getBoard(num);
    //3. 댓글을 조회합니다
    List<ReplyVO> list = bdao.selectReply( num );
    // 위 동작 중 필요한 결과들을 모두 result에 put 합니다
    result.put("board", bvo);
    result.put("replyList", list);

    return result;
}

public void insertBoard(BoardVO bvo) {

	bdao.insertBoard(bvo);
}
   
}