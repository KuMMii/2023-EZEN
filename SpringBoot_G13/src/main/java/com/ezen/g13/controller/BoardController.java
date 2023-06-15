package com.ezen.g13.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ezen.g13.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService bs;
	
}
