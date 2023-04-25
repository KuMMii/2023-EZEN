<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
if(session.getAttribute("loginUser")==null){
	response.sendRedirect("071_LoginForm.jsp");
}else{
	%>
	아이디 : <%=session.getAttribute("loginUser") %><br>
	성명 : 홍길동<br>
	주소 : 서울특별시 마포구...<br>
	전화번호 : 010-XXXX-XXXX<br>
	주민등록번호: XXXXXXX-XXXXXXX<br>
	<input type="button" value="정보수정" />
<%
}
%>

</body>
</html>