<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "com.ezen.servlet.dto.MemberDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	// 1. jsp문법으로 객체를 생성하는 방법
	
	//임포트 없이 객체 생성
	com.ezen.servlet.dto.MemberDto member1= new com.ezen.servlet.dto.MemberDto();
	
	//패키지 또는 클래스 import 후 생성
	MemberDto member2= new MemberDto();
	%>
<!-- 2. 액션 태그를 이용한 객체 생성 -->
<jsp:useBean id="member" class="com.ezen.servlet.dto.MemberDto"></jsp:useBean>

<h3>
자바 빈 객체의 저장된 정보 출력하기 <br>
이름 : <%=member.getName() %><br>
아이디 : <%=member.getUserid() %><br><br>
</h3>

<h3>
정보 변경한 후 변경된 정보 출력하기<br>
<%
member1.setName("홍길동");
member1.setUserid("HongGilDong");
%>
이름 : <%=member1.getName() %><br>
아이디 : <%=member1.getUserid() %>
</h3><br><br>

<h3>
액션태그로 정보 변경한 후 변경된 정보 출력하기<br>
<jsp:setProperty property="name" name="member" value="홍길서"/>
<jsp:setProperty property="userid" name="member" value="HongGilSeo"/>
이름 : <jsp:getProperty property="name" name="member"/><br>
아이디 : <jsp:getProperty property="userid" name="member"/>
<!-- jsp로 만든 객체는 액션태그로 Access되지 않음 -->
</h3><br><br>




</body>
</html>