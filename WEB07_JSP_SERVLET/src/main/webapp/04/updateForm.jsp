<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.sql.ResultSet" %>
<%@ page import= "java.sql.PreparedStatement" %>
<%@ page import= "java.sql.Connection" %>
<%@ page import= "java.sql.DriverManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateForm</title>

<%!
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	
	String sql="select * from members where id=?";
%>
</head>
<body>

<%
	String userid=request.getParameter("userid");
	String name=null;
	String phone=null;
	try{
		Class.forName(driver);
		con=DriverManager.getConnection(url,"scott", "tiger");
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,userid);
		rs=pstmt.executeQuery();
		
		if(rs.next()){   //하나밖에 없으니까 if사용
			name=rs.getString("name");
			phone=rs.getString("phone");
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)con.close();
		}catch(Exception e){e.printStackTrace();}
	}
%>

<h2>회원의 정보 수정 폼</h2>
<form action="updateMember_do.jsp" method="post">
<table>
	<tr><td>이름</td><td><input type="text" name="name" size="20" value="<%=name %>"></td></tr>
		<tr><td>아이디</td><td><%=userid %></td></tr>
		<tr><td>비밀번호</td><td><input type="password" name="pwd" size="20"></td></tr>
		<tr><td>전화번호</td><td><input type="text" name="phone" size="11" value="<%=phone %>"></td></tr>
		<input type="hidden" name="userid" value="<%=userid %>"/>
		<tr><td colspan="2">
			<input type="submit" value="정보수정"><input type="reset" value="취소"></td></tr>
</table>
</form>

</body>
</html>