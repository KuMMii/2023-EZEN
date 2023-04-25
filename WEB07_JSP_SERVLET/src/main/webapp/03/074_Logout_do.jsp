<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
	//세션 항목 한개 삭제
	//session.removeAttribute("저당된 세션의 name값");
	//session.removeAttribute("loginUser");
	
	//현재 사이트의 모든 세션을 삭제
	session.invalidate();//세션의 내용을 모두 지우는 메서드
	
	//response.sendRedirect("071_LoginForm.jsp");
	%>
	<script type="text/javascript">
	alert("로그아웃 되었습니다.");
	location.href="071_LoginForm.jsp";
	</script>
