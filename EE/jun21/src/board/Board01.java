package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class DBConn {
	
	private static DBConn instance;
	
	public static DBConn getInstance() {
		if (instance == null)
			instance = new DBConn();
		return instance;
	}
	
	private DBConn() {}
	
	public static Connection getConn() {
		Connection conn = null;
		
		try {
			//Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://220.70.33.29:3306";
			conn = DriverManager.getConnection(url, "whdtud", "01234567");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}

public class Board01 {
	
	public static void main(String[] args) {

		Board01 board01 = new Board01();
		
		ArrayList<Map<String, Object>> list = board01.list();
		
		for (Map<String, Object> map : list) {
			int bno = (int)map.get("bno");
			String btitle = (String)map.get("btitle");
			String bdate = (String)map.get("bdate");
			int bcount = (int)map.get("bcount");
			String name = (String)map.get("name");
			String id = (String)map.get("id");
			
			System.out.printf("%d %s %s %d %s %s\n", bno, btitle, bdate, bcount, name, id);
		}
	}
	
	public ArrayList<Map<String, Object>> list() {
		ArrayList<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		Connection conn = DBConn.getConn();
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM whdtud.boardview";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("bno", rs.getInt("bno"));
				map.put("btitle", rs.getString("btitle"));
				map.put("bdate", rs.getString("bdate"));
				map.put("bcount", rs.getInt("bcount"));
				map.put("name", rs.getString("name"));
				map.put("id", rs.getString("id"));
				
				list.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public void select() {
		Connection conn = DBConn.getConn();
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM boardview";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int bno = rs.getInt("bno");
				String btitle = rs.getString("btitle");
				String bdate = rs.getString("bdate");
				int bcount = rs.getInt("bcount");
				String name = rs.getString("name");
				String id = rs.getString("id");
				
				System.out.printf("%d %s %s %d %s %s", bno, btitle, bdate, bcount, name, id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
