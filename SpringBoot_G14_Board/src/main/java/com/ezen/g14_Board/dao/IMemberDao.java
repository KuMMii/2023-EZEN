package com.ezen.g14_Board.dao;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.g14_Board.dto.MemberVO;

@Mapper
public interface IMemberDao {

	MemberVO getMember(String userid);

	void insertMember(MemberVO mvo);

	void updateMember(@Valid MemberVO membervo);


	
}
