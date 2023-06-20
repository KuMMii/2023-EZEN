package com.ezen.g15.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezen.g15.dto.KakaoProfile;
import com.ezen.g15.dto.KakaoProfile.KakaoAccount;
import com.ezen.g15.dto.KakaoProfile.KakaoAccount.Profile;
import com.ezen.g15.dto.MemberVO;
import com.ezen.g15.dto.OAuthToken;
import com.ezen.g15.service.MemberService;
import com.google.gson.Gson;

@Controller
public class MemberController {

	@Autowired
	MemberService ms;
	
	@RequestMapping("loginForm")
	public String login_form() {
		return "member/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("dto") @Valid MemberVO membervo, BindingResult result,
						Model model,HttpServletRequest request) {
		String url="member/login";
		if(result.getFieldError("id")!=null) {
			model.addAttribute("message",result.getFieldError("id").getDefaultMessage());
		}else if(result.getFieldError("pwd")!=null) {
				model.addAttribute("message",result.getFieldError("pwd").getDefaultMessage());
		}else {
			
			MemberVO mvo=ms.getMember(membervo.getId());
			if(mvo==null)model.addAttribute("message","ID가 없습니다.");
			else if(mvo.getPwd()==null)model.addAttribute("message","관리자에게 문의하세요");
			else if(!mvo.getPwd().equals(membervo.getPwd()))model.addAttribute("message","암호가 잘못됨");
			else if(mvo.getPwd().equals(membervo.getPwd())) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", mvo);
				url="redirect:/";
			}
			
		}
		return url;
	}
	
	@RequestMapping("/logout")
	public String logout(Model model, HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.removeAttribute("loginUser");
		return "redirect:/";
	}
	
	
	@RequestMapping("/kakaostart")
	public @ResponseBody String kakaostart() {
		String a ="<script type='text/javascript'>"
				+ "location.href='https://kauth.kakao.com/oauth/authorize?"
				+ "client_id=214e228626960e62a8c51ee05f48edc6&"
				+ "redirect_uri=http://localhost:8070/kakaoLogin&"
				+ "response_type=code'"
				+"</script>";
		return a;
	}
	
	@RequestMapping("/kakaoLogin")
	public String loginKakao(HttpServletRequest request) throws UnsupportedEncodingException, IOException {
		
		//카카오 아이디, 비번인증 + 아이디 이메일 제공 동의 후 전송되는 암호화 코드
		String code=request.getParameter("code");
		
		//전송된 암호화코드를 이용해서 토큰을 요청
		//주소 url 설정
		String endpoint="https://kauth.kakao.com/oauth/token";
		URL url=new URL(endpoint); //import java.net.URL;
		
		//파라미터 설정
		String bodyData="grant_type=authorization_code&";
		bodyData +="client_id=214e228626960e62a8c51ee05f48edc6&";
		bodyData +="redirect_uri=http://localhost:8070/kakaoLogin&";
		bodyData +="code="+code;
		
		//Stream 연결
		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		conn.setDoOutput(true);
		
		//token 수신
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(),"UTF-8"));
		bw.write(bodyData);
		bw.flush();
		BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		String input="";
		StringBuilder sb=new StringBuilder();
		while((input=br.readLine())!=null) {
			sb.append(input);
			System.out.println(input);
		}
		
		/*
		sb:{"access_token":"OZa7pPT6wNkgYlAd359c0qjU6X7-dvKsHVvW1-YsCj11WgAAAYjB_tsF",
		"token_type":"bearer",
		"refresh_token":"eF3HL-tE7xj6k-qxB9i-vghTDh7Y8E2d7UJKCYHKCj11WgAAAYjB_tsE",
		"expires_in":21599,
		"scope":"account_email profile_nickname",
		"refresh_token_expires_in":5183999}
		*/
		
		//위 토큰 내용을 본따 만든 클래스에 gson파싱으로 옮겨 담음(sb->OAuthToken)
		Gson gson=new Gson();
		OAuthToken oAuthToken=gson.fromJson(sb.toString(), OAuthToken.class);
		
		//토큰을 이용해서 사용자 정보를 수신 요청
		String endpoint2="https://kapi.kakao.com/v2/user/me";
		URL url2=new URL(endpoint2);
		//import java.net.HttpURLConnection;
		HttpURLConnection conn2=(HttpsURLConnection)url2.openConnection();
		//header값 넣기
		conn2.setRequestProperty("Authorization","Bearer "+oAuthToken.getAccess_token());
		conn2.setDoOutput(true);
		//UserInfo 수신
		BufferedReader br2=new BufferedReader(new InputStreamReader(conn2.getInputStream(),"UTF-8"));
		String input2="";
		StringBuilder sb2=new StringBuilder();
		while((input2=br2.readLine())!=null) {
			sb2.append(input2);
			System.out.println(input2);
		}
		/*
		sb2: {"id":2845472685,
		"connected_at":"2023-06-16T01:52:57Z",
		"properties":{"nickname":"김지은"},
		"kakao_account":{
							"profile_nickname_needs_agreement":false,
							"profile":{"nickname":"김지은"},
							"has_email":true,
							"email_needs_agreement":false,
							"is_email_valid":true,
							"is_email_verified":true,
							"email":"jieun9912@naver.com"
						}
			  }
		*/
		
		//전달받은 회원정보를 kakaoProfile객체에 담음(sb2->kakaoProfile)
		Gson gson2=new Gson();
		KakaoProfile kakaoProfile=gson2.fromJson(sb2.toString(), KakaoProfile.class);
		
		System.out.println(kakaoProfile.getId());
		KakaoAccount ac=kakaoProfile.getAccount();
		System.out.println(ac.getEmail());
		Profile pf=ac.getProfile();
		System.out.println(pf.getNickname());
		
		MemberVO mvo=ms.getMember(kakaoProfile.getId());
		if(mvo==null) {
			mvo=new MemberVO();
			mvo.setId(kakaoProfile.getId());
			mvo.setEmail(ac.getEmail());
			mvo.setName(pf.getNickname());
			mvo.setProvider("kakao");
			ms.joinKakao(mvo);
		}
		HttpSession session=request.getSession();
		session.setAttribute("loginUser", mvo);
		
		return "redirect:/";
	}
	
	
	@RequestMapping("contract")
	public String contract(Model model,HttpServletRequest request) {
		return "member/contract";
	}
	
	@RequestMapping("/joinForm")
	public String join_form() {
		return "member/joinForm";
	}
	
	@RequestMapping("idCheckForm")
	public String id_check_form(@RequestParam("id") String id, Model model) {
		MemberVO mvo=ms.getMember(id);
		int result=0;
		if(mvo==null)result=-1;
		else result=1;
		model.addAttribute("result",result);
		model.addAttribute("id",id);
		return "member/idcheck";
	}
	
	
	@RequestMapping(value="join",method=RequestMethod.POST)
	public String join(@ModelAttribute("dto") @Valid MemberVO membervo, BindingResult result,
						Model model, HttpServletRequest request, @RequestParam("reid") String reid, 
						@RequestParam("pwdCheck")String pwdCheck) {
		
		model.addAttribute("reid",reid);
		String url="member/joinForm";
		
		if(result.getFieldError("id")!=null) {
			model.addAttribute("message",result.getFieldError("id").getDefaultMessage());
		}else if(result.getFieldError("pwd")!=null) {
			model.addAttribute("message",result.getFieldError("pwd").getDefaultMessage());
		}else if(result.getFieldError("name")!=null) {
			model.addAttribute("message",result.getFieldError("name").getDefaultMessage());
		}else if(result.getFieldError("email")!=null) {
			model.addAttribute("message",result.getFieldError("email").getDefaultMessage());
		}else if(!reid.equals(membervo.getId())) {
			model.addAttribute("message","id 중복체크를 하지 않았습니다");
		}else if(!pwdCheck.equals(membervo.getPwd())) {
			model.addAttribute("message","비밀번호 확인이 일치하지 않습니다");
		}else {
			model.addAttribute("message","회원가입이 완료되었습니다. 로그인하세요");
			ms.insertMember(membervo);
			url="member/login";
		}
		return url;
		
	}
	
	@RequestMapping("/memberEditForm")
	public String member_Edit_Form(Model model, HttpServletRequest request) {
		
		HttpSession session=request.getSession();
		MemberVO mvo=(MemberVO)session.getAttribute("loginUser");
		model.addAttribute("dto",mvo);
		
		return "member/memberUpdateForm";
	}
	
	@RequestMapping(value="memberUpdate", method=RequestMethod.POST)
	public String memberUpdate(@ModelAttribute("dto") @Valid MemberVO membervo,
								BindingResult result, Model model, HttpServletRequest request,
								@RequestParam(value="pwdCheck", required=false)String pwdCheck) {
		String url="member/memberUpdateForm";
		if(membervo.getProvider().equals("")) {
			if(result.getFieldError("pwd")!=null) {
				request.setAttribute("message", "비밀번호를 입력하세요");
			}else if(!pwdCheck.equals(membervo.getPwd())) {
				request.setAttribute("message", "비밀번호 확인이 일치하지 않습니다.");
			}else if(result.getFieldError("name")!=null) {
					request.setAttribute("message", result.getFieldError("name").getDefaultMessage());
			}else {
				ms.updateMember(membervo);
				HttpSession session=request.getSession();
				session.setAttribute("loginUser", membervo);
				url="redirect:/";
			}
			
		}else {
			if(result.getFieldError("name")!=null) {
				request.setAttribute("message", result.getFieldError("name").getDefaultMessage());
			
			}else {
				ms.updateMember(membervo);
				HttpSession session=request.getSession();
				session.setAttribute("loginUser", membervo);
				url="redirect:/";
			}
		}	
		return url;
	}
	
	
	
	
	
	
	
	
}
