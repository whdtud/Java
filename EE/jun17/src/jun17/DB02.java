package jun17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB02 {
	
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
			//ResultSet rs = stmt.executeQuery("SHOW DATABASES;");
			//ResultSet rs = stmt.executeQuery("SHOW TABLES;");
			ResultSet rs = stmt.executeQuery("SELECT * FROM member;");
			
			/* stmt.execute(); 결과값이 필요 없을 때 사용 (수정, 삭제, 삽입)
			 * 
			 * stmt.excuteQuery(); = 결과값이 필요할 때 사용
			 */
			
			while (rs.next()) {
				String result = rs.getString(1);
				System.out.println(result);
			}
			
			rs.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
