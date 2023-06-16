package com.ezen.g14_Board.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ezen.g14_Board.dto.KakaoProfile;
import com.ezen.g14_Board.dto.KakaoProfile.KakaoAccount;
import com.ezen.g14_Board.dto.KakaoProfile.KakaoAccount.Profile;
import com.ezen.g14_Board.dto.MemberVO;
import com.ezen.g14_Board.dto.OAuthToken;
import com.ezen.g14_Board.service.MemberService;
import com.google.gson.Gson;

@Controller
public class MemberController {

	@Autowired
	MemberService ms;
	
	@RequestMapping("/")
	public String root() {
		return "member/loginForm";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("dto") @Valid MemberVO membervo, 
								BindingResult result, HttpServletRequest request, Model model) {
		
		String url="member/loginForm";
		
		if(result.getFieldError("userid")!=null) {
			model.addAttribute("message",result.getFieldError("userid").getDefaultMessage());
		}else if(result.getFieldError("pwd")!=null) {
			model.addAttribute("message",result.getFieldError("pwd").getDefaultMessage());
			
		}else {
			//아이디비번이 정상 입력된 경우
			MemberVO mvo = ms.getMember(membervo.getUserid());
			if(mvo==null) model.addAttribute("message","아이디가 없습니다");
			else if(mvo.getPwd()==null) model.addAttribute("message", "DB오류. 관리자에게 문의하세요");
			else if(!mvo.getPwd().equals(membervo.getPwd())) model.addAttribute("message", "비밀번호 틀림");
			else if(mvo.getPwd().equals(membervo.getPwd())) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", mvo);
				url="redirect:/main";
			}
		}
		
