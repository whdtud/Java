package com.poseidon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.poseidon.dto.LoginDTO;
import com.poseidon.web.DBConnection;

public class LoginDAO {
	//��ȯ�� �ִ� �޼ҵ�� �����մϴ�.
	public int join(LoginDTO dto) {
		//conn - �����ͺ��̽� ����
		DBConnection dbc = new DBConnection();
		Connection conn = dbc.dbConn();
		//pstmt
		PreparedStatement pstmt = null;
		//rs �����
		//ResultSet rs = null;
		//query
		String query = "INSERT INTO login (id, name, pw, email) "
				+ "VALUES (?, ?, ?, ?)";
		int count = 0;
		try {
			//pstmt ?�� �ֱ�
			pstmt = conn.prepareStatement(query);			
			//�� �ֱ�
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPw());
			pstmt.setString(4, dto.getEmail());
			
			//����
			count = pstmt.executeUpdate();
			//rs�� �������� ������, �̰ɷ� �غ��ڽ��ϴ�.
			//������� ���ڷ� �Ѱ��ݴϴ�.
			//����� row���� ǥ�����ݴϴ�.
			//execute() = ��� ���� boolean���� ���ɴϴ�.
			System.out.print(count + "�� ����");
			
		} catch (SQLException e) {
			e.printStackTrace();
		//���̳θ��� ���ּ���.
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;//������ ������ �������ּ���.		
	}
	
	
	public LoginDTO login(LoginDTO dto) {
		LoginDTO login = new LoginDTO();

		// conn, pstmt, rs, query
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return login;
	}
}
