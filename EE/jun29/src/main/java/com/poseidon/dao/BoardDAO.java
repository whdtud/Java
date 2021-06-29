package com.poseidon.dao;
//데이터베이스와 접속해서 일하는 DAO

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//데이터베이스와 관련된 모든 일을 여기서 처리합니다.
//conn

import java.util.ArrayList;
import com.poseidon.dto.BoardDTO;
import com.poseidon.web.DBConnection;

public class BoardDAO {
	public BoardDTO detail(int bno) {
		BoardDTO dto = new BoardDTO();// dto에 bcontent 추가해주겠습니다.

		// connection
		DBConnection db = new DBConnection();
		Connection conn = db.dbConn();
		// pstmt
		PreparedStatement pstmt = null;
		// resultSet
		ResultSet rs = null;
		// sql
		String detail = "SELECT * FROM boardview WHERE bno=?";
		// 쿼리문 만들어주세요

		try {
			pstmt = conn.prepareStatement(detail);
			// ?에 값 넣어주기(위치, 값)
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
				list.add(dto);// 붙여넣기
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
}
