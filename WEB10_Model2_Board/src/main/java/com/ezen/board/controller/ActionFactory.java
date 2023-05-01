package com.ezen.board.controller;

import com.ezen.board.controller.action.Action;
import com.ezen.board.controller.action.MainAction;
import com.ezen.board.controller.action.board.BoardViewAction;
import com.ezen.board.controller.action.board.BoardWriteAction;
import com.ezen.board.controller.action.board.BoardWriteFormAction;
import com.ezen.board.controller.action.member.IdCheckAction;
import com.ezen.board.controller.action.member.JoinAction;
import com.ezen.board.controller.action.member.JoinFormAction;
import com.ezen.board.controller.action.member.LoginAction;
import com.ezen.board.controller.action.member.LoginFormAction;
import com.ezen.board.controller.action.member.LogoutAction;
import com.ezen.board.controller.action.member.UpdateMemberAction;
import com.ezen.board.controller.action.member.UpdateMemberFormAction;

public class ActionFactory {
	
	private ActionFactory() {}
	private static ActionFactory itc=new ActionFactory();
	public static ActionFactory getInstance() {return itc;}
	public Action getAction(String command) {
		Action ac=null;
		
		if(command.equals("loginForm")) {ac=new LoginFormAction();}
		else if(command.equals("login")) {ac=new LoginAction();}
		else if(command.equals("main")) {ac=new MainAction();}
		else if(command.equals("logout")) {ac=new LogoutAction();}
		else if(command.equals("joinForm")) {ac=new JoinFormAction();}
		else if(command.equals("idcheck")) {ac=new IdCheckAction();}
		else if(command.equals("join")) {ac=new JoinAction();}
		else if(command.equals("updateMemberForm")) {ac=new UpdateMemberFormAction();}
		else if(command.equals("updateMember")) {ac=new UpdateMemberAction();}
		else if(command.equals("boardWriteForm")) {ac=new BoardWriteFormAction();}
		else if(command.equals("boardWrite")) {ac=new BoardWriteAction();}
		else if(command.equals("boardView")) {ac=new BoardViewAction();}
		
		return ac;
	}
}
