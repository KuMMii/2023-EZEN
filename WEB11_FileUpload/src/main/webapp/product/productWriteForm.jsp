<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productWriteForm</title>
<link rel="stylesheet" type="text/css" href="css/product.css">
</head>
<body>

<div id="wrap" align="center">
	<h1>상품 등록 - 관리자 페이지</h1>
	<form method="post" enctype="multipart/form-data" 
	action="product.do?command=productWrite">
	<!-- multipartrequest의 영향을 받지않는 command에 정보전달함. 이건 서블릿에 정보를 전달하는거기 때문	-->
		<table>
			<tr><th>상 품 명</th><td><input type="text" name="name" size="80"></td></tr>
			<tr><th>가 격</th><td><input type="text" name="price">원</td></tr>
			<tr><th>사 진</th><td><input type="file" name="pictureurl"></td></tr>
			<tr><th>설 명</th><td><textarea cols="80" rows="10" name="description"></textarea></td></tr>
		</table><br>
		<input type="submit" value="등록">
		<input type="reset" value="다시 작성">
		<input type="button" value="목록" onclick="location.href='product.do?command=index'">
	</form>
</div>

</body>
</html>