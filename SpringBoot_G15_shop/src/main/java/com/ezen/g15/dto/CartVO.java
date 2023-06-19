package com.ezen.g15.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CartVO {

	private Integer cseq;
	private Integer pseq;
	private Integer quantity;
	private Integer price2;
	private String id;
	private String mname;
	private String pname;
	private String result;
	private Timestamp indate;
}
