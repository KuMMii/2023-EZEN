package com.ezen.g14_Board.dao;

import java.util.List;

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



}