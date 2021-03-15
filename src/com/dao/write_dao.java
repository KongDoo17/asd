package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class write_dao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	int result = 0;
	ResultSet rs = null;

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String url = "jdbc:mysql://58.235.52.224:3306/asd?useUnicode=true&characterEncoding=utf8";
		String dbid = "asd";
		String dbpw = "1234";
		try {
			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	public void freeConnection(Connection c, PreparedStatement ps, ResultSet r) {

		try {
			if (c != null) {
				c.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (r != null) {
				r.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void freeConnection(Connection c, PreparedStatement ps) {

		try {
			if (c != null) {
				c.close();
			}
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public int insertRow(String title, String contents , String category, String writer) {
		
		SimpleDateFormat datef = new SimpleDateFormat ( "yyyy-MM-dd");
		SimpleDateFormat timef = new SimpleDateFormat ( "HH:mm:ss");
		Date time = new Date();
		
		try {
			conn = getConnection();
			String sql = "insert into "+category+" values (null,?,?,?,?,?,default,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, contents);
			pstmt.setString(3, writer);
			pstmt.setString(4, datef.format(time));
			pstmt.setString(5, timef.format(time));
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			freeConnection(conn, pstmt);
		}

		return result;
	}
	
	public int insertTrade(String title, String contents , String category, String writer) {
		
		SimpleDateFormat datef = new SimpleDateFormat ( "yyyy-MM-dd");
		SimpleDateFormat timef = new SimpleDateFormat ( "HH:mm:ss");
		Date time = new Date();
		
		
		try {
			conn = getConnection();
			String sql = "insert into "+category+" values (null,?,?,?,?,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, contents);
			pstmt.setString(3, writer);
			pstmt.setString(4, datef.format(time));
			pstmt.setString(5, timef.format(time));
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			freeConnection(conn, pstmt);
		}

		return result;
	}
	
	public int insertUnknown(String title, String contents , String category, String writer) {
		
		SimpleDateFormat datef = new SimpleDateFormat ( "yyyy-MM-dd");
		SimpleDateFormat timef = new SimpleDateFormat ( "HH:mm:ss");
		Date time = new Date();
		
		try {
			conn = getConnection();
			String sql = "insert into "+category+" values (null,?,?,?,?,?,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, contents);
			pstmt.setString(3, writer);
			pstmt.setString(4, datef.format(time));
			pstmt.setString(5, timef.format(time));
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			freeConnection(conn, pstmt);
		}

		return result;
	}
	
}
