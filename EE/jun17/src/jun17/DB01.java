package jun17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB01 {
	
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		String server = "jdbc:mariadb://220.70.33.29:3306/poseidon";
		String id = "poseidon";
		String pw = "01234567";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(server, id, pw);
			stmt = conn.createStatement();
			System.out.println("접속 성공");
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			System.out.println("드라이버가 없습니다.");
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("접속 정보 및 SQL문제가 있습니다.");
		} finally {
			// 닫아주기 : 가장 나중에 연 것 부터 닫기
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
