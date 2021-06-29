<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>index</title>
</head>
<body>
	<h1>index</h1>
	1. DB와 연결해서 데이터 가져오기<br>
	2. jar가져오기<br>
	3. 연결하기 = java<br>
	<% 
	//java 
	Connection conn = null;//접속정보
	PreparedStatement pstmt = null;//직접 데이터베이스와 붙어서 일
	ResultSet rs = null;//pstmt의 결과값을 담을 객체
	
	//String url = "jdbc:mariadb://localhost:3306/디비명";
	String url = "jdbc:mariadb://220.70.33.29:3306/poseidon";
	String id = "poseidon";
	String pw = "01234567";
	
	Class.forName("org.mariadb.jdbc.Driver");
	conn = DriverManager.getConnection(url, id, pw);
	pstmt = conn.prepareStatement("SELECT * FROM boardview");
	
	rs = pstmt.executeQuery();
	
	//담을 객체 만들기
	ArrayList<HashMap<String, Object>> list =
			new ArrayList<HashMap<String, Object>>();
	
	while(rs.next()){
		HashMap<String, Object>	result = 
				new HashMap<String, Object>();//하나하나 담을 객체
		result.put("bno", rs.getInt("bno"));
		result.put("btitle", rs.getString("btitle"));
		result.put("bdate", rs.getString("bdate"));
		result.put("bcount", rs.getInt("bcount"));
		result.put("name", rs.getString("name"));
		result.put("id", rs.getString("id"));
		list.add(result);//리스트에 붙이기
	}
	
	rs.close();
	pstmt.close();
	conn.close();
	%>
	
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>글쓴이</td>
			<td>날짜</td>
			<td>조회수</td>
		</tr>	
		<%
		//여기는 java입니다.
		//1. jsp에서 < % 를 만나면 먼저 처리합니다.
		//2. html처리
		//3. 우리가 봅니다. = 엔진
		for(int i = 0; i < list.size(); i++){
			HashMap<String, Object> result = list.get(i); 
		%>
		<tr>
			<td><%=list.get(i).get("bno") %></td>
			<!-- 이 방법도 있습니다. -->
			<td><%=result.get("btitle") %></td>
			<td><%=result.get("name") %>(<%=result.get("id") %>)</td>
			<td><%=result.get("bdate") %></td>
			<td><%=result.get("bcount") %></td>
		</tr>
		<%
		//여기 자바입니다.
		}
		%>
	</table>
	
	<a href="./board.jsp"><h1>board로가기</h1></a>
	
	
	
	
	
	
	
</body>
</html>