<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05_Select</title>
</head>
<body>

<form method="get" action="05_Select_to.jsp">
	<label for="job">Job</label><br>
	<select id="job" name="job" size="1">
		<option value="">Choose</option>
		<option value="Student">Student</option>
		<option value="Computer/Internet">Computer/Internet</option>
		<option value="Press">Press</option>
		<option value="Civil Servant">Civil Servant</option>
		<option value="Soldier">Soldier</option>
		<option value="CS">CS</option>
	</select><br><br><br>
	<label for="interest" style="float:left;">Interest</label><br>
	<select id="interest" name="interest" size='5' multiple="multiple">
		<option value="Espresso">Espresso</option>
		<option value="Roasting">Roasting</option>
		<option value="Coffeebean">Coffee bean</option>
		<option value="Hand drip">Hand drip</option>
		<option value="Coffee Machine">Coffee Machine</option>
	</select><br><br>
	<input type="submit" value="submit">
</form>

</body>
</html>