<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04_CheckBox_to</title>
</head>
<body>

<h2>Sent URL</h2>
<h3>http://localhost:8090/WEB07_JSP_SERVLET/01/04_CheckBox_to.jsp?item=belt&item=watch&item=diamond</h3>

<%
	String [] item = request.getParameterValues("item");
	if(item == null){//item이 null이라는 건 체크박스가 하나도 체크 안됐을 때
		%>
		<h3>Nothing Selected</h3>
	<%
	}else{
		%>
		<h3>Items you selected</h3>
	<%
		for(String items:item){
			%>
			<h3><%=items %></h3>
	<%	
		}
	}
%>



</body>
</html>