<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04_CheckBox</title>
</head>
<body>

<h2>Accessory</h2>
Choose your favorite
<hr>
<form method="get" action="04_CheckBox_to.jsp">
	<input type="checkbox" name="item" value="shoes">Shoes
	<input type="checkbox" name="item" value="bag">Bag
	<input type="checkbox" name="item" value="belt">Belt
	<br>
	<input type="checkbox" name="item" value="cap">Hat
	<input type="checkbox" name="item" value="watch">Watch
	<input type="checkbox" name="item" value="diamond">Jewelry<br>
	<input type="submit" value="Send">
</form>

</body>
</html>