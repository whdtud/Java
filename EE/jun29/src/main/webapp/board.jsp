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
<title>보드</title>
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
/* 가나다 */
a:visited { /* 방문후 */
}

a:link { /* 방문전 */
}

a:active { /* 클릭했을 때  */
	
}
</style>
</head>
<body>
	<h1>board</h1>
	<%
	//DAO가 데이터베이스와 작업 후 결과를 돌려주면
	//그걸 받아서 출력하겠습니다.
	//DAO / DTO
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