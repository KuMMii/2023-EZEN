<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name="joinForm" action="03_Action_to.jsp" method="post">
	<!-- 
	name:스크립트에서 다른것들과 구분하여 명명하기 위한 이름으로 사용. id가 css에서 구분하기 위한 이름이었다면 
		name은 주로 DOM(자바스크립트 또는 제이쿼리)에서 구분하기 위한 이름이라고 보면 됨
	action:입력란 선택란에 입력하고 선택한 내용이 서버에 전달되고, 페이지가 이동할 대상파일
	method:전달방식을 의미하며, get은 일반전송방식, post는 비공개 전달방식 사용
	 -->
		<label for="name">Name</label><span style="color:red;">*</span>
		<input type="text" id="name" name="name" value=""> <br>
		
		<label for="id">ID</label><span style="color:red;">*</span>
		hong<input type="hidden" id="id" name="id" value="hong"> <br><!-- 수정못하게 지정해놓고 내용 전달은 되게 하는거 -->
		
		<label for="pwd">PWD</label><span style="color:red;">*</span>
		<input type="password" id="pwd" name="pwd" value=""> <br>
		
		<label for="pwd_re">PWD_RE</label><span style="color:red;">*</span>
		<input type="password" id="pwd_re" name="pwd_re" value=""> <br>
		
		<input type="hidden" name="useritem" value="010-2344-4566">
		
		<input type="submit" value="Join">		 
		<input type="reset" value="Reset">		
</form>

</body>
</html>