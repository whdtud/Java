<%@page import="com.poseidon.dto.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.poseidon.dao.BoardDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.poseidon.web.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����</title>
<style type="text/css">
table {
	width: 800px;
	height: 400px;
	/* background-color: #c0c0c0; */
	border-collapse: collapse;
}
table td{
	border-bottom: 1px #2E8B57 solid;
	text-align: center;
}
table th{
	background-color: gray;
}
table tr:hover{
	background-color: gray;
}

#title{
	width: 400px;
	text-align: left;
}

a{
	text-decoration: none;
	color: black;
}
/* ������ */
a:visited { /* �湮�� */
}

a:link { /* �湮�� */
}

a:active { /* Ŭ������ ��  */
	
}
</style>
</head>
<body>
	<h1>board</h1>
	<%
	//DAO�� �����ͺ��̽��� �۾� �� ����� �����ָ�
	//�װ� �޾Ƽ� ����ϰڽ��ϴ�.
	//DAO / DTO
	BoardDAO dao = new BoardDAO();
	ArrayList<BoardDTO> list = dao.list();
	%>
	<table>
		<thead>
		<tr>
			<th>��ȣ</th>
			<th>����</th>
			<th>�۾���</th>
			<th>��¥</th>
			<th>��ȸ��</th>
		</tr>
		</thead>
		<tbody>
		<%
		for (int i = 0; i < list.size(); i++) {
		%>
		<tr>
			<td><%=list.get(i).getBno()%></td>
			<td id="title">
			<a href="./detail.jsp?bno=<%=list.get(i).getBno()%>">
			<%=list.get(i).getBtitle()%>
			</a>
			</td>
			<td><%=list.get(i).getName()%></td>
			<td><%=list.get(i).getBdate()%></td>
			<td><%=list.get(i).getBcount()%></td>
		</tr>
		<%
		}
		%>
	</tbody>
	</table>



</body>
</html>