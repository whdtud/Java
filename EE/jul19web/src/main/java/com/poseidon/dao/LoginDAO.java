package com.poseidon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.poseidon.db.DBConnection;
import com.poseidon.util.Util;

public class LoginDAO {
	private LoginDAO() {
	}

	private static LoginDAO instance = new LoginDAO();

	public static LoginDAO getInstance() {
		return instance;
	}

	public HashMap<String, Object> login(String id, String pw) {
		HashMap<String, Object> login = null;
		Connection conn = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT id, name, grade FROM login WHERE pw=? AND id=? AND grade > 4";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, id);// 감사합니다 ㅠㅠ
			rs = pstmt.executeQuery();
			if (rs.next()) {
				login = new HashMap<String, Object>();
				login.put("id", rs.getString("id"));
				login.put("name", rs.getString("name"));
				// 등급 추가
				login.put("grade", rs.getInt("grade"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.closeAll(rs, pstmt, conn);
		}
		return login;
	}

}
