<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03_JSTL</title>
</head>
<body>

<!-- 
prefix="c" : JSTL 문법을 사용하기 위해서 태그의 첫글자를 c를 사용하겠다는 표시
그리고 c:으로 시작하는 "태그"는 jstl문법이 적용됨
 -->
 <%-- JSTL 사용 방법 : <c:태그이름> </c:태그이름> 또는 <c:태그이름 /> --%>
 
 <!-- el에 없는 jsp기능 대부분을 jstl에서 제공함. 변수, 반복문, if 등등 -->



<h2>
단순 출력<br>
JSTL 출력 : <c:out value="Hello"></c:out><br>
EL 출력 : ${"Hello" }
</h2><br><br><br>

<h2>
변수 생성 및 초기화 1<br>
<c:set var="msg" value="Hello"></c:set><br>
생성한 변수를 EL에 의해 출력<br>
\${msg}=${msg }
</h2><br><br><br>

<h2>
변수 생성 및 초기화 2<br>
<c:set var="age">30</c:set><br>
생성한 변수를 EL에 의해 출력<br>
\${age}=${age}
</h2><br><br><br>

<h2>
객체 생성<br>
<%
com.ezen.servlet.dto.MemberDto mem = new com.ezen.servlet.dto.MemberDto();
mem.setUserid("hong");
mem.setName("홍길동");
out.println(mem.getUserid());
out.println(mem.getName());
%>
</h2><br><br><br>

<c:set var="member" value="<%=new com.ezen.servlet.dto.MemberDto()%>"></c:set>

<!-- 멤버변수 값 변경 -->
<h2>
<c:set target="${member }" property="name" value="홍길동"></c:set>
<c:set target="${member }" property="userid">Hong</c:set>
EL에 의한 멤버변수 출력 - "객체.멤버변수이름"만으로 getter기능이 대체됨<br>
\${member.name}=${member.name}<br>
\${member.userid}=${member.userid}<br>
클래스에 각 멤버변수에 대한 getter와 setter가 존재해야 위의 실행이 가능함<hr><br>
</h2><br><br><br>

<h2>
그외 변수와 출력 기능-jstl과 el의 혼합 사용
<c:set var="add" value="${10+5 }"></c:set>
\${add }=${add }<br>
<c:set var="flag" value="${10+5 }"></c:set>
\${flag }=${flag}<br>
<br><br><br>

input 태그에 el로 값 설정
<input type="text" value = "${member.userid }"><br>
</h2>











</body>
</html>