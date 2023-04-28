package com.ezen.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dbman {
	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String url="jdbc:oracle:thin:@localhost:1521:xe";
	static String id="scott";
	static String pwd="tiger";
	
	public static Connection getConnection() {
		Connection con=null;
			try {
				Class.forName(driver);
				con=DriverManager.getConnection(url,id, pwd);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}return con;
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if(rs!=null)
			try {
				rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