		return url;
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/kakaoLogin")
	public String login(HttpServletRequest request) throws UnsupportedEncodingException,IOException {
		
		String code=request.getParameter("code");
		
		//User info를 요청할 url과 전달인수 설정
		String endpoint="https://kauth.kakao.com/oauth/token";
		URL url=new URL(endpoint); //import java.net.URL;
		
		String bodyData="grant_type=authorization_code&";
		bodyData+="client_id=214e228626960e62a8c51ee05f48edc6&";
		bodyData+="redirect_uri=http://localhost:8070/kakaoLogin&";
		bodyData+="code="+code;
		
		//Stream 연결
		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		//http header 값 넣기
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		conn.setDoOutput(true);
		
		
		//인증절차를 완료한 실제 User Info 요청을 위한 정보를 요청 및 수신
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(),"UTF-8"));
		bw.write(bodyData);
		bw.flush();
		BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		
		String input="";
		StringBuilder sb=new StringBuilder(); //조각난 String을 조립하기 위한 객체
		while((input=br.readLine())!=null) {
			sb.append(input);
			System.out.println(input);
		}
		//sb:{"access_token":"OZa7pPT6wNkgYlAd359c0qjU6X7-dvKsHVvW1-YsCj11WgAAAYjB_tsF","token_type":"bearer","refresh_token":"eF3HL-tE7xj6k-qxB9i-vghTDh7Y8E2d7UJKCYHKCj11WgAAAYjB_tsE","expires_in":21599,"scope":"account_email profile_nickname","refresh_token_expires_in":5183999}

		
		
		//여기서부터 Gson으로 파싱
		Gson gson=new Gson();
		
		OAuthToken oAuthToken=gson.fromJson(sb.toString(), OAuthToken.class);
		//oAuthToken<-sb
		
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
		
		//sb2에 도착한 실제 사용자정보를 사용
		//sb2:
		
		Gson gson2=new Gson();
		KakaoProfile kakaoProfile=gson2.fromJson(sb2.toString(), KakaoProfile.class);
		//kakaoProfile <--{"id":2845472685,"connected_at":"2023-06-16T01:52:57Z","properties":{"nickname":"김지은"},"kakao_account":{"profile_nickname_needs_agreement":false,"profile":{"nickname":"김지은"},"has_email":true,"email_needs_agreement":false,"is_email_valid":true,"is_email_verified":true,"email":"jieun9912@naver.com"}}

		
		System.out.println(kakaoProfile.getId());
		
		KakaoAccount ac=kakaoProfile.getAccount();
		System.out.println(ac.getEmail());
		
		Profile pf=ac.getProfile();
		System.out.println(pf.getNickname());
		
		//kakao로부터 얻은 정보로 member 테이블에서 조회함(이미 가입한 사람인지 아닌지 보려고)
		MemberVO mvo=ms.getMember(kakaoProfile.getId());
		if(mvo==null) {
			mvo=new MemberVO();
			mvo.setUserid(kakaoProfile.getId());
			mvo.setEmail(ac.getEmail());
			mvo.setName(pf.getNickname());
			mvo.setProvider("kakao");
			mvo.setPwd("kakao"); //필드를 not null로 했을 경우 kakao로그인이니까 비번필요없다는의미로 넣어줌
			mvo.setPhone("");
			
			ms.insertMember(mvo);
		}
		HttpSession session=request.getSession();
		session.setAttribute("loginUser", mvo);
		
		return "redirect:/main";
	}
	
	
	@RequestMapping("/kakaostart")
	public @ResponseBody String kakaostart() {
		String a="<script type='text/javascript'>"
				+ "location.href='https://kauth.kakao.com/oauth/authorize?client_id=214e228626960e62a8c51ee05f48edc6&redirect_uri=http://localhost:8070/kakaoLogin&response_type=code'"
				+"</script>";
		return a;
	}
	
	
	@RequestMapping("/memberJoinForm")
	public String memberJoinForm() {
		return "member/memberJoinForm";
	}
	
	@RequestMapping("/idcheck")
	public ModelAndView idcheck(@RequestParam("userid")String userid) {
		ModelAndView mav= new ModelAndView();
		MemberVO mvo=ms.getMember(userid);
		if(mvo==null) mav.addObject("result", -1);
		else mav.addObject("result",1);
		mav.addObject("userid",userid);
		mav.setViewName("member/idcheck");
		
		return mav;
	}
	
	
	@PostMapping("/memberJoin")
	public ModelAndView memberJoin(
								@ModelAttribute("dto") @Valid MemberVO membervo, BindingResult result,
								@RequestParam(value="re_id", required=false/*null이어도 괜찮다는 표시*/) String re_id, 
								@RequestParam(value="pwd_check", required=false) String pwd_check
			) {
		
		ModelAndView mav=new ModelAndView();
		  // 밸리데이션으로 전송된 값들을 점검하고, 널이나 빈칸이 있으면  memberJoinForm.jsp로 되돌아 가도록 코딩하세요
	      // MemberVO 로 자동되지 않는 전달인수 -  pwd_check , re_id  들은 별도의 변수로 전달받고, 별도로 이상유무를
	      // 체크하고 이상이 있을시 memberJoinForm.jsp로 되돌아 가세요. 
	      // 이때  re_id 도 mav 에 별도 저장하고 되돌아 갑니다.
	      // 모두 이상이 없다고 점검이 되면 회원 가입하고, 회원가입 완료라는 메세지와 함께 loginForm.jsp 로 되돌아 가세요

		mav.setViewName("member/memberJoinForm"); //되돌아갈페이지의 기본은 회원가입 페이지
		mav.addObject("re_id",re_id);

		if(result.getFieldError("userid")!=null)
			mav.addObject("message",result.getFieldError("userid").getDefaultMessage());
		else if(result.getFieldError("pwd")!=null)
			mav.addObject("message",result.getFieldError("pwd").getDefaultMessage());
		else if(result.getFieldError("name")!=null)
			mav.addObject("message",result.getFieldError("name").getDefaultMessage());
		else if(result.getFieldError("email")!=null)
			mav.addObject("message",result.getFieldError("email").getDefaultMessage());
		else if(result.getFieldError("phone")!=null)
			mav.addObject("message",result.getFieldError("phone").getDefaultMessage());
		else if(re_id==null||!membervo.getUserid().equals(re_id))
			mav.addObject("message","아이디 중복체크가 되지 않았습니다.");
		else if(!membervo.getPwd().equals(pwd_check))
			mav.addObject("message","비밀번호 확인이 일치하지 않습니다.");
		else {
			ms.insertMember(membervo);
			mav.addObject("message","회원가입이 완료되었습니다.");
			mav.setViewName("member/loginForm");
		}
		
		return mav;
	}
	
	
	@RequestMapping("/memberEditForm")
	public ModelAndView memberEditForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
	    MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
	    mav.addObject("dto", mvo);
		
		mav.setViewName("member/memberEditForm");
		return mav;
	}
	
	@RequestMapping(value="/memberEdit", method=RequestMethod.POST)
	public String memberEdit(
			@ModelAttribute("dto") @Valid MemberVO membervo, BindingResult result,
			@RequestParam(value="pwd_check", required=false) String pwdchk, Model model, HttpServletRequest request
			) {
		String url="member/memberEditForm";
		
		//비밀번호, 비밀번호 확인 이메일 전화번호를 확인 후 회원 정보를 수정함.
		//회원 정보 수정 후 세션의 loginUser 수정 후 main으로 이동함
		if(result.getFieldError("pwd")!=null)
			model.addAttribute("message",result.getFieldError("pwd").getDefaultMessage());
		else if(result.getFieldError("name")!=null)
			model.addAttribute("message",result.getFieldError("name").getDefaultMessage());
		else if(result.getFieldError("email")!=null)
			model.addAttribute("message",result.getFieldError("email").getDefaultMessage());
		else if(result.getFieldError("phone")!=null)
			model.addAttribute("message",result.getFieldError("phone").getDefaultMessage());
		else if(!membervo.getPwd().equals(pwdchk))
			model.addAttribute("message","비밀번호 확인이 일치하지 않습니다.");
		else {
			ms.updateMember(membervo);
			HttpSession session=request.getSession();
			session.setAttribute("loginUser", membervo);
			url="redirect:/main";
		}
		
		return url;
	}
	
	
}
