<%@page import="com.poseidon.dto.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//로그인 한 사람만 수정에 접근할 수 있습니다.
if (session.getAttribute("id") == null) {
	//페이지 이동
	response.sendRedirect("./index.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
}

#write {
	min-height: 500px;
	width: 800px;
	background-color: gray;
	margin: 0 auto;
	padding: 10px;
}

#title {
	width: 100%;
	height: 30px;
	margin-bottom: 10px;
}

#content {
	width: 100%;
	height: 400px;
	margin-bottom: 10px;
}

#sub {
	width: 100%;
	height: 35px;
	background-color: #82E0AA;
	color: olive;
	font-size: large;
	border: 1px solid #82E0AA;
}
</style>
<script type="text/javascript">
	function check() {
		//alert("!");
		var title = document.getElementById("title");
		var content = document.getElementById("content");
		//alert(title.value + " : " + content.value);

		if (title.value.length < 5 || title.value == "") {
			alert("제목을 5글자 이상 적어주세요.");
			title.focus();
			return false;
		}
		if (content.value == "" || content.value.length < 5) {
			alert("내용을 길게 적어주세요.");
			content.focus();
			return false;
		}
		//실행됩니다.
	}
</script>
<!-- include libraries(jQuery, bootstrap) -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- 서머노트 불러오기 -->
<link href="./summernote/summernote.min.css" rel="stylesheet">
<script src="./summernote/summernote.min.js"></script>

</head>
<body>
	<%@ include file="./menu.jsp"%>
	<!-- 서블릿에서 보내온 값 잡기 -->
	<%
	BoardDTO dto = (BoardDTO) request.getAttribute("dto");
	%>
	<h1>글수정</h1>
	<hr>
	<div id="write">
		<form action="./update" method="post" onsubmit="return check();">
			<input type="text" name="title" id="title" value="<%=dto.getBtitle() %>">
			<textarea name="content" id="content"><%=dto.getBcontent() %></textarea>
			<button id="sub" type="submit">글수정</button>
			<input type="hidden" name="bno" value="<%=dto.getBno() %>">
		</form>
	</div>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#content').summernote({
				height : 400
			});
		});
	</script>

</body>
</html>