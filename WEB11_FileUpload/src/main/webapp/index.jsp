<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>

	<form action="upload.do" method="post" enctype="multipart/form-data">
		<!-- 파일 업로드 시 지켜야할 사항 #1 : method는 반드시 post로! -->
		<!-- 파일 업로드 시 지켜야할 사항 #2 : enctype="multipart/form-data" 속성 꼭 추가! -->
		글쓴이 : <input type="text" name="name"><br>
		제목 : <input type="text" name="title"><br>
		파일 지정하기 : <input type="file" name="uploadFile"><br>
		<input type="submit" value="전송"> 
	</form>
</body>
</html>