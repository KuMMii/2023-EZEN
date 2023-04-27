<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idcheck</title>
<script type="text/javascript">
function idok(id){
	opener.document.frm.userid.value=id;
	opener.document.frm.reid.value=id;
	self.close();  //자기 창 닫을 때 자주쓰는 함수
}
</script>
</head>
<body>
<c:choose>
	<c:when test="${ result==1 }">
		${userid}는 이미 사용 중인 아이디입니다.
			<script type="text/javascript">
			//팝업창을 오픈한 주체:opener
				opener.document.frm.userid.value="";
				opener.document.frm.reid.value="";
			</script>
	</c:when>
	<c:otherwise>
		${userid}는 사용 가능한 아이디입니다.
		<input type="button" value="사용할게요" onClick="idok('${userid}')"/>
	</c:otherwise>
</c:choose>

<br><br>
<!-- 첫번째 체크한 아이디 말고 다른 아이디를 체크하기 위한 폼 -->
<form action="idcheck.do" method="get" name="frm">
	아이디 : <input type="text" name="userid" value="${userid }">
	<input type="submit" value="중복 체크">
</form>









</body>
</html>