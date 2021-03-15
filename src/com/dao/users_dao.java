package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.dto.users_dto;

public class users_dao {
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

	public Vector<users_dto> selectAll() {
		Vector<users_dto> v = new Vector<>();
		try {
			conn = getConnection();
			String sql = "select * from users";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				users_dto dto = new users_dto();
				dto.setIdx(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setPw(rs.getString(3));
				dto.setName(rs.getString(4));
				dto.setAddress(rs.getString(5));
				dto.setPhone(rs.getString(6));
				v.add(dto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			freeConnection(conn, pstmt, rs);
		}
		return v;
	}

	public int deleteRow(String idx) { // 占쎈땾占쎌젟 占쎈툡占쎌뒄
		try {
			conn = getConnection();
			String sql = "delete from users where idx = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(idx));
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			freeConnection(conn, pstmt);
		}

		return result;
	}

	public int insertRow(String id, String pw, String name, String address, String phone) {
		try {
			conn = getConnection();
			String sql = "insert into users values (null, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, address);
			pstmt.setString(5, phone);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			freeConnection(conn, pstmt);
		}

		return result;
	}

	public int updateRow(String idx, String id, String pw, String name, String address, String phone) {

		// �뜝�룞�삕�뜝�룞�삕�뜝�뙗�눦�삕

		try {
			conn = getConnection();
			String sql = "update users set id = ?, pw = ?, name = ?,"
					+ " address = ?, phone = ? where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, address);
			pstmt.setString(5, phone);
			pstmt.setInt(6, Integer.parseInt(idx));

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			freeConnection(conn, pstmt);
		}

		return result;
	}
	


	public users_dto selectOne_idx(String idx) {
		users_dto dto = new users_dto();

		try {
			conn = getConnection();
			String sql = "select * from member3 where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(idx));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setIdx(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setPw(rs.getString(3));
				dto.setName(rs.getString(4));
				dto.setAddress(rs.getString(5));
				dto.setPhone(rs.getString(6));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			freeConnection(conn, pstmt, rs);
		}

		return dto;
	}
	
	public users_dto selectOne(String id) {
		users_dto dto = new users_dto();

		try {
			conn = getConnection();
			String sql = "select * from users where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}
	
	public boolean loginCheck(String id, String pw) {
		boolean result = false;
		try {
			conn = getConnection();
			String sql = "select * from users where id = ? and pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	   public int idChk(String id){		
			try {
				conn = getConnection();
				String sql = "select count(*) from users where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()){
					result = rs.getInt(1);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				freeConnection(conn, pstmt, rs);
			}		
			
			return result;
		}
}
