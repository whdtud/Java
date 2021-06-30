package com.whdtud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.whdtud.dto.LoginDTO;
import com.whdtud.web.DBConnection;

public class LoginDAO {

	public LoginDTO join(LoginDTO dto) {
		Connection conn = DBConnection.getConn();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO login (id, name, pw, email) VALUES (?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPw());
			pstmt.setString(4, dto.getEmail());

			int count = pstmt.executeUpdate();
			if (count <= 0){
				dto = null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			dto = null;
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}
	
	public LoginDTO login(LoginDTO dto) {
		Connection conn = DBConnection.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT id, pw FROM login WHERE name=? pw=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			
			rs = pstmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}
}
