<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>073_ForwardResult</title>
</head>
<body>
<%
	String age=request.getParameter("age");

	String name=(String)request.getAttribute("name");//Attribute에 저장된 전송자료
	//Attribute에 저장형식은 모든 클래스의 부모 클래스인 Object형태로 저장되므로, 다시 값을 추출할 때 강제 캐스팅 필요
	//getParameter보다 getAttribute가 좋은점: 우선 한글 지원이 됨
%>

<h2>forward 방식으로 이동된 페이지</h2>
<h2>나이 : <%=age %></h2>
<h2>이름 : <%=name %></h2>
</body>
</html>