package com.ezen.g02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//Model2 MVC에서 프로젝트의 요청을 담당하는 서블릿과 기능별 구동을 담당하는 ActionFactory 역할을 하는 클래스.
//현재클래스가 그 역할을 하는 클래스라는 걸 알려주기 위해 아래와같은 어노테이션을 사용해 표시

@Controller
public class SpringBootController {

	//메서드 하나 하나가 ActionFactory와 같은 연결된 클래스의 execute열할을 함
	//따라서 각 메서드마다 요청메세지를 구분하는 어너테이션이 장착됨
	
	@RequestMapping("/")
	public @ResponseBody String root() {
		return "<h1>JSP in Gradle~!!</h1>";
	}
	
	@RequestMapping("/main")
	public String main() {
		return "main";
	}

	@RequestMapping("/sub")
	public String sub() {
		return "sub/sub";
	}
}
