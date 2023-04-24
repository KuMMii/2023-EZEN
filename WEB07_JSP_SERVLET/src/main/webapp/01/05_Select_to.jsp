<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05_Select_to.jsp</title>
</head>
<body>
<%
String job = request.getParameter("job");
String interests[] = request.getParameterValues("interest");
%>
<h1>Your Job : <%=job %></h1>
<br><br><br>

<h1>Your Interest</h1>
<h1>
<%
if(interests == null) {out.print("Nothing selected");}//jsp로 html5태그에 출력하기 위한 메서드
else{
	for(String interest : interests){
%>
		<%=interest %>,
<%		
	}
}
%>
</h1>
</body>
</html>