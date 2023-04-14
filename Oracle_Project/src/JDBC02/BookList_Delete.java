package JDBC02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BookList_Delete {
public static void main(String[] args) {
	String url ="jdbc:oracle:thin:@localhost:1521:xe";
	String driver="oracle.jdbc.driver.OracleDriver";
	
	Connection con=null; //데이터베이스 연결을 위한 객체
	PreparedStatement pstmt=null; //con에서 SQL실행해주는 객체
	
	try {
		Class.forName(driver);
		con=DriverManager.getConnection(url,"scott","tiger");

		Scanner sc= new Scanner(System.in);
		System.out.printf("삭제할 책의 번호를 입력하세요: ");
		String booknum =sc.nextLine();

		String sql="delete booklist where booknum=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(booknum));
		int result =pstmt.executeUpdate();
		if(result==1)System.out.println("삭제 성공");
		else System.out.println("삭제 실패");
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	try {
		if(con!=null)con.close();
		if(pstmt!=null)pstmt.close();
		
	}catch(SQLException e) {e.printStackTrace();}
}
}
