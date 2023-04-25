<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>083_main</title>
</head>
<body>
<%
	if(session.getAttribute("loginUser")==null){
		response.sendRedirect("081_LoginForm.jsp");//로그인창으로 되돌아옴
	}else{
%>
	로그인 관리자 <br>전화번호 010-2345-4565
	<h2> <%=session.getAttribute("loginUser") %>님이 로그인하셨습니다.</h2>
	저희 사이트에 방문해주셔서 감사합니다.<br> 즐거운 시간 되세욤<br>
	
	<form method="get" action="">
		<input type=submit value="마이페이지">
	</form>
	
	<form method="get" action="">
		<input type=submit value="로그아웃">
		<!-- 074_Logout_do.jsp에서 로그인정보에 해당하는 세션값을 지우고 로그인창으로 이동하게 코딩하기 -->
	</form>
<%
	}
%>
</body>
</html>