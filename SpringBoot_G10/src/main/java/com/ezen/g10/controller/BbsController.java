package com.ezen.g10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.g10.dao.BbsDao;
import com.ezen.g10.dto.BbsDto;

@Controller
public class BbsController {

	@Autowired
	BbsDao bdao;
	
	@RequestMapping("/")
	public ModelAndView root() {
		ModelAndView mav= new ModelAndView();

//		List<BbsDto> list=bdao.getList();
//		mav.addObject("list",list);
		mav.addObject("list",bdao.getList());
		
		mav.setViewName("bbslist");
		
		return mav;
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	//@PostMapping("/write")
	public String write(BbsDto bbsdto) {
		int result=bdao.write(bbsdto);
		return "redirect:/";
	}
	
	@RequestMapping("view")
	public ModelAndView view( @RequestParam("id") int id, Model model) {
		ModelAndView mav=new ModelAndView();
//		BbsDto bdto=bdao.view(id);
//		model.addAttribute("dto",bdto);
		mav.addObject("dto",bdao.view(id));
		mav.setViewName("view");
		return mav;
	}
	
	@RequestMapping("/updateForm")
	public ModelAndView updateForm(@RequestParam("id") int id/*, Model model  ModelAndView를 쓰기때매 필요없음*/) {
		ModelAndView mav= new ModelAndView();
		mav.addObject("dto",bdao.view(id));
		mav.setViewName("updateForm");
		return mav;
	}
	
	@PostMapping("/update")
	public String update(BbsDto bbsdto) {
		bdao.update(bbsdto);
		//bdao.update(bbsdto.getWriter(),bbsdto.getTitle(),bbsdto.getContent(),bbsdto.getId());
		return "redirect:/";
	}
	
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		bdao.delete(id);
		return "redirect:/";
	}
	
	
	
	
	
}
