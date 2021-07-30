package com.whdtud.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static Connection conn;
	public static Connection getConn() {
		if (conn == null) {
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				String url = "jdbc:mariadb://220.70.33.29:3306/whdtud";
				String id = "whdtud";
				String pw = "01234567";
				conn = DriverManager.getConnection(url,id,pw);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	private DBConnection() {}
}
