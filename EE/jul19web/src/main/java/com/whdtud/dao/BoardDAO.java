package com.whdtud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.whdtud.db.DBConnection;

public class BoardDAO {
	
	public ArrayList<HashMap<String, Object>> boardList() {
		ArrayList<HashMap<String, Object>> boardList = new ArrayList<HashMap<String,Object>>();

		Connection conn = DBConnection.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM freeview";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				HashMap<String, Object> row = new HashMap<String, Object>();
				row.put("no", rs.getString("no"));
				row.put("content", rs.getString("content"));
				row.put("date", rs.getString("date"));
				row.put("count", rs.getInt("count"));
				row.put("ip", rs.getString("ip"));
				row.put("lno", rs.getInt("lno"));
				boardList.add(row);
			}
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
		
		return boardList;
	}
}
