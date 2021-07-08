package com.poseidon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.poseidon.db.DBConnection;
import com.poseidon.dto.LoginDTO;

public class LoginDAO {
	public LoginDTO login(LoginDTO dto) {
		LoginDTO login = new LoginDTO();
		DBConnection dbc = new DBConnection();
		Connection conn = dbc.dbConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM login WHERE id=? AND pw=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				login.setNo(rs.getInt("no"));
				login.setName(rs.getString("name"));
				login.setId(rs.getString("id"));
				login.setPw(rs.getString("pw"));
				login.setEmail(rs.getString("email"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return login;
	}
	//가입하기
	public int join(LoginDTO dto) {
		int count = 0;
		
		//conn
		Connection conn = DBConnection.dbConn();
		//pstmt
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO login (name, id, pw, email) VALUES (?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPw());
			pstmt.setString(4, dto.getEmail());
			
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return count;
	}
	
	
	
	
	
	
	
	
	
}