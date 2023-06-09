<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>01_Basic.jsp</title>
</head>
<body>

<h2>안녕하세요</h2>
<h2>JAVA SERVER PAGE(JSP)</h2>

<!-- JSP는 JAVA SERVER PAGE의 약자로, 웹페이지내부에 프로그래밍적인 요소를 추가하거나
서버에서 계산되고 실행된 결과를 웹페이지에서 표시하고자 할때 사용함. 쉽게 얘기한다면, 웹페이지 HTML5중간중간에
자바 프로그래밍 코드를 좀 같이 쓰겠습니다. 라는 뜻과 비슷

사용예는 아래와 같음(날짜변수 d의 선언과 객체 초기화 동작) -->
<% java.util.Date d = new java.util.Date(); %>
<!-- HTML로 페이지를 구성하던 중, JSP에 의한 컨텐츠가 중간에 나와야 한다면 필요한 곳에 JSP명령을 씀 -->
<%--현재 jsp 파일 안에 html문법사이로 jsp 문법이 껴들어 코딩될때는 <%%>를 사용함 --%>

<h2>현재시간 : <%=d %></h2>
<h2>현재시간 : <%=new java.util.Date() %></h2>
<%--다만 페이지에 출력될 내용을 기술한다면 <%=%>를 쓰고 변수명이나 출력할 내용을 씀 --%>


<%--<%jsp명령%> --%>
<%--<%=변수 또는 출력 내용%>:웹페이지에 출력 --%>

<!--일반텍스트와 jsp명령의 주석처리  -->

<!-- 1. 안녕하세요 -일반텍스트에 주석처리 -->
<%--2.<%=d%>-jsp코드의 주석처리 --%>

<!--jsp명령은 html태그와 함게 파일로 저장되어 서버에 보관됨. 클라이언트의 요청을 받으면 해당 파일(~.jsp)이 클라이언트로
전송되어 웹브라우저에 표시가 되게 되는데, 그전에 jsp명령은 이미 실행되어서 결과만 html태그와 같이 전송되어짐  -->
</body>
</html>