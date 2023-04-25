<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.net.URLDecoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>일반사용자 로그인</h2>
<%
//String userName = request.getParameter("userName");
//String userName = (String)request.getAttribute("userName");
String userName=URLDecoder.decode(request.getParameter("userName"),"UTF-8");
%>
<h2><%=userName %>(<%=request.getParameter("userID") %>)님 환영합니다.</h2>
</body>
</html>