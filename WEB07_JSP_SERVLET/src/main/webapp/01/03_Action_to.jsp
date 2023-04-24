<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03_Action_to.jsp</title>
</head>
<body>
<h1>03_Action_to.jsp 페이지</h1>

<!--아래는 서버에서 실행되어 HTML5로 구성될 내용들  -->
<%
	String name=request.getParameter("name"); //"name": form내부에 있던 해당 입력란의 name값
	String id=request.getParameter("id"); //"id" : form 내부에 있던 해당 입력란의 name값
	String pwd=request.getParameter("pwd");
	String pwd_re=request.getParameter("pwd_re");
	
	String useritem=request.getParameter("useritem");
	//getParameter 로 받는 모든 데이터는 String 데이터로 받을 수 있음
%>

<h3>
Name : <%=name%><br>
ID : <%=id%><br>
Password : <%=pwd%><br>
Password Check : <%=pwd_re%><br><br>

Hidden PhoneNum : <%=useritem %>
</h3>
</body>
</html>