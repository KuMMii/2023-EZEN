<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>joinForm.jsp</title>
<script type="text/javascript">
	function idCheck(){
		//아이디를 입력하지 않고 버튼을 클릭했다면 아이디를 입력하라고 메세지를 표시하고 현재 함수는 종료
		if(document.frm.userid.value==""){
			alert('아이디를 먼저 입력 후 중복체크 버튼을 클릭하세요');
			document.frm.userid.focus();
			return;
		}
		
		var inputid = document.frm.userid.value;
		var opt = 'toolbar=no, menubar=no, scrollbars=ues, width=500, height=200';
		//서블릿을 호출하고 포워딩된 페이지가 팝업창에 열릴 예정
		//그래서 첫번째 요소는 서블릿의 이름을 써줌
		//서블릿 호출시 파라미터를 아래와 같이 호출되는 주소 뒤에 ?함께 전달할 수 있음
		window.open('idcheck.do?userid='+inputid ,'id-check',opt);
		
	}
	
	function joinCheck(){
		if(document.frm.name.value=""){
			alert("이름은 필수입력 사항입니다.");
			document.frm.name.focus();
			return false;
		}else if(document.frm.userid.value.lenght==0){
			alert("아이디는 필수입력 사항입니다.")
			document.frm.userid.focus();
			return false;
		}else if(document.frm.pwd.value.lenght==0){
			alert("비밀번호는 필수입력 사항입니다.")
			document.frm.pwd.focus();
			return false;
		}else if(document.frm.userid.value!=document.frm.reid.value){
			alert("아이디는 중복체크를 하지 않으셨습니다.")
			document.frm.userid.focus();
			return false;
		}else if(document.frm.pwd.value!=document.frm.pwd_check.value){
			alert("비밀번호 확인이 일치하지 않습니다.")
			document.frm.pwd.focus();
			return false;
		}else{
			return true;
		}
	}
</script>
</head>
<body>

<h2>회원 가입</h2>'*'표시 항목은 필수 입력 항목입니다.
	<form method="post" action="join.do" name="frm">
	<table>
		<tr><td>이름</td><td><input type="text" name="name" size="20">&nbsp;*</td></tr>
		<tr><td>아이디</td><td><input type="text" name="userid" size="20">&nbsp;*
			<input type="button" value="중복 체크" onClick="idCheck();"/>
			<input type="hidden" value="" name="reid"/></td>
		</tr>
		<tr><td>비밀번호</td><td><input type="password" name="pwd" size="20">&nbsp;*</td></tr>
		<tr><td>비밀번호 확인</td>
		<td><input type="password" name="pwd_check" size="20">&nbsp;*</td></tr>
		<tr><td>이메일</td><td><input type="text" name="email" size="20"></td></tr>
		<tr><td>전화번호</td><td><input type="text" name="phone" size="20"></td></tr>
		<tr><td>등급</td>
			<td><input type="radio" name="admin" value="0" checked="checked">일반회원&nbsp;
					<input type="radio" name="admin" value="1" >관리자
			</td>
		</tr>
		<tr><td colspan="2" align="center">
			<input type="submit" value="회원 가입" onClick="return joinCheck()"/>
			<input type="reset" value="취소"></td></tr>
	</table>
</form>

</body>
</html>