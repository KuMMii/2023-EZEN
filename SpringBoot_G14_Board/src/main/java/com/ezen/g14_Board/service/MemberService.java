package com.ezen.g14_Board.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.g14_Board.dao.IMemberDao;
import com.ezen.g14_Board.dto.MemberVO;

@Service
public class MemberService {

	@Autowired
	IMemberDao mdao;

	public MemberVO getMember(String userid) {
		//MemberVO mvo=mdao.getMember(userid);
		//return mvo
		return mdao.getMember(userid);
	}

	public void insertMember(MemberVO mvo) {
		mdao.insertMember(mvo);
		
	}

	public void updateMember(@Valid MemberVO membervo) {
		mdao.updateMember(membervo);
	}

	
}
