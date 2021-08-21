package com.poseidon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.poseidon.db.DBConnection;
import com.poseidon.util.Util;

public class LogDAO {
	private LogDAO() {
	}

	private static LogDAO instance = new LogDAO();

	public static LogDAO getInstance() {
		return instance;
	}

	public static void insertLog(HashMap<String, Object> dto) {
		Connection conn = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO log (log_ip, log_target, log_id, log_etc) " + "VALUES (?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, (String) dto.get("ip"));
			pstmt.setString(2, (String) dto.get("target"));
			pstmt.setString(3, (String) dto.get("id"));
			pstmt.setString(4, (String) dto.get("etc"));
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.closeAll(null, pstmt, conn);
		}

	}

	public ArrayList<HashMap<String, Object>> logList(int page) {
		ArrayList<HashMap<String, Object>> list = null;
		Connection con = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM logview limit ?, 20";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, page);
			rs = pstmt.executeQuery();
			if (rs != null) {
				list = new ArrayList<HashMap<String, Object>>();
				while (rs.next()) {
					/* log_no log_ip log_date log_target log_id log_etc */
					HashMap<String, Object> map = new HashMap<String, Object>();
					// totalcount는 없으니 view로 만들어주세요.
					map.put("totalcount", rs.getInt("totalcount"));
					map.put("log_no", rs.getInt("log_no"));
					map.put("log_ip", rs.getString("log_ip"));
					map.put("log_date", rs.getString("log_date"));
					map.put("log_target", rs.getString("log_target"));
					map.put("log_id", rs.getString("log_id"));
					map.put("log_etc", rs.getString("log_etc"));
					list.add(map);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<String> list(String name) {
		ArrayList<String> list = null;
		Connection con = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT DISTINCT " + name + " FROM logview";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs != null) {
				list = new ArrayList<String>();
				while (rs.next()) {
					list.add(rs.getString(name));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<HashMap<String, Object>> selectIP(String ip, int i) {
		ArrayList<HashMap<String, Object>> list = null;
		Connection con = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT "
				+ "(SELECT count(*) FROM log WHERE log_ip=?) as totalcount,"
				+ " log_no, log_ip, log_date, log_target, log_id, log_etc"
				+ " FROM log WHERE log_ip=? limit ?, 20 ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ip);
			pstmt.setString(2, ip);
			pstmt.setInt(3, i);
			rs = pstmt.executeQuery();
			if (rs != null) {
				list = new ArrayList<HashMap<String, Object>>();
				while (rs.next()) {
					/* log_no log_ip log_date log_target log_id log_etc */
					HashMap<String, Object> map = new HashMap<String, Object>();
					// totalcount는 없으니 view로 만들어주세요.
					map.put("totalcount", rs.getInt("totalcount"));
					map.put("log_no", rs.getInt("log_no"));
					map.put("log_ip", rs.getString("log_ip"));
					map.put("log_date", rs.getString("log_date"));
					map.put("log_target", rs.getString("log_target"));
					map.put("log_id", rs.getString("log_id"));
					map.put("log_etc", rs.getString("log_etc"));
					list.add(map);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<HashMap<String, Object>> selectTarget(String target, int i) {
		ArrayList<HashMap<String, Object>> list = null;
		Connection con = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT "
				+ "(SELECT count(*) FROM log WHERE log_target=?) as totalcount, "
				+ "log_no, log_ip, log_date, log_id, log_etc, log_target "
				+ "FROM logview WHERE log_target=? limit ?, 20 ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, target);
			pstmt.setString(2, target);
			pstmt.setInt(3, i);
			rs = pstmt.executeQuery();
			if (rs != null) {
				list = new ArrayList<HashMap<String, Object>>();
				while (rs.next()) {
					/* log_no log_ip log_date log_target log_id log_etc */
					HashMap<String, Object> map = new HashMap<String, Object>();
					// totalcount는 없으니 view로 만들어주세요.
					map.put("totalcount", rs.getInt("totalcount"));
					map.put("log_no", rs.getInt("log_no"));
					map.put("log_ip", rs.getString("log_ip"));
					map.put("log_date", rs.getString("log_date"));
					map.put("log_target", rs.getString("log_target"));
					map.put("log_id", rs.getString("log_id"));
					map.put("log_etc", rs.getString("log_etc"));
					list.add(map);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<HashMap<String, Object>> selectIpTarget(String ip, String target, int i) {
		ArrayList<HashMap<String, Object>> list = null;
		Connection con = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT "
				+ "(SELECT count(*) FROM log WHERE log_target=? AND log_ip=?) "
				+ "as totalcount, "
				+ "log_no, log_ip, log_date, log_id, log_etc, log_target "
				+ "FROM logview WHERE log_target=? AND log_ip=? limit ?, 20 ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, target);
			pstmt.setString(2, ip);
			pstmt.setString(3, target);
			pstmt.setString(4, ip);
			pstmt.setInt(5, i);
			rs = pstmt.executeQuery();
			if (rs != null) {
				list = new ArrayList<HashMap<String, Object>>();
				while (rs.next()) {
					/* log_no log_ip log_date log_target log_id log_etc */
					HashMap<String, Object> map = new HashMap<String, Object>();
					// totalcount는 없으니 view로 만들어주세요.
					map.put("totalcount", rs.getInt("totalcount"));
					map.put("log_no", rs.getInt("log_no"));
					map.put("log_ip", rs.getString("log_ip"));
					map.put("log_date", rs.getString("log_date"));
					map.put("log_target", rs.getString("log_target"));
					map.put("log_id", rs.getString("log_id"));
					map.put("log_etc", rs.getString("log_etc"));
					list.add(map);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<HashMap<String, Object>> search(String searchName, String search, int page) {
		ArrayList<HashMap<String, Object>> list = null;
		Connection con = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT (SELECT count(*) FROM log WHERE log_"
					+searchName
					+" LIKE CONCAT('%',?,'%')) as totalcount, "
					+"log_no, log_ip, log_date, log_id, log_etc, log_target "
					+"FROM log WHERE log_"+searchName
					+" LIKE CONCAT('%',?,'%') limit ?, 20";
		//System.out.println(sql);
		//SELECT * FROM logview WHERE log_ip LIKE CONCAT('%',?,'%')
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, search);
			pstmt.setInt(3, page);
			rs = pstmt.executeQuery();
			System.out.println(pstmt);
//sql : 'SELECT (SELECT count(*) FROM log WHERE log_ip LIKE CONCAT('%',?,'%')) as totalcount, log_no, log_ip, log_date, log_id, log_etc, log_target FROM log WHERE log_ip LIKE CONCAT('%',?,'%') limit ?, 10', parameters : ['222','222',1]

			if(rs != null) {
				list = new ArrayList<HashMap<String, Object>>();
				while (rs.next()) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("totalcount", rs.getInt("totalcount"));
					map.put("log_no", rs.getInt("log_no"));
					map.put("log_ip", rs.getString("log_ip"));
					map.put("log_date", rs.getString("log_date"));
					map.put("log_target", rs.getString("log_target"));
					map.put("log_id", rs.getString("log_id"));
					map.put("log_etc", rs.getString("log_etc"));
					list.add(map);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.closeAll(rs, pstmt, con);
		}
		return list;
	}

	public ArrayList<HashMap<String, Object>> memberList(int page) {
		ArrayList<HashMap<String, Object>> list = null;
		Connection con = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT (SELECT COUNT(*) FROM login) AS totalcount, "
				+ "l.* FROM login l LIMIT ?, 20";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, page);
			rs = pstmt.executeQuery();
			if (rs != null) {
				list = new ArrayList<HashMap<String, Object>>();
				while (rs.next()) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("totalcount", rs.getInt("totalcount"));
					map.put("no", rs.getInt("no"));
					map.put("id", rs.getString("id"));
					map.put("name", rs.getString("name"));
					map.put("pw", rs.getString("pw"));
					map.put("email", rs.getString("email"));
					map.put("joindate", rs.getString("joindate"));
					map.put("birthdate", rs.getString("birthdate"));
					map.put("grade", rs.getInt("grade"));
					list.add(map);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}