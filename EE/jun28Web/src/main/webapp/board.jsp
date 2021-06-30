<%@page import="com.whdtud.dto.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.whdtud.dao.BoardDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.whdtud.web.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
table {
	width: 800px;
	height: 300px;
	/* background-color: #c0c0c0; */
	border-collapse: collapse;
}
table td {
	border-bottom: 1px green solid;
	text-align: center;
}
table tr:hover {
	background-color: gray;
}
table th {
	background-color: gray; 
}
#no {
	width: 50px;
}
#title {
	width: 400px;
	text-align: left;
}
a {
	text-decoration: none;
	/* color: black; */
}

a:visited {
	color: black;
}

a:link {
	/* color: red; */
}

a:active {
	
}

</style>
</head>
<body>
	<a href="index.jsp">Index.jsp</a><br>
	
	<%
	BoardDAO dao = new BoardDAO();
	ArrayList<BoardDTO> list = dao.list();
	%>
	
	<table>
		<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		</thead>
		<tbody>
	<%
	for (BoardDTO dto : list) {
	%>
		<tr>
			<td id="no"><%=dto.getNo()%></td>
			<td id="title">
			<a href="detail.jsp?bno=<%=dto.getNo()%>">
			<%=dto.getTitle()%>
			</a>
			</td>
			<td id="name"><%=dto.getName()%></td>
			<td id="date"><%=dto.getDate()%></td>
			<td id="count"><%=dto.getCount()%></td>
		</tr>
	<%	
	}
	%>
		</tbody>
	</table>
</body>
</html>