<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>061_Login</title>
</head>
<body>
<!-- 로그인 폼 제작시 action란에는 서블릿이름을 써서 이동하게 함 - 서버내에서 로그인체크 진행 -->
<!-- 다만 지금은 아직 데이터베이스와의 연동이 미진행되어 있어서 약식 로그인 폼과 동작만 제작함 -->
	<form method="post" action="062_Login_do.jsp">
		<label for="id"> I&nbsp;D : </label>
		<input type="text" id="id" name="id"><br>
		<label for="pwd">PW : </label>
		<input type="password" id="pwe" name="pwd"><br>
		<input type="submit" value="Login">
	</form>
<!-- 
1. 로그인폼에 아이디와 패스워드 입력 후 로그인버튼(submit)클릭
2. action으로 지정된 페이지에 가서 아이디와 패스워드를 검증(유효한 아이디인가, 그 아이디에 맞는 정확한 패스워드인가)
3. 검증을 마친 결과(로그인성공 or 아이디 없음 or 패스워드 틀림)를 갖고 결과 페이지로 이동
 -->
 
 
 <!-- 
 4. 아이디와 패스워드 검증은 보통 서버내부에서 실행되는 JAVA프로그래밍으로 이뤄짐(별도의 JAVA 클래스 생성)
 5. 그 자바프로그램의 시작을 서블릿이라고 하며, 외부에는 노출되지 않음
 6. 아직 그 부분까지 학습하기 전이기 때문에 현재는 062_Login_do.jsp파일안에서 그작업을 실행함(코드외부노출가능)
  -->
</body>
</html>