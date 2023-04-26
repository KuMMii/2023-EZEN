<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.sql.PreparedStatement" %>
<%@ page import= "java.sql.Connection" %>
<%@ page import= "java.sql.DriverManager" %>

<%
//전달된 userid로 레코드를 삭제한 후 MemberMGR로 되돌아가기
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
Connection con = null;
PreparedStatement pstmt = null;
String driver = "oracle.jdbc.driver.OracleDriver";
String url="jdbc:oracle:thin:@localhost:1521:xe";

String userid= request.getParameter("userid");

String sql="delete from members where id=?";
try{
	Class.forName(driver);
	con=DriverManager.getConnection(url,"scott","tiger");
	pstmt=con.prepareStatement(sql);
	
	pstmt.setString(1, userid);
	
	pstmt.executeUpdate();
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		if(pstmt!=null)pstmt.close();
		if(con!=null)con.close();
	}catch(Exception e){e.printStackTrace();}
}

response.sendRedirect("MemberMGR.jsp");


%>