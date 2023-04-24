<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String name = request.getParameter("name"); %>
<h2><%=name %>님 안녕하세요!</h2>
<h2>사이트에 로그인 해주셔서 감사합니다.</h2>
<h2>즐거운 시간 되세요!</h2>
</body>
</html>