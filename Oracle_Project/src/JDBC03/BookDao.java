package JDBC03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Dao:Database Access Object->데이터베이스 접근 및 작업 전용 클래스

public class BookDao {
	String url ="jdbc:oracle:thin:@localhost:1521:xe";
	String driver="oracle.jdbc.driver.OracleDriver";
	Connection con =null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	private Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"scott","tiger");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	private void close() {
		try {
			if(con!=null) con.close();
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<BookDto> selectBook() {
		ArrayList<BookDto> list=new ArrayList<BookDto>();
		//데이터베이스에서 booklist테이블을 조회하고 결과를 list에 담아서 return
		con =getConnection();
		String sql="select *from booklist order by booknum desc";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
//				String booknum=rs.getInt("booknum");
//				int makeyear=rs.getInt("makeyear");
//				int inprice= rs.getInt("inprice");
//				int rentprice=rs.getInt("rentprice");
//				String grade=rs.getString("grade");
//				String subject=rs.getString("subject");
//				
//				BookDto bdto = new BookDto();
//				bdto.setBooknum(booknum);
//				bdto.setSubject(subject);
//				bdto.setMakeyear(makeyear);
//				bdto.setInprice(inprice);
//				bdto.setRentprice(rentprice);
//				bdto.setGrade(grade);
				
				BookDto bdto = new BookDto();
				bdto.setBooknum(rs.getInt("booknum"));    
				bdto.setSubject( rs.getString("subject"));   
				bdto.setMakeyear(rs.getInt("makeyear"));    
				bdto.setInprice(rs.getInt("inprice"));  
				bdto.setRentprice(rs.getInt("rentprice"));   
				bdto.setGrade(rs.getString("grade")); 
				
				//반복이 실행될때마다 new BookDto()로 만들어진 객체가 다음 반복으로 없어지기 전에 list에 담아서 보관
				list.add(bdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		close();
		return list;
	}

	public int insertBook(BookDto bdto) {
		int result =0;
		
		//1. DB에 연결
		con= getConnection();
		
		
		//2. SQL문 설정
		String sql="insert into booklist values(book_seq.nextVal, ?, ?, ?, ?,?)";
		
		//3. SQL을 con과 함께 pstmt에 장착
		try {
			pstmt=con.prepareStatement(sql);
			//4. ?에 적정값을 배치
			pstmt.setString(1, bdto.getSubject());
			pstmt.setInt(2, bdto.getMakeyear());
			pstmt.setInt(3, bdto.getInprice());
			pstmt.setInt(4, bdto.getRentprice());
			pstmt.setString(5, bdto.getGrade());
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//DB연결 끊기
		close();
		
		return result;
	}

	public int deleteBook(int booknum) {
		int result =0;
		con=getConnection();
		
		String sql="delete from booklist where booknum=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, booknum);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public BookDto getBook(String booknum) {
		BookDto bdto = null;
		
		con=getConnection();
		String sql="select * from booklist where booknum=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(booknum));
			rs=pstmt.executeQuery();
			if(rs.next()) {
				bdto = new BookDto();
				bdto.setBooknum(rs.getInt("booknum"));
				bdto.setSubject(rs.getString("subject"));
				bdto.setMakeyear(rs.getInt("makeyear"));
				bdto.setInprice(rs.getInt("inprice"));
				bdto.setRentprice(rs.getInt("rentprice"));
				bdto.setGrade(rs.getString("grade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bdto;
	}

	public int updateBook(BookDto bdto) {
		int result =0;
		con=getConnection();
		String sql="update booklist set subject=?, makeyear=?,inprice=?, rentprice=?, grade=? where booknum=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, bdto.getSubject());
			pstmt.setInt(2, bdto.getMakeyear());
			pstmt.setInt(3, bdto.getInprice());
			pstmt.setInt(4, bdto.getRentprice());
			pstmt.setString(5, bdto.getGrade());
			pstmt.setInt(6, bdto.getBooknum());
			
			result= pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return result;
	}

	
	
	
}
