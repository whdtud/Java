<%@page import="com.poseidon.util.Util"%>
<%@page import="com.poseidon.dao.LogDAO"%>
<%@page import="com.poseidon.dto.LogDTO"%>
<%@page import="com.poseidon.dto.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.poseidon.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String ip = Util.getIP(request);
//DTO만들기
LogDTO dto = new LogDTO();
//값 저장하기
dto.setLog_ip(ip);
dto.setLog_taget("board.jsp");
if(session.getAttribute("id") != null){
dto.setLog_id((String) session.getAttribute("id"));
}
//DAO로보내서 저장시키기
LogDAO.insertLog(dto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보드</title>
<style type="text/css">
*{
	margin: 0;
	padding: 0;
}
table {
	margin: 0 auto;
	height: 400px;
	width: 500px;
	background-color: #c0c0c0;
	border-collapse: collapse;
	text-align: center;
	
}
th{	border-bottom: 3px solid white;}
td{	border-bottom: 1px solid white;}
#title{
	text-align: left;
	width: 250px;
}
tr:hover {
	transition: 2s;
	transition-deley:0.5s;
	background-color: green;}
</style>
</head>
<body>
<%@ include file="./menu.jsp"%>
	<h1>board</h1>
<%
	BoardDAO dao = new BoardDAO();
	ArrayList<BoardDTO> list = dao.list();
%>	
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
<% for(int i = 0; i < list.size(); i++){ %>
		<tr onclick="location.href='./detail.jsp?bno=<%=list.get(i).getBno() %>'">
			<td><%=list.get(i).getBno() %></td>		
			<td id="title">
			<%
			String title = "";
			if(list.get(i).getBtitle().length() > 15){
				title = list.get(i).getBtitle().substring(0, 14);
				title += "...";
			}else{
				title = list.get(i).getBtitle();
			}
			%>
			<%=title %></td>		
			<td><%=list.get(i).getName() %></td>		
			<td><%=list.get(i).getBdate() %></td>		
			<td><%=list.get(i).getBcount() %></td>				
		</tr>
<%} %>
	</table>


	<%
	//로그인 한 사용자라면 글쓰기 버튼 보이게 하기
	if(session.getAttribute("name") != null){
	%>
	<button onclick="location.href='./write.jsp'">글쓰기</button>
	<%
	}
	%>










</body>
</html>