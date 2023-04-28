<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<script type="text/javascript">
	function withdrawConfirm(){
		var bool=confirm('진짜진짜 탈퇴하시나요? 진짜로?');
		if(bool){
			location.href="member.do?command=delete";
		}else{
			return;
		}
	}

</script>

</head>
<body>
<%
	if(session.getAttribute("loginUser")==null){
		response.sendRedirect("member.do");
	}
%>

<%-- 
<c:if test="${empty loginUser }">
	<%response.sendRedirect("login.do"); %>
</c:if>
 --%>
<table>
	<tr><td>${loginUser.userid}(${loginUser.name})님이 로그인 하셨습니다.</td></tr>
	<tr><td>email : ${loginUser.email}</td></tr>
	<tr><td>전화번호 : ${loginUser.phone}</td></tr>
	<tr>
		<td>
			<input type="button" value="로그아웃" onClick="location.href='member.do?command=logout'"/>
			<input type="button" value="회원정보변경" onClick="location.href='member.do?command=updateForm'"/>
			<input type="button" value="회원 탈퇴" onClick="withdrawConfirm();"/>
		</td>
	</tr>
	<!-- 어떤 태그이든 onClick 속성을 써서 페이지 이동을 하고자 한다면, 위와 같이 location.href를 onClick속성에 지정해서 이동.
	onClick 속성에는 페이지 이동 기능이 없기 때문에 페이지만 쓴다고 이동하지 않으니 반드시 location.href로 페이지를 지정하기.
	 -->
</table>


<br><br>

<c:if test="${loginUser.admin==1 }">

	<table width="800" bgcolor="black" cellspacing="1">
		<tr bgcolor="white">
			<th>아이디</th><th>이름</th><th>전화번호</th><th>이메일</th><th>등급</th><th>등급변경</th>
		</tr>
		<c:forEach items="${mList}" var="member">
			<tr bgcolor="white" align="center">
				<td>${member.userid}</td>
				<td>${member.name}</td>
				<td>${member.phone}</td>
				<td>${member.email}</td>
				<td>
					<c:choose>
						<c:when test="${member.admin==0}">일반</c:when>
						<c:otherwise>관리자</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${member.userid==loginUser.userid}">&nbsp;</c:when>
						<c:otherwise>
							<input type="button" value="변경" 
							onClick="location.href='member.do?command=editadmin&userid=${member.userid}&admin=${member.admin}'"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
		
		
	</table>
</c:if>







</body>
</html>