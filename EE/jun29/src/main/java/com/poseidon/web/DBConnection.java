package com.poseidon.web;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public Connection dbConn() {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://220.70.33.29:3306/poseidon";
			String id = "poseidon";
			String pw = "01234567";
			conn = DriverManager.getConnection(url,id,pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
