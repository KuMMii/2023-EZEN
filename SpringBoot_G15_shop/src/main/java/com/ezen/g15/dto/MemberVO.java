package com.ezen.g15.dto;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class MemberVO {

	@NotEmpty(message="id를 입력하세요")
	private String id;
	private String pwd;
	private String name;
	@NotEmpty(message="이메일을 입력하세요")
	private String email;
	private String zip_num;
	private String address1;
	private String address2;
	private String address3;
	private String phone;
	private String useyn;
	private String provider;
	private Timestamp indate;
}