<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
<%
	if(session.getAttribute("loginUser")==null){
		response.sendRedirect("login.do");
	}
%>

<%-- 
<c:if test="${empty loginUser }">
	<%response.sendRedirect("login.do"); %>
</c:if>
 --%>
<table>
	<tr><td>${loginUser.userid}(${loginUser.name})님이 로그인 하셨습니다.</td></tr>
	<tr><td>email : ${loginUser.email}</td></tr>
	<tr><td>전화번호 : ${loginUser.phone}</td></tr>
	<tr><td><input type="button" value="로그아웃" onClick="location.href='logout.do'"/>
	<!-- 어떤 태그이든 onClick 속성을 써서 페이지 이동을 하고자 한다면, 위와 같이 location.href를 onClick속성에 지정해서 이동.
	onClick 속성에는 페이지 이동 기능이 없기 때문에 페이지만 쓴다고 이동하지 않으니 반드시 location.href로 페이지를 지정하기.
	 -->
</table>



</body>
</html>