package com.poseidon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import com.poseidon.db.DBConnection;
import com.poseidon.util.Util;
public class CommentDAO {
	//외부에서 생성을 못하도록 Default생성자는 private으로 선언합니다. 
	private CommentDAO() { }
	//싱글턴 패턴으로 변경해보았습니다. DBConnection과 그 형태가 같습니다 
	private static CommentDAO instance = new CommentDAO();
	//객체 가져오기는 아래와 같이 합니다.
	public static CommentDAO getInstance() {
		return instance;
	}
	
	public int commentInput(HashMap<String, Object> map) {
		int result = 0;
		Connection con = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO freecomment (fccontent, fno, no) "
				+ "VALUES (?, ?, (SELECT no FROM login WHERE id=?))";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, (String) map.get("content"));
			pstmt.setInt(2, (int) map.get("fno"));
			pstmt.setString(3, (String) map.get("id"));
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.closeAll(null, pstmt, con);
		}
		
		return result;
	}

}