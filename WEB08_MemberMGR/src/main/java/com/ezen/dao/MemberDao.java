package com.ezen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezen.dto.MemberDto;
import com.ezen.util.Dbman;

public class MemberDao {

	private MemberDao() {}
	private static MemberDao itc = new MemberDao();
	public static MemberDao getInstance() {return itc;}
	
	Connection con=null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	public MemberDto getMember(String userid) {
		MemberDto mdto=null;
		con=Dbman.getConnection();
		String sql = "select * from member where userid=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs=pstmt.executeQuery();
			if((rs.next())) {
				mdto= new MemberDto();
				mdto.setUserid(rs.getString("userid"));
				mdto.setPwd(rs.getString("pwd"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setEmail(rs.getString("email"));
				mdto.setAdmin(rs.getInt("admin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbman.close(con, pstmt, rs);
		}
		return mdto;
	}
	public int insertMember(MemberDto mdto) {
		int result=0;
		con=Dbman.getConnection();
		String sql="insert into member(userid, name, pwd, phone, email, admin) values(?,?,?,?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,mdto.getUserid());
			pstmt.setString(2,mdto.getName());
			pstmt.setString(3,mdto.getPwd());
			pstmt.setString(4,mdto.getPhone());
			pstmt.setString(5,mdto.getEmail());
			pstmt.setInt(6,mdto.getAdmin());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		return result;
	}
	public ArrayList<MemberDto> selectMember() {
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		con=Dbman.getConnection();
		String sql= "select * from member";
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberDto mdto=new MemberDto();
				mdto.setUserid(rs.getString("userid"));
				mdto.setName(rs.getString("name"));
				mdto.setPwd(rs.getString("pwd"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setEmail(rs.getString("email"));
				mdto.setAdmin(rs.getInt("admin"));
				list.add(mdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		return list;
	}
	public int updateMember(MemberDto mdto) {
		int result=0;
		String sql="update member set name=?, pwd=?, phone=?, email=?, admin=? where userid=?";
		con=Dbman.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, mdto.getName());
			pstmt.setString(2, mdto.getPwd());
			pstmt.setString(3, mdto.getPhone());
			pstmt.setString(4, mdto.getEmail());
			pstmt.setInt(5, mdto.getAdmin());
			pstmt.setString(6, mdto.getUserid());
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		return result;
	}
	public int deleteMember(String userid) {
		int result=0;
		con=Dbman.getConnection();
		String sql="delete from member where userid=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		
		return result;
	}
	public void editAdmin(String userid, String admin) {

		con=Dbman.getConnection();
		String sql="update member set admin=? where userid=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(admin));
			pstmt.setString(2, userid);
			pstmt.executeUpdate();
		}catch(SQLException e) {e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
	}
	
}
