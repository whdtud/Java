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
	1. DB�� �����ؼ� ������ ��������<br>
	2. jar��������<br>
	3. �����ϱ� = java<br>
	<% 
	//java 
	Connection conn = null;//��������
	PreparedStatement pstmt = null;//���� �����ͺ��̽��� �پ ��
	ResultSet rs = null;//pstmt�� ������� ���� ��ü
	
	//String url = "jdbc:mariadb://localhost:3306/����";
	String url = "jdbc:mariadb://220.70.33.29:3306/poseidon";
	String id = "poseidon";
	String pw = "01234567";
	
	Class.forName("org.mariadb.jdbc.Driver");
	conn = DriverManager.getConnection(url, id, pw);
	pstmt = conn.prepareStatement("SELECT * FROM boardview");
	
	rs = pstmt.executeQuery();
	
	//���� ��ü �����
	ArrayList<HashMap<String, Object>> list =
			new ArrayList<HashMap<String, Object>>();
	
	while(rs.next()){
		HashMap<String, Object>	result = 
				new HashMap<String, Object>();//�ϳ��ϳ� ���� ��ü
		result.put("bno", rs.getInt("bno"));
		result.put("btitle", rs.getString("btitle"));
		result.put("bdate", rs.getString("bdate"));
		result.put("bcount", rs.getInt("bcount"));
		result.put("name", rs.getString("name"));
		result.put("id", rs.getString("id"));
		list.add(result);//����Ʈ�� ���̱�
	}
	
	rs.close();
	pstmt.close();
	conn.close();
	%>
	
	<table border="1">
		<tr>
			<td>��ȣ</td>
			<td>����</td>
			<td>�۾���</td>
			<td>��¥</td>
			<td>��ȸ��</td>
		</tr>	
		<%
		//����� java�Դϴ�.
		//1. jsp���� < % �� ������ ���� ó���մϴ�.
		//2. htmló��
		//3. �츮�� ���ϴ�. = ����
		for(int i = 0; i < list.size(); i++){
			HashMap<String, Object> result = list.get(i); 
		%>
		<tr>
			<td><%=list.get(i).get("bno") %></td>
			<!-- �� ����� �ֽ��ϴ�. -->
			<td><%=result.get("btitle") %></td>
			<td><%=result.get("name") %>(<%=result.get("id") %>)</td>
			<td><%=result.get("bdate") %></td>
			<td><%=result.get("bcount") %></td>
		</tr>
		<%
		//���� �ڹ��Դϴ�.
		}
		%>
	</table>
	
	<a href="./board.jsp"><h1>board�ΰ���</h1></a>
	
	
	
	
	
	
	
</body>
</html>