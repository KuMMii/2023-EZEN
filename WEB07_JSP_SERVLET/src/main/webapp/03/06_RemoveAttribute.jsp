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
	session.setAttribute("s_name1","저는 세션에 저장된 첫번째값이에용^o^");
	session.setAttribute("s_name2","저는 세션에 저장된 두번째값이에용^o^");
	session.setAttribute("s_name3","저는 세션에 저장된 세번째값이에용^o^");
	
	out.print("<h3> >>세션값을 삭제하기 전<< </h3>");
	java.util.Enumeration names = session.getAttributeNames();
	while(names.hasMoreElements()){
		String name=names.nextElement().toString();
		String value = session.getAttribute(name).toString();
		out.print(name+":"+value+"<br>");
	}
	
	session.removeAttribute("s_name2");//이름을 지정해 세션에 저장된 객체를 제거함
	out.print("<hr> <h3> >>세션값을 삭제한 후<< </h3>");
	names = session.getAttributeNames();
	while(names.hasMoreElements()){
		String name= names.nextElement().toString();
		String value=session.getAttribute(name).toString();
		out.println(name+":"+value+"<br>");
	}
	
	session.invalidate();//세션의 내용을 모두 지우는 메서드
%>

</body>
</html>