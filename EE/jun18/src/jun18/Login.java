package jun18;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		String id, pw, query, name = null;
		
		System.out.println("아이디를 입력하세요.");
		id = sc.next();
		
		System.out.println("비밀번호를 입력하세요.");
		pw = sc.next();
		
		conn = DBConnection.getConn();
		
		query = String.format("SELECT name FROM login WHERE id='%s' AND pw='%s'", id, pw);
		ArrayList<String> list = executeQuery(query);
		System.out.println("이름은 " + list.get(0) + "입니다.");

		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sc.close();
	}
	
	public static ArrayList<String> executeQuery(String sql) {
		ArrayList<String> list = new ArrayList<String>();

		Connection conn = DBConnection.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				list.add(rs.getString("name"));
			} else {
				list.add("UNKNOWN");
			}
			
		} catch (Exception e) {
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
