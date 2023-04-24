<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06_Table</title>
</head>
<body>
	<table cellspacing="1" bgcolor="black" width="500">
		<tr bgcolor="white" height="80">
			<td>1C 1R</td><td>1C 2R</td><td>1C 3R</td><td>1C 4R</td><td>1C 5R</td>
		</tr>
		<tr bgcolor="white" height="80">
			<td>2C 1R</td><td>2C 2R</td><td>2C 3R</td><td>2C 4R</td><td>2C 5R</td>
		</tr>
		<tr bgcolor="white" height="80">
			<td>3C 1R</td><td>3C 2R</td><td>3C 3R</td><td>3C 4R</td><td>3C 5R</td>
		</tr>
		<tr bgcolor="white" height="80">
			<td>4C 1R</td><td>4C 2R</td><td>4C 3R</td><td>4C 4R</td><td>4C 5R</td>
		</tr>
		<tr bgcolor="white" height="80">
			<td>5C 1R</td><td>5C 2R</td><td>5C 3R</td><td>5C 4R</td><td>5C 5R</td>
		</tr>
	</table><br><br><br><br>


	<table cellspacing="1" bgcolor="black" width="500">
		<%
			for(int i=1; i<=5; i++){
		%>
				<tr bgcolor="white" height="80">
		<%
					for(int j=1; j<=5;j++){
		%>
						<td><%=i %>C <%=j %>R</td>
		<%
					}
		%>
				</tr>
		<%
			}
		%>
		
	
	</table>


</body>
</html>