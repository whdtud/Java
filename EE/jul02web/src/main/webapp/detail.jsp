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
#detail {
	margin: 0 auto;
	width: 800px;
	min-height: 500px;
	background-color: silver;
}

#title {
	width: 100%;
	height: 40px;
	padding: 10px;
	text-align: center;
	border-bottom: 2px solid black;
	box-sizing: border-box;
}

#date {
	width: 100%;
	height: 50px;
	border-bottom: 1px solid gray;
}

#date2 {
	width: 45%;
	height: 30px;
	text-align: center;
	float: left;
	margin: 5px;
	padding: 5px;
}

#content {
	min-height: calc(100% - 91px);
	width: 100%;
	padding: 20px;
	box-sizing: border-box;
}

#comments {
	margin: 0 auto;
	width: 800px;
	min-height: 100px;
}

#comment {
	width: 100%;
	height: 100px;
	margin: 10px 0;
}

#commentId #commentContent {
	width: 100%;
	height: auto;
}

#commentId {
	height: 20px;
	padding: 10px;
	background-color: #c0c0c0;
	border-bottom: 1px solid black;
}

#commentContent {
	padding: 10px;
	min-height: 50px;
	background-color: olive;
	box-sizing: border-box;
}

#commentWrite {
	margin: 0 auto;
	width: 800px;
	min-height: 100px;
	background-color: gray;
	text-align: right;
	padding: 10px;
	box-sizing: border-box;
}

#commentWrite textarea {
	margin: 0;
	padding: 0;
	width: 670px;
	height: 100px;
	padding: 10px;
	vertical-align: middle;
	resize: vertical;
	box-sizing: border-box;
}

#commentWrite button {
	margin: 0;
	padding: 0;
	width: 100px;
	height: 100px;
	vertical-align: middle;
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
			<%=dto.getBtitle()%>
			<%
			if (session.getAttribute("id") != null && ((String) session.getAttribute("id")).equals(dto.getId())) {
			%>
			<img alt="delete" src="./delete.png" height="20px"
				onclick="return del(<%=dto.getBno()%>);"
				style="vertical-align: middle;"> <img alt="update"
				src="./update.png" height="20px"
				onclick="return update(<%=dto.getBno()%>); "
				style="vertical-align: middle;">
			<%
			}
			%>
		</div>
		<div id="date">
			<div id="date2"><%=dto.getName()%><br>(<%=dto.getId()%>)
			</div>
			<div id="date2"><%=dto.getBcount()%><br><%=dto.getBdate()%></div>
		</div>
		<div id="content"><%=dto.getBcontent()%></div>
	</div>
	<div id="comments">
		<div id="comment">
			<div id="commentId">글쓴사람, 쓴 날짜</div>
			<div id="commentContent">본문내용</div>
		</div>
	</div>
	<div id="commentWrite">
		<div>
			<textarea></textarea>
			<button>댓글쓰기</button>
		</div>
	</div>
	<button onclick="location.href='./board.jsp'">게시판으로</button>








</body>
</html>