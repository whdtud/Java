package jun17;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class DB05 {
	
	public static void main(String[] args) {

		ArrayList<String> list = executeQuery("SELECT * FROM member LIMIT 10;");
		for (int i = 0; i < list.size(); i++) {
			String name = list.get(i);
			System.out.println((i + 1) + "." + name);
		}
		
		System.out.println("삭제할 번호를 입력하세요.");
		
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		executeQuery("DELETE FROM whdtud.member WHERE no=" + input + ";");
		
		sc.close();
	}
	
	public static ArrayList<String> executeQuery(String sql) {
		Connection conn = null;
		
		DBConnection dbc = new DBConnection();
		conn = dbc.getConnection();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				list.add(rs.getString("name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
