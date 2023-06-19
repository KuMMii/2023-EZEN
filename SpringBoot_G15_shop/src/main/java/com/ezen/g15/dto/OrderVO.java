package com.ezen.g15.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class OrderVO {

	private int odseq;
	private int oseq;
	private int pseq;
	private int quantity;
	private int price2;
	private String id;
	private String mname;
	private String zip_num;
	private String address1;
	private String address2;
	private String address3;
	private String phone;
	private String pname;
	private String result;
	private Timestamp indate;
}
