<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
정보입력 페이지(jsp)->정보처리 페이지 (jsp)->처리결과페이지(jsp)이 세단계를 거친 자료처리방식은 옛날 방식임
주로 윈도우 서버(Window NT)에서 ASP 언어를 사용할 때 많이 사용하던 방식

다른 방식으로 JAVA&JSP로 넘어오면서 자바 프로그램 코드가 실행가능해지는 WAS서버를 사용하고, 이 서버에서는 정보처리페이지(jsp)를
사용하지 않는 대신, Servlet이라는 웹용 클래스(서버에 생성하고 서버에 실행하는)를 생성해 정보처리 명령을 실행하게 함
 -->

<form method="get" action="../Forward_useServlet">
	<label for="userid">아이디 : </label>
	<input type="text" name="id" id="userid"><br>
	<label for="userpwd">암&nbsp;호</label>
	<input type="password" name="pwd" id="pwd"><br>
	<input type="submit" value="로그인">
</form>


</body>
</html>