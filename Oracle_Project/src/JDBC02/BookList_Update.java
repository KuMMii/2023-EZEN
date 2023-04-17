package JDBC02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BookList_Update {

	public static void main(String[] args) {
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		
		Connection con=null; //데이터베이스 연결을 위한 객체
		PreparedStatement pstmt=null; //con에서 SQL실행해주는 객체
		ResultSet rs =null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"scott","tiger");
			Scanner sc = new Scanner(System.in);	
			
//			1. 수정할 레코드의 도서번호를 입력받음
			System.out.print("수정할 도서의 도서번호를 입력하세요 : ");
			String booknum=sc.nextLine();
			
//			2. 입력받은 번호로 도서를 조회함. 조회한 도서가 없으면 없다고 공지하고 프로그램 종료
			String sql="select *from booklist where booknum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(booknum));
			rs=pstmt.executeQuery();
			
			String subject, grade;
			int makeyear, inprice, rentprice;
			if(rs.next()) {
				subject=rs.getString("subject");
				makeyear=rs.getInt("makeyear");
				inprice=rs.getInt("inprice");
				rentprice=rs.getInt("rentprice");
				grade=rs.getString("grade");
						
				
			}else {
				System.out.println("해당 도서번호의 도서가 없습니다.");
				return;
			}
			String temp="";
			System.out.printf("도서 제목 : %s\n",subject);
			System.out.println("수정할 제목을 입력하세요(수정하지 않으려면 엔터를 입력하세요) : ");
			temp=sc.nextLine();
			if(!temp.equals("")) subject=temp;
			
			temp="";
			System.out.printf("출판 년도 : %d\n",makeyear);
			System.out.println("수정할 출판년도를 입력하세요(수정하지 않으려면 엔터를 입력하세요) : ");
			temp=sc.nextLine();
			if(!temp.equals("")) makeyear=Integer.parseInt(temp);
			
			temp="";
			System.out.printf("입고 가격 : %d\n",inprice);
			System.out.println("수정할 입고가격을 입력하세요(수정하지 않으려면 엔터를 입력하세요) : ");
			temp=sc.nextLine();
			if(!temp.equals("")) inprice=Integer.parseInt(temp);
			
			temp="";
			System.out.printf("대여 가격 : %d\n",rentprice);
			System.out.println("수정할 대여가격을 입력하세요(수정하지 않으려면 엔터를 입력하세요) : ");
			temp=sc.nextLine();
			if(!temp.equals("")) rentprice=Integer.parseInt(temp);
			
			temp="";
			System.out.printf("나이 등급 : %s\n",grade);
			System.out.println("수정할 나이등급을 입력하세요(수정하지 않으려면 엔터를 입력하세요) : ");
			temp=sc.nextLine();
			if(!temp.equals("")) grade=temp;

			sql="update booklist set subject=?, makeyear=?,inprice=?, rentprice=?, grade=? where booknum=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, subject);
			pstmt.setInt(2, makeyear);
			pstmt.setInt(3, inprice);
			pstmt.setInt(4, rentprice);
			pstmt.setString(5, grade);
			pstmt.setInt(6, Integer.parseInt(booknum));
			
			pstmt.executeUpdate();
			int result= pstmt.executeUpdate();
			if(result==1) System.out.println("Success");
			else System.out.println("Failed");
			
			
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
