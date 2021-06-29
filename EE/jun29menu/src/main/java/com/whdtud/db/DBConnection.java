package com.whdtud.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static Connection conn;

	public static Connection getConn() {
		if (conn == null) {
			String url = "jdbc:mariadb://220.70.33.29:3306";
			String id = "whdtud";
			String pw = "01234567";

			try {
				Class.forName("org.mariadb.jdbc.Driver");
				conn = DriverManager.getConnection(url, id, pw);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return conn;
	}
}
