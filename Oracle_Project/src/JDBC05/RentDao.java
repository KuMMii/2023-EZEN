package JDBC05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentDao {

	//생성자를 private로 만들어서 외부에서 생성자를 사용할 수 없게 만듬
	private RentDao() {}
	
	//클래스 내부에서 딱 한개 유일한 객체를 생성함. private static으로 private요소는 클래스 내부에서 제한없이 사용가능
	private static RentDao itc = new RentDao();
	
//	외부에서 itc를 리턴받아 쓸 수 있게 해주는 public static메서드를 생성함
	public static RentDao getInstance() {return itc;}
	
	Connection con =null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	public ArrayList<RentDto> selectRent() {
		ArrayList<RentDto> list = new ArrayList<RentDto>();
		
		con=DBManager.getConnection();
		String sql = "select rentlist.*, to_char(rentdate, 'YYYY-MM-DD') as rentdateStr from rentlist order by rentdateStr desc ";
		try {
			pstmt= con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				RentDto rdto = new RentDto();
				rdto.setNumseq(rs.getInt("numseq"));
				rdto.setRentdate(rs.getString("rentdateStr"));
				rdto.setBooknum(rs.getInt("bnum"));
				rdto.setMembernum(rs.getInt("mnum"));
				rdto.setDiscount(rs.getInt("discount"));
				list.add(rdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {DBManager.close(con, pstmt, rs);
		}
	
		return list;
	}

	public ArrayList<RentDetailDto> selectRentDetail() {
		ArrayList<RentDetailDto> list = new ArrayList<RentDetailDto>();
		con = DBManager.getConnection();
		String sql = "select*from rentDetail order by rentdateStr desc";
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				RentDetailDto rdto=new RentDetailDto();
				rdto.setNumseq(rs.getInt("numseq"));
				rdto.setRentdate(rs.getString("rentdateStr"));
				rdto.setBooknum(rs.getInt("bnum"));
				rdto.setMembernum(rs.getInt("mnum"));
				rdto.setSubject(rs.getString("subject"));
				rdto.setName(rs.getString("name"));
				rdto.setRentprice(rs.getInt("rentprice"));
				rdto.setDiscount(rs.getInt("discount"));
				rdto.setAmount(rs.getInt("amount"));
				
				list.add(rdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		
		return list;
	}

	public int insertRent(RentDto rdto) {
		int result=0;
		
		con=DBManager.getConnection();
		String sql="insert into rentlist(numseq, rentdate, bnum, mnum, discount)"
				+ "values(rent_seq.nextVal, sysdate, ?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, rdto.getBooknum());
			pstmt.setInt(2, rdto.getMembernum());
			pstmt.setInt(3, rdto.getDiscount());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{DBManager.close(con, pstmt, rs);
			
		}

		return result;
	}

	public int updateRent(RentDto rdto) {
		int result=0;
		con=DBManager.getConnection();
		String sql = "update rentlist set rentdate=to_date(''||?||'','YYYY-MM-DD'), bnum=?, mnum=?, discount=? where numseq=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, rdto.getRentdate());
			pstmt.setInt(2, rdto.getBooknum());
			pstmt.setInt(3, rdto.getMembernum());
			pstmt.setInt(4, rdto.getDiscount());
			pstmt.setInt(5, rdto.getNumseq());
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {DBManager.close(con, pstmt, rs);
	}
		return result;
	
	}
	
	public RentDto getRent(int nseq) {
		RentDto rdto=null;
		con=DBManager.getConnection();
		String sql="select to_char(rentdate, 'YYYY-MM-DD') as rentdateStr, rentlist.* from rentlist where numseq=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, nseq);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				rdto = new RentDto();
				rdto.setNumseq(rs.getInt("numseq"));
				rdto.setRentdate(rs.getString("rentdateStr"));
				rdto.setBooknum(rs.getInt("bnum"));
				rdto.setMembernum(rs.getInt("mnum"));
				rdto.setDiscount(rs.getInt("discount"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {DBManager.close(con, pstmt, rs);}
		return rdto;
	}}
//	DBManager dbm = new DBManager();  
	//-->new가 부담스러워서 이렇게 함. 이러면 DBManager의 메소드를 전부 static으로 바꿔야함
	
//	public void insert() {
//		con=DBManager.getConnection();
//		
//		DBManager.close(con, pstmt, rs);
//	}
	
	
