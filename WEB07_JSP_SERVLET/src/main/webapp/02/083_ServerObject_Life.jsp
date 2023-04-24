<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
third의 pageContext 속성 : <%=pageContext.getAttribute("name") %><br>
third의 request 속성 : <%=request.getAttribute("name") %><br>
third의 session 속성 : <%=session.getAttribute("name") %><br>
third의 application 속성 : <%=application.getAttribute("name") %><br>

<!-- 
각 객체의 수명
pageContext : 현재페이지까지
request : forward 또는 다른 방식으로 전송되는 다음페이지까지(연장 가능)
session : 브라우져가 닫힐 때까지
application : 서버가 꺼지거나 리셋될 때까지
 -->
</body>
</html>