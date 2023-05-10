package com.ezen.shop.controller.action;

import com.ezen.shop.controller.action.member.ContractAction;
import com.ezen.shop.controller.action.member.EditFormAction;
import com.ezen.shop.controller.action.member.FindZipNumAction;
import com.ezen.shop.controller.action.member.IdCheckFormAction;
import com.ezen.shop.controller.action.member.JoinFormAction;
import com.ezen.shop.controller.action.member.LoginAction;
import com.ezen.shop.controller.action.member.LoginFormAction;
import com.ezen.shop.controller.action.member.LogoutAction;
import com.ezen.shop.controller.action.member.MemberUpdateAction;
import com.ezen.shop.controller.action.member.joinAction;

public class ActionFactory {

	private ActionFactory() {}
	private static ActionFactory itc= new ActionFactory();
	public static ActionFactory getInstance() {return itc;}
	
	
	public Action getAction(String command) {
		Action ac =null;
		
		if(command.equals("index")) ac=new IndexAction();
		else if(command.equals("loginForm")) ac=new LoginFormAction();
		else if(command.equals("login")) ac=new LoginAction();
		else if(command.equals("loginout")) ac=new LogoutAction();
		else if(command.equals("contract")) ac=new ContractAction();
		else if(command.equals("joinForm")) ac=new JoinFormAction();
		else if(command.equals("idCheckForm")) ac=new IdCheckFormAction();
		else if(command.equals("findZipNum")) ac=new FindZipNumAction();
		else if(command.equals("join")) ac=new joinAction();
		else if(command.equals("editForm")) ac=new EditFormAction();
		else if(command.equals("memberUpdate")) ac=new MemberUpdateAction();
//		else if(command.equals("cartList")) ac=new CartListAction();
//		else if(command.equals("mypage")) ac=new MyPageAction();
//		else if(command.equals("qnaList")) ac=new QnaListAction();
		
		return ac;
	}
}
