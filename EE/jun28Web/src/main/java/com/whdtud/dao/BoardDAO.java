package com.whdtud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.whdtud.dto.BoardDTO;
import com.whdtud.web.DBConnection;

public class BoardDAO {
	
	public ArrayList<BoardDTO> list() {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		Connection conn = DBConnection.getConn();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM boardview";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("bno"));
				dto.setTitle(rs.getString("btitle"));
				dto.setName(rs.getString("name"));
				dto.setDate(rs.getString("bdate"));
				dto.setCount(rs.getInt("bcount"));
				dto.setId(rs.getString("id"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		return list;
	}
}
