package com.ezen.g14_Board.dao;

import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.g14_Board.dto.BoardVO;
import com.ezen.g14_Board.dto.Paging;
import com.ezen.g14_Board.dto.ReplyVO;

@Mapper
public interface IBoardDao {

	int getAllCount();

	List<BoardVO> getBoardList(Paging paging);

	int getReplyCount(int num);

	void plusOneReadCount(int num, String string);

	BoardVO getBoard(int num);

	List<ReplyVO> selectReply(int num);

	void insertBoard(BoardVO bvo);

	void insertReply(ReplyVO replyvo);

	void deleteReply(int num);

	void updateBoard(@Valid BoardVO boardvo);

	void deleteBoard(int num);




}