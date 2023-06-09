package com.ezen;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.battery.ChargeBattery;
import com.ezen.battery.NormalBattery;
import com.ezen.toy.ElectronicCar;
import com.ezen.toy.ElectronicRadio;

public class MainClass {

	public static void main(String[] args) {

		//일반적인 사용예
		//노멀 배터리가 장착된 상태로 판매되는 일체형. 객체생성 하나만으로 사용가능
		ElectronicCar carToy1=new ElectronicCar();

//		ElectronicRadio radioToy1=new ElectronicRadio(); //에러-디폴트 생성자가 없어서
		NormalBattery nbatt1=new NormalBattery();
		ChargeBattery cbatt1=new ChargeBattery();
		ElectronicRadio radioToy1=new ElectronicRadio(nbatt1);
		ElectronicRadio radioToy2=new ElectronicRadio(cbatt1);
		//생성자에 배터리 객체를 전달해주면 정상 생성, 이렇게 객체 생성시에 다른 객체의 존재 및 생성자로의 전달이 꼭 필수인 상태
		//객체 생성이 다른 객체에 의존하고 있는 상태. 이를 객체 의존이라고 부릅니다.
		//그리고 필요 객체를 생성자의 전달인수로 넣어주는 것을 의존주입(Dependency Injection) 이라고 부름
		
		GenericXmlApplicationContext ctx=new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		ElectronicCar carToy2=ctx.getBean("car",ElectronicCar.class);
		ElectronicRadio radioToy3=ctx.getBean("radio",ElectronicRadio.class);
		radioToy3.setBattery(nbatt1);
		
		ctx.close();
	}

}
