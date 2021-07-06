<%@page import="com.poseidon.dto.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.poseidon.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
<style type="text/css">
*{
	margin: 0;
	padding: 0;
}

</style>
</head>
<body>
<%@ include file="./menu.jsp"%>
	<h1>detail</h1>
<%
	int bno = Integer.parseInt(request.getParameter("bno"));
	BoardDAO dao = new BoardDAO();
	BoardDTO dto = dao.detail(bno);
%>	
	<table>
		<tr>
			<td><%=dto.getBtitle() %></td>
		</tr>		
		<tr>
			<td><%=dto.getName() %></td>
		</tr>		
		<tr>
			<td><%=dto.getBcount() %></td>
		</tr>		
		<tr>
			<td><%=dto.getBcontent() %></td>
		</tr>		
	</table>
</body>
</html>