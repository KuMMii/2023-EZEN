<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String [] movieList={"타이타닉","시네마천국","혹성탈출","킹콩"};
	request.setAttribute("mList",movieList);
%>
<table border="1" style="width:700px"; text-align:center">
	<tr>
		<th>index</th><th>count</th><th>title</th>
	</tr>
	<c:forEach items="${mList }" var="movie" varStatus="state">
		<tr><td>${state.index}</td><td>${state.count}</td><td>${movie}</td></tr>
	</c:forEach>
</table>

<br><br><br>

<table border="1" style="width:700px"; text-align:center">
	<tr>
		<th>index</th><th>count</th><th>title</th>
	</tr>
	<c:forEach items="${mList }" var="movie" varStatus="state">
		<c:choose>
			<c:when test="${state.first }">
				<tr style="font-weight:bold;color:blue;">
					<td>${state.index}</td><td>${state.count}</td><td>${movie}</td>
				</tr>
			</c:when>
			<c:when test="${state.last }">
				<tr style="font-weight:bold;color:green;">
					<td>${state.index}</td><td>${state.count}</td><td>${movie}</td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr style="color:black;">
					<td>${state.index}</td><td>${state.count}</td><td>${movie}</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</table>
<!-- 
${status.first} : 현재 반복이 첫번째이면 true 리턴
${status.last} : 현재 반복이 마지막이면 true 리턴
 -->

<!-- 마지막 아이템만 빼고 각 아이템 사이에 (,) 컴마를 찍어 출력하고 싶을 때 -->
<h2>
<c:forEach var="movie" items="${mList }" varStatus="status">
	<%-- ${movie} --%>
	${status.current}
	<c:if test="${not status.last}">, </c:if>
</c:forEach>
</h2>
<br><br>
<!-- 
${status.current} : 현재 아이템
${status.begin} : 시작값
${status.end} : 끝값
${status.step} : 증가값
 -->

<h2>반복 실행문의 또다른 사용 예</h2>
<h2>
<c:forEach var="cnt" begin="1" end="10" varStatus="status">
	${cnt}	<c:if test="${not status.last}">, </c:if>
</c:forEach>
</h2>
<br><br>

<hr>
<table border="1" style="width:50%"; text-align:center;" align="left">
	<tr><th>index</th><th>count</th><th>cnt</th></tr>
	<c:forEach var="cnt" begin="7" end="10" varStatus="status">
	<tr><td>${status.index}</td><td>${status.count}</td><td>${cnt}</td></tr>
	</c:forEach>
</table>
</body>
</html>