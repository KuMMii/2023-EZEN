package com.ezen.g14_Board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.g14_Board.dto.BoardVO;
import com.ezen.g14_Board.dto.Paging;

@Mapper
public interface IBoardDao {

	int getAllCount();

	List<BoardVO> getBoardList(Paging paging);

	int getReplyCount(int num);


}