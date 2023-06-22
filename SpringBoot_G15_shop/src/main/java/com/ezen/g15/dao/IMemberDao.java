package com.ezen.g15.dao;

import javax.validation.Valid;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.g15.dto.MemberVO;

@Mapper
public interface IMemberDao {

	MemberVO getMember(String id);

	void joinKakao(MemberVO mvo);

	void insertMember(@Valid MemberVO membervo);

	void updateMember(@Valid MemberVO membervo);

	void withdrawalMember(String id);


	
}
