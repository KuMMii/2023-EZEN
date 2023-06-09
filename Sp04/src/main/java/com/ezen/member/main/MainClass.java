package com.ezen.member.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.member.dao.StudentDao;
import com.ezen.member.dto.Student;

public class MainClass {

	public static void main(String[] args) {
		//기존 방식의 레코드 추가
		//StudentDao sdao=new StudentDao();
		//Student std=new Student();
		//sdao.insertStudent(std);
		
		//스프링 컨테이너를 이용한 방법
		GenericXmlApplicationContext ctx=new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		Student std=new Student("H39asdfaelu42o23","hippo","94875","barabra",22,"W","Korean Literature");
		//생성자에 전달인수 전달해 객체 생성
		
		StudentDao sdao=ctx.getBean("studentdao",StudentDao.class);
		sdao.insertStudent(std);
	}
}
