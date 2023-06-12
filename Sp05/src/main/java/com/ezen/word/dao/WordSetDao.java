package com.ezen.word.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.ezen.word.dto.WordSet;
import com.ezen.word.util.DataBaseManager;

public class WordSetDao {

	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	@Autowired
	DataBaseManager dbm;

	/*
	public WordSetDao(DataBaseManager dbm) {
		this.dbm=dbm;
	}
	 */

	public void insertWord(WordSet wordSet) {

		String sql="insert into wordSet values(?,?)";
		con=dbm.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, wordSet.getWordKey());
			pstmt.setString(2, wordSet.getWordValue());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {dbm.close(con, pstmt, rs);}
	}


	public ArrayList<WordSet> selectAllWord() {
		ArrayList<WordSet> list=new ArrayList<WordSet>();
		WordSet ws=null;
		String sql="select * from wordSet";
		con=dbm.getConnection();
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ws=new WordSet(
					rs.getString("wordKey"),
					rs.getString("wordValue")
				);
				list.add(ws);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {dbm.close(con, pstmt, rs);}
		return list;
	}


	public WordSet searchWordSet(String input) {
		WordSet ws=null;
		con=dbm.getConnection();
		String sql="select * from wordSet where wordKey=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, input);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				ws=new WordSet(
						rs.getString("wordKey"),
						rs.getString("wordValue")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {dbm.close(con, pstmt, rs);}
		return ws;
	}
	
}
