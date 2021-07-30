package com.poseidon.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

public class Util {
	//ip가져오기
	public static String getIP(HttpServletRequest request) {
		String ip = request.getHeader("X-FORWARDED-FOR");
		if(ip == null) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if(ip == null) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if(ip == null) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
	// 방법1
	public static int str2Int(String str) {
		// 120A이렇게 들어온다면 120을 리턴해줍니다.
		int result = 0;
		String temp = "";
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				temp += str.charAt(i);
			}
		}
		result = Integer.parseInt(temp);
		return result;
	}

	// 방법2
	public static int str2Int2(String str) {

		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return 0;
		}

	}
	
	// 닫다가 지쳐서 만들었어요.
	public static void closeAll(ResultSet rs, 
			  			PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null) {rs.close();}
			if (pstmt != null) {pstmt.close();}
			if (conn != null) {conn.close();}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static String str2Replace(String str) {
		str = str.replaceAll(">", "&gt;");//html처리
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll("/", "&#47;");
		str = str.replaceAll("\n", "<br>");//엔터키 처리
		return str;
	}
}


/*
 * 입실/퇴실 카드 꼭 찍어주세요.
 * 퇴실하실때 안 찍으시면
 * 컴퓨터 계속 켜 둬야 합니다. ㅠㅠ
 * 오늘 출근해서 컴퓨터 껐어요 ;;;;;
 * 
 * 
 */













