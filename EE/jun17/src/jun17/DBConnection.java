package jun17;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private final String url = "jdbc:mariadb://220.70.33.29:3306/whdtud";
	private final String id = "whdtud";
	private final String pw = "01234567";
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
