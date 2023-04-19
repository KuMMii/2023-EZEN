package JDBC01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {

	private MemberDao() {}
	private static MemberDao itc = new MemberDao();
	public static MemberDao getInstance() {return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<MemberDto> selectMember(){
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		con=DBManager.getConnection();
		String sql= "select memberlist.*, date_format(birth, '%Y%m%d') as bd, date_format(joindate, '%Y%m%d') as jd"
				+ " from memberlist order by membernum desc";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberDto mdto = new MemberDto();
				mdto.setMembernum(rs.getInt("membernum"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setBirth(rs.getString("bd"));
				mdto.setBpoint(rs.getInt("bpoint"));
				mdto.setJoindate(rs.getString("jd"));
				mdto.setGender(rs.getString("gender"));
				mdto.setAge(rs.getInt("age"));
				list.add(mdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {DBManager.close(con, pstmt, rs);}
		return list;
	}

	public int insertRent(MemberDto mdto) {
		// TODO Auto-generated method stub
		return 0;
	}
}
