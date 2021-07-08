package com.poseidon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.poseidon.db.DBConnection;
import com.poseidon.dto.BoardDTO;

public class BoardDAO {
	public BoardDTO detail(int bno) {
		BoardDTO dto = new BoardDTO();

		// DBConnection db = new DBConnection();
		Connection conn = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String detail = "SELECT * FROM boardview WHERE bno=?";
		
		countUp(bno);// 여기에서 +1시키기
		try {
			pstmt = conn.prepareStatement(detail);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto.setBno(rs.getInt("bno"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBcontent(rs.getString("bcontent"));
				dto.setBdate(rs.getString("bdate2"));
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setBcount(rs.getInt("bcount"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return dto;
	}

	private void countUp(int bno) {
		Connection conn = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		String sql = "UPDATE board SET bcount=bcount+1 WHERE bno=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);// 아래서 만든거 호출
		}

	}

	// 닫다가 지쳐서 만들었어요.
	private void closeAll(ResultSet rs, PreparedStatement pstmt,
													Connection conn) {
		try {
			if (rs != null) {rs.close();}
			if (pstmt != null) {pstmt.close();}
			if (conn != null) {conn.close();}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<BoardDTO> list() {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		// DBConnection db = new DBConnection();
		Connection conn = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		String query = "SELECT * FROM boardview";
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBdate(rs.getString("bdate"));
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setBcount(rs.getInt("bcount"));
				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// 글쓰기 2021-07-06
	public void insert(BoardDTO dto) {
		// conn객체 생성 pstmt
		Connection conn = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO board (btitle, bcontent, no) " + "VALUES (?, ?, (SELECT no FROM login WHERE id=?))";
		// 우리가 받은 값은 ID인데 데이터베이스에는 no를 저장해야 함.
		// 서브쿼리로 돌려서 no를 뽑아 저장시킵니다.
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBcontent());
			pstmt.setString(3, dto.getId());
			int count = pstmt.executeUpdate();
			System.out.println(count + "개 행이 영향을 받았습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public int delete(int bno, String id) {
		int result = 0;
		Connection conn = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM board WHERE bno=? " + "AND no=(SELECT no FROM login WHERE id=?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
			System.out.println(result + " !!!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public BoardDTO update(int bno, String id) {
		BoardDTO dto = null;
		// conn = dbConn()
		Connection conn = DBConnection.dbConn();
		// pstmt
		PreparedStatement pstmt = null;
		// resultSet
		ResultSet rs = null;
		// sql detail과 흡사하지만 +no가 들어갑니다
		String sql = "SELECT * FROM board WHERE bno=? AND no=(SELECT no FROM login WHERE id=?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto = new BoardDTO();
				dto.setBno(rs.getInt("bno"));// 수정한 자신의 글로 돌아가기위해
				dto.setBtitle(rs.getString("btitle"));
				dto.setBcontent(rs.getString("bcontent"));
				// dto.setId(rs.getString("id"));//없어도 되겠지만 가져갑니다
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}

		return dto;
	}

	public void update2(BoardDTO dto) {
		Connection conn = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		String sql = "UPDATE board SET btitle=?, bcontent=? " + "WHERE bno=? AND no=(SELECT no FROM login WHERE id=?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBcontent());
			pstmt.setInt(3, dto.getBno());
			pstmt.setString(4, dto.getId());
			pstmt.execute();// select제외한 나머지
			// pstmt.executeQuery(); //select
			// pstmt.executeUpdate(); //영향받은 행이 몇 개? 리턴타입 int

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
