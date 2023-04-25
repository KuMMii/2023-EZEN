<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.sql.PreparedStatement" %>
<%@ page import= "java.sql.Connection" %>
<%@ page import= "java.sql.DriverManager" %>

<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");

Connection con = null;
PreparedStatement pstmt=null;

String driver = "oracle.jdbc.driver.OracleDriver";
String url="jdbc:oracle:thin:@localhost:1521:xe";
String id="scott";
String pass="tiger";
String sql="insert into members(id,name, pwd, phone) values(?,?,?,?)";

//레코드들을 추가
//try catch 구문을 JDBC에서 사용한 것처럼 레코드를 추가 코딩을 완성하기

try{
	Class.forName(driver);
	con=DriverManager.getConnection(url,id,pass);
	pstmt=con.prepareStatement(sql);
	
	Scanner sc = new Scanner(System.in);
	out.print("id를 입력하세요 : ");
	String id = sc.
	out.print("이름을 입력하세요 : ");
	String name = sc.
	out.print("비밀번호를 입력하세요 : ");
	String pwd = sc.
	out.print("전화번호를 입력하세요 : ");
	String phone = sc.
	
		
			
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		if(pstmt!=null)pstmt.close();
		if(con!=null)con.close();
	}catch(Exception e){e.printStackTrace();}
}

%>