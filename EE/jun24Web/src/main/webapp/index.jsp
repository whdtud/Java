<%@page import="java.util.HashMap"%>
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
<title>Insert title here</title>
</head>
<body>
	<h1>index</h1>
	<a href="board.jsp">Board.jsp</a><br>
	<a href="join.jsp">Join.jsp</a><br>
	1. DB와 연결해서 데이터 가져오기<br>
	2. jar 가져오기<br>
	3. 연결하기 = java<br>
	
	<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String url = "jdbc:mariadb://220.70.33.29:3306/whdtud";
	String id = "whdtud";
	String pw = "01234567";
	String sql = "SELECT * FROM boardview";

	Class.forName("org.mariadb.jdbc.Driver");
	conn = DriverManager.getConnection(url, id, pw);
	pstmt = conn.prepareStatement(sql);
	rs = pstmt.executeQuery();
	
	ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
	while (rs.next()) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		result.put("no", rs.getInt("bno"));
		result.put("title", rs.getString("btitle"));
		result.put("date", rs.getString("bdate"));
		result.put("count", rs.getInt("bcount"));
		result.put("name", rs.getString("name"));
		result.put("id", rs.getString("id"));
		
		list.add(result);
	}
	
	rs.close();
	pstmt.close();
	conn.close();
	%>
	
	<table border=1>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>글쓴이</td>
			<td>날짜</td>
			<td>조회수</td>
		</tr>
		<%
		for (int i = 0; i < list.size(); i++) {
			HashMap<String, Object> result = list.get(i);
		%>
		<tr>
			<td><%=result.get("no")%></td>
			<td><%=result.get("title")%></td>
			<td><%=result.get("name")%></td>
			<td><%=result.get("date")%></td>
			<td><%=result.get("count")%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>