<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02_Declare</title>
	<%-- jsp는 실행영역과 선언부 영역으로 구분됨. 보통 실행 영역은 body안에서 <% %>로 표시된 곳에 기술되지만, 
	선언부는 head부분에서 <%! %>로 표시된 곳에서 대부분 기술됨 --%>
<%!
	//선언부의 시작: 선언부 영역은 변수, 메서드 등이 정의됨
	
	//변수의 선언
	//선언부에 변수를 선언하면 수명이 훨씬 길다
	String str="Hello!";
	int a =5, b=-5;
	
	//메서드의 정의
	public int abs(int n){
		if(n<0) n=-n; //n=-1*n
		return n;
	}//jsp의 메서드는 static으로 선언하지 않아도 사용 가능
	
%>

</head>
<body>
<%
	//jsp실행부의 시작
	int c=10;
	c++;
	a++;  /* 새로고침을 할 때마다 a는 계속 1씩 늘어남 */
	out.print(str+"<br>");
	out.print(a+"의 절대값 : "+abs(a)+"<br>");
	out.print(c+"의 절대값 : "+abs(c)+"<br>");
%>
<br><br>
<%=str %><br>
<%=a %>의 절대값 : <%=abs(a) %><br>
<%=c %>의 절대값 : <%=abs(c) %><br>

<!-- 선언부(Declare)에 선언된 변수는 전역변수와 같이 사용되어, jsp페이지 어디서나 사용가능하며, 값도 일관되게 유지됨.
또한 페이지를 새로고침해도 이전값이 유지되는 특성이 있고, 이는 나중에 공부하게 될 세션값과 비슷하게 작용해 
서버가 재설정될때까지 값이 유지되는 특성이 있음 -->
</body>
</html>