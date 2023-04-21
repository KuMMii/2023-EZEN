<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--jsp는 java에서 사용하던 거의 모든 문법이 똑같이 사용됨  -->
<%
	int sum=0;
for(int i =1; i<=100; i++){
	sum+=i;
}
%>
<h2>1부터 100까지의 합계 : <%=sum %></h2>

<%
	sum=0;
for(int i =1; i<=10; i++){
	sum+=i;
%>
<h2>1부터 <%=i%> 까지의 합계 : <%=sum %></h2>
<%
}
%>

<!-- jsp명령들 사이에 html같은 요소들이 껴들어야 한다면 jsp 영역을 끝내고 해당 내용을 기술한 후 다시 jsp영역 시작
한페이지 안에서 jsp 명령은 중간에 영역이 끝나고 다시 시작해도 한프로그램처럼 이어짐
위와같이 하나의 반복문 안({})에 H2태그가 들어있다면 h2태그도 반복실행만큼 쓴거와 같음 -->

</body>
</html>