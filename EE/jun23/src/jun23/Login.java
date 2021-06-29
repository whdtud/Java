package jun23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class DBConn {
	
	private static DBConn instance;
	
	public static DBConn getInstance() {
		if (instance == null)
			instance = new DBConn();
		return instance;
	}
	
	private DBConn() {}
	
	public Connection getConn() {
		Connection conn = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://220.70.33.29:3306";
			conn = DriverManager.getConnection(url, "whdtud", "01234567");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}

public class Login {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("아이디를 입력하세요.");
		String id = sc.next();
		System.out.println("비밀번호를 입력하세요.");
		String pw = sc.next();
		
		ArrayList<LoginDTO> list = select(id, pw);

		for (LoginDTO loginDTO : list) {
			System.out.println(loginDTO); 
		}

		sc.close();
	}
	
	public static ArrayList<LoginDTO> select(String id, String pw) {
		Connection conn = DBConn.getInstance().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<LoginDTO> list = new ArrayList<LoginDTO>();
		String sql = "SELECT * FROM whdtud.login WHERE id=? AND pw=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				LoginDTO dto = new LoginDTO();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setEmail(rs.getString("email"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
}
