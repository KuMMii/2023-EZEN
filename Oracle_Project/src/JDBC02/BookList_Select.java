package JDBC02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookList_Select {

	public static void main(String[] args) {
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"scott","tiger");
			System.out.println("데이터베이스에 연결 성공했습니다.");
			
			String sql="select*from booklist order by booknum desc";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			System.out.println("도서번호\t출판년도\t입고가격\t대여가격\t등급\t제목");
			System.out.println("-----------------------------------------------------------------------");
			while(rs.next()) {
				int booknum=rs.getInt("booknum");
				int makeyear=rs.getInt("makeyear");
				int inprice=rs.getInt("inprice");
				int rentprice=rs.getInt("rentprice");
				String grade=rs.getString("grade");
				String subject=rs.getString("subject");
				
				System.out.printf("%d \t %d \t %d \t %d \t %s \t %s \n",booknum, makeyear, inprice, rentprice, grade, subject);
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("데이터베이스에 연결 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("데이터베이스에 연결 실패");
		}
		
		try {
			if(con !=null)con.close();
			if(pstmt !=null) pstmt.close();
			if(rs !=null)rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("연결이 종료되지 않았습니다.");
		}
		
		
	}

}
