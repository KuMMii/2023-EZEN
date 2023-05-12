package com.ezen.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezen.shop.dto.QnaVO;
import com.ezen.shop.util.Dbman;

public class QnaDao {

	private QnaDao() {}
	private static QnaDao itc=new QnaDao();
	public static QnaDao getInstance() {return itc;}
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	public ArrayList<QnaVO> selectQna() {
		ArrayList<QnaVO> list=new ArrayList<QnaVO>();
		con=Dbman.getConnection();
		String sql="select * from qna order by qseq desc";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				QnaVO qvo=new QnaVO();
				qvo.setQseq(rs.getInt("qseq"));
				qvo.setSubject(rs.getString("subject"));
				qvo.setContent(rs.getString("content"));
				qvo.setId(rs.getString("id"));
				qvo.setIndate(rs.getTimestamp("indate"));
				qvo.setReply(rs.getString("reply"));
				qvo.setRep(rs.getString("rep"));
				list.add(qvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {Dbman.close(con, pstmt, rs);}
		return list;
	}
}
