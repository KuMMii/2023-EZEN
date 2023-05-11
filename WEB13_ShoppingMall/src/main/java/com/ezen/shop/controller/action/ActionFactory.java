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
import com.ezen.shop.controller.action.mypage.CartDeleteAction;
import com.ezen.shop.controller.action.mypage.CartInsertAction;
import com.ezen.shop.controller.action.mypage.CartListAction;
import com.ezen.shop.controller.action.mypage.OrderInsertAction;
import com.ezen.shop.controller.action.mypage.OrderInsertOneAction;
import com.ezen.shop.controller.action.mypage.OrderListAction;
import com.ezen.shop.controller.action.product.CategoryAction;
import com.ezen.shop.controller.action.product.ProductDetailAction;

public class ActionFactory {

	private ActionFactory() {}
	private static ActionFactory itc= new ActionFactory();
	public static ActionFactory getInstance() {return itc;}
	
	
	public Action getAction(String command) {
		Action ac =null;
		
		//member
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
		//product
		else if(command.equals("category")) ac=new CategoryAction();
		else if(command.equals("productDetail")) ac=new ProductDetailAction();
		//my page(cart)
		else if(command.equals("cartInsert")) ac=new CartInsertAction();
		else if(command.equals("cartList")) ac=new CartListAction();
		else if(command.equals("cartDelete")) ac=new CartDeleteAction();
		//my page(order)
		else if(command.equals("orderInsert")) ac=new OrderInsertAction();
		else if(command.equals("orderList")) ac=new OrderListAction();
		else if(command.equals("orderInsertOne")) ac=new OrderInsertOneAction();
//		else if(command.equals("mypage")) ac=new MyPageAction();
//		else if(command.equals("qnaList")) ac=new QnaListAction();
		
		return ac;
	}
}
