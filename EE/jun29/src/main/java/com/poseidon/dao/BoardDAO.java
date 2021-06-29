package com.poseidon.dao;
//�����ͺ��̽��� �����ؼ� ���ϴ� DAO

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//�����ͺ��̽��� ���õ� ��� ���� ���⼭ ó���մϴ�.
//conn

import java.util.ArrayList;
import com.poseidon.dto.BoardDTO;
import com.poseidon.web.DBConnection;

public class BoardDAO {
	public BoardDTO detail(int bno) {
		BoardDTO dto = new BoardDTO();// dto�� bcontent �߰����ְڽ��ϴ�.

		// connection
		DBConnection db = new DBConnection();
		Connection conn = db.dbConn();
		// pstmt
		PreparedStatement pstmt = null;
		// resultSet
		ResultSet rs = null;
		// sql
		String detail = "SELECT * FROM boardview WHERE bno=?";
		// ������ ������ּ���

		try {
			pstmt = conn.prepareStatement(detail);
			// ?�� �� �־��ֱ�(��ġ, ��)
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto.setBno(rs.getInt("bno"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBcontent(rs.getString("bcontent"));
				dto.setBdate(rs.getString("bdate2"));
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setBcount(rs.getInt("bcount"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	public ArrayList<BoardDTO> list() {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		DBConnection db = new DBConnection();
		Connection conn = db.dbConn();
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM boardview";
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBdate(rs.getString("bdate"));
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setBcount(rs.getInt("bcount"));
				list.add(dto);// �ٿ��ֱ�
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
}
