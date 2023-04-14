package JDBC02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BookList_Insert {

	public static void main(String[] args) {

		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";

		Connection con=null; //데이터베이스 연결을 위한 객체
		PreparedStatement pstmt=null; //con에서 SQL실행해주는 객체
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"scott","tiger");
//			booknum에는 book_seq.nextVal로 자동입력되게 새로운 레코드를 insert하기
			//필요한 사항의 입력은 Scanner이용
			
			Scanner sc=new Scanner(System.in);
			System.out.printf("출판년도를 입력하세요: ");
			String makeyear=sc.nextLine();
			System.out.printf("입고가격을 입력하세요: ");
			String inprice=sc.nextLine();
			System.out.printf("대여가격을 입력하세요: ");
			String rentprice=sc.nextLine();
			System.out.printf("등급을 입력하세요: ");
			String grade=sc.nextLine();
			System.out.printf("제목을 입력하세요: ");
			String subject=sc.nextLine();
			
			
			//insert into customer values(1,'홍길동', 'abc1@abc.com','010-1234-2334');
//			String sql = "insert into customer values("+num+", '"+name+"', "+email+", "+tel+")";  -->옛날 방식
			
			//요즘 방식
			String sql="insert into booklist values(book_seq.nextVal, ? , ?, ?, ?, ?)";
			pstmt=con.prepareCall(sql);
			pstmt.setString(1, subject);
			pstmt.setInt(2, Integer.parseInt(makeyear));
			pstmt.setInt(3, Integer.parseInt(inprice));
			pstmt.setInt(4, Integer.parseInt(rentprice));
			pstmt.setString(5, grade);
			//setInt와 setString이 자동으로 필요한 따옴표(' ')를 붙여서 sql명령을 구성해줌
			
			//SQL select명령만 executeQuery 를 사용하고, 나머지는 executeUpdate메서드 사용
			//executeUpdate결과는 sql 명령이 정상 동작했을 때 1, 실패했을 때 0이 리턴됨
			int result=pstmt.executeUpdate();
			if(result==1)System.out.println("레코드 추가 성공");
			else System.out.println("레코드 추가 실패");
		
			
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
