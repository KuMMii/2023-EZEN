<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>071_LoginForm</title>
</head>
<body>

<%
	if(session.getAttribute("loginUser")!=null){
		response.sendRedirect("073_main.jsp");//누군가 로그인이 되어있다면 main으로 이동
	}else{
%>
	<form method="post" action="072_Login_do.jsp">
		<label for="userid">아이디 : </label>
		<input type="text" name="id" id="userid"><br>
		<label for="userpwd">암호: </label>
		<input type="password" name="pwd" id="userpwd"><br>
		<input type="submit" value="로그인">
	</form>
<%
	}
%>



</body>
</html>