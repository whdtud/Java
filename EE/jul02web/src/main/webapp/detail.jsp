<%@page import="com.poseidon.dto.BoardDTO"%>
<%@page import="com.poseidon.dao.BoardDAO"%>
<%@page import="com.poseidon.util.Util"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세보기</title>
<style type="text/css">
#detail{
	margin: 0 auto;
	width: 800px;
	height: 500px;
	background-color: silver;
}
#title{
	width: 100%;
	height: 40px;
	padding :10px;
	text-align: center;
	border-bottom: 2px solid black;
	box-sizing: border-box;
}
#date{
	width: 100%;
	height: 50px;
	border-bottom: 1px solid gray; 
}
#date2{
	width: 45%;
	height: 30px;
	text-align: center;
	float: left;
	margin: 5px;
	padding: 5px;
}
#content{
	height: calc(100% - 91px);
	width: 100%;
	padding: 20px;
	box-sizing: border-box;
	
}
</style>
<script type="text/javascript">
function update(bno){
	if(confirm("수정하시겠습니까?")){
		location.href="update?bno="+bno;
	}
}
function del(bno){
	if(confirm("삭제하시겠습니까")){
		alert("삭제합니다.");
		location.href="delete?bno="+bno;
	}
}
</script>
</head>
<body>
	<%@ include file="./menu.jsp"%>
	<h1>detail</h1>
	<%
	int bno = Util.str2Int2(request.getParameter("bno"));
	BoardDAO dao = new BoardDAO();
	BoardDTO dto = dao.detail(bno);
	%>
	<hr>
	<div id="detail">
		<div id="title">
			<%=dto.getBtitle() %>
			<img alt="delete" src="./delete.png" height="20px" onclick="return del(<%=dto.getBno() %>);" style="vertical-align: middle;">
			<img alt="update" src="./update.png" height="20px" onclick="return update(<%=dto.getBno() %>); "style="vertical-align: middle;">
		</div>
		<div id="date">
			<div id="date2"><%=dto.getName() %><br>(<%=dto.getId() %>)</div>		
			<div id="date2"><%=dto.getBcount() %><br><%=dto.getBdate() %></div>
		</div>
		<div id="content"><%=dto.getBcontent() %></div>
	</div>
	
	<button onclick="location.href='./board.jsp'">게시판으로</button>
	
	
	
	
	
	
	
	
</body>
</html>