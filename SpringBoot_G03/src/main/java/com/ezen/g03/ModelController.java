package com.ezen.g03;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelController {

	
	@RequestMapping("/") // 요청주소가 http://localhost:8070/ 일 때 실행되는 메서드
	public @ResponseBody String root() {
		return "<h1>Model & View</h1>"; //화면에 보여질 내용이 String으로 리턴됨
	}
	
	@RequestMapping("/test1") // 요청주소가 http://localhost:8070/test1 일 때 실행되는 메서드
	public String test1( HttpServletRequest request, Model model) {
		// RequestMapping Method의 매개변수로 HttpServletRequest를 지정하면, Spring 전달해준 request 사용이 가능
		request.setAttribute("name1","홍길동");
		
		//리턴되는 jsp파일까지만 해당 내용을 전달 할 수 있는 1회용 자료 전달 도구
		model.addAttribute("name2","김하나");
		
		 
		return "test1"; //화면에 표시될 jsp 파일 이름이 리턴됨
		//return 동작이나 이전의 별도의 request 전송 명령이 없어도 jsp 파일에 request가 전달됨
	}

	
	@RequestMapping("/test2") 
	public String test2( HttpServletRequest request, Model model) {
		request.setAttribute("name1","홍길동");
		model.addAttribute("name2","김하나");
		
		name4="홍길동";
		name5="김하나";
		
		//jsp가 아닌 다른 request 요청으로 이동해야 할 때 아래와 같이 리턴
		return "redirect:/test3"; 
	}
	
	String name4;
	String name5;
	
	@RequestMapping("/test3") 
	public String test3( HttpServletRequest request, Model model) {

//		String name1=(String)request.getAttribute("name1");
//		String name2=(String)model.getAttribute("name2");
//		
//		request.setAttribute("name1", name1);
//		model.addAttribute("name2", name2);
//		System.out.println(name1+""+name2);
// 		이렇게 하면 안됨
		
		/*
		 * 새로운 객체가 매개변수로 지정되어 전달되어지는 RequestMapping 메서드에서는 이전 메서드에서 저장해왔던
		 *  model과 request가 적용되지 않음.
		 * test2메서드에서 보내려고 했던 model과 request는 전달인수로 보낸게 아니기도 하고
		 * test3 메서드의 매개변수는 새로운 request와 model이 채워지기 때문
		 * request와 model의 내용을 꺼내쓰는 건 return되는 jsp 파일내부만 가능함
		 */
		
		request.setAttribute("name1", name4);
		model.addAttribute("name2", name5);
		
		
		
		return "test3"; 
	}
	
	
	@RequestMapping("/test4")
	public ModelAndView test4() {
		
		ModelAndView mav = new ModelAndView();
		//ModelAndView : 전달자료도 저장하고, 이동할 페이지도 지정해서 한번 리턴 전달을 가능하게 하는 클래스임.
		ArrayList<String> list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		list.add("test3");
		
		// 전송할 자료 저장( 키(String), 밸류(Object) )
		mav.addObject("lists",list);
		mav.addObject("ObjectTest","testing");
		mav.addObject("name","홍길동");
		
		//이동할 jsp 페이지 지정
		mav.setViewName("myView");
		
		
		return mav;
	}
	
	
	
	
	
	
}
