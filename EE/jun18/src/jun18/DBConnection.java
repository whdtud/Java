package jun18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection conn; 
	public static Connection getConn() {
		if (conn == null) {
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				String url = "jdbc:mariadb://127.0.0.1:3306/joongang";
				conn = DriverManager.getConnection(url, "root", "whdtjd2");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return conn;
	}
	
	private DBConnection() {}
}
