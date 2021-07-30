package com.poseidon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.poseidon.db.DBConnection;
import com.poseidon.util.Util;

public class GalleryDAO {
//싱글턴을 바꿔주세요.
	//생성자를 외부에서 못 보게 ***로 숨겨주세요.
	private GalleryDAO() {}
	
	//단 하나의 객체 생성해주기 = ***** 붙여서 클래스 변수로 만들기
	private static GalleryDAO galleryDAO = new GalleryDAO();
	
	//생성된 객체 가져오기 = getInstance()입니다.
	public static GalleryDAO getInstance() {
		return galleryDAO;
	}
	//그 후 아래 실제 코드 작성하기
	public ArrayList<HashMap<String, Object>> galleryList(int page){
		ArrayList<HashMap<String, Object>> galleryList = null;
		//conn
		Connection con = null;
		con = DBConnection.dbConn();
		//pstmt
		PreparedStatement pstmt = null;
		//rs
		ResultSet rs = null;
		//sql
		String sql = "SELECT * FROM galleryview LIMIT ?, 5;";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, page);
			rs = pstmt.executeQuery();
			if(rs != null) {				
				galleryList = new ArrayList<HashMap<String,Object>>();
				while (rs.next()) {
					HashMap<String,Object> map = new HashMap<String, Object>();
					map.put("totalcount", rs.getInt("totalcount"));
					map.put("gno", rs.getInt("gno"));
					map.put("gtitle", rs.getString("gtitle"));
					map.put("gdate", rs.getString("gdate"));
					map.put("gthumbnail", rs.getString("gthumbnail"));
					map.put("gcount", rs.getInt("gcount"));
					map.put("id", rs.getString("id"));
					map.put("name", rs.getString("name"));
					galleryList.add(map);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.closeAll(rs, pstmt, con);
		}
		return galleryList;
	}
	public int galleryWrite(HashMap<String, Object> map) {
		int result = 0;
		Connection con = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO gallery (gtitle, gcontent, gfilename, gthumbnail, no)"
				+ " VALUES(?, ?, ?, ?, (SELECT no FROM login WHERE id=?))";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, (String) map.get("title"));
			pstmt.setString(2, (String) map.get("content"));
			pstmt.setString(3, (String) map.get("saveFile"));
			pstmt.setString(4, (String) map.get("thumbnail"));
			pstmt.setString(5, (String) map.get("id"));
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.closeAll(null, pstmt, con);
		}
		return result;
	}
	
	public HashMap<String, Object> detail(int gno) {
		HashMap<String, Object> dto = null;
		Connection con = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM galleryview WHERE gno=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, gno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new HashMap<String, Object>();
				//dto.put("commentcount", rs.getInt("commentcount"));
				dto.put("gno", rs.getInt("gno"));
				dto.put("gtitle", rs.getString("gtitle"));
				dto.put("gcontent", rs.getString("gcontent"));
				dto.put("gdate", rs.getString("gdate"));
				dto.put("gcount", rs.getInt("gcount"));
				dto.put("gip", rs.getString("gip"));
				dto.put("no", rs.getInt("no"));
				dto.put("id", rs.getString("id"));
				dto.put("name", rs.getString("name"));
				dto.put("file", rs.getString("gfilename"));// 파일명 불러오기
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.closeAll(rs, pstmt, con);
		}
		return dto;
	}
	//삭제하기 전 파일 이름 불러오기
	public ArrayList<String> findFileName(HashMap<String, Object> map) {
		ArrayList<String> filename = null;
		Connection con = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT gfilename, gthumbnail FROM galleryview "
				+ "WHERE gno=? AND no=(SELECT no FROM login WHERE id=?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Util.str2Int((String)map.get("gno")));
			pstmt.setString(2, (String) map.get("id"));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				filename = new ArrayList<String>();
				
				String gfilename = rs.getString("gfilename");
				if(gfilename != null && gfilename.contains(".")) {					
					filename.add(gfilename);
				} else {
					filename.add(null);//0index
				}
				String gthumbnail = rs.getString("gthumbnail");//1
				if(gthumbnail != null && gthumbnail.contains(".")) {
					filename.add(gthumbnail);					
				}else {
					filename.add(null);//1index
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.closeAll(rs, pstmt, con);
		}
		return filename;
	}
	public int del(HashMap<String, Object> map) {
		int result = 0;
		Connection con = DBConnection.dbConn();
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM gallery WHERE gno=? AND "
				+ "no=(SELECT no FROM login WHERE id=?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Util.str2Int((String) map.get("gno")));
			pstmt.setString(2, (String) map.get("id"));
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.closeAll(null, pstmt, con);
		}
		return result;
	}
	
}
