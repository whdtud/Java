<%@page import="com.poseidon.dto.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if(request.getAttribute("check") == null 
	|| session.getAttribute("id") == null
	|| session.getAttribute("name") == null
	|| request.getAttribute("dto") == null){
	response.sendRedirect("./error.jsp");
}
LoginDTO dto = (LoginDTO)request.getAttribute("dto");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my info</title>
<style type="text/css">
#infobox{
	margin: 0 auto;
	margin-top:100px;
	padding:10px;
	width: 300px;
	height: 200px;
	background-color: gray;
	box-sizing: border-box;
	text-align: center;
	font-size: 16pt;
}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script type="text/javascript">
	
	$(function() {//document.ready
		$("button").click(function() {
			//alert("암호");
			var pw = $("#pw").val();
			if(pw == ""){
				alert("암호를 입력하세요.");
				$("#pw").focus();
				return false;
			}
			if(pw.length < 4){
				alert("암호의 길이가 짧습니다.");
				$("#pw").focus();
				return false;
			}
		});//button click
	});//
</script>
</head>
<body>
	<%@ include file="./menu.jsp"%>
	
	<div id="infobox">
		ID : <input type="text" value="<%=dto.getId() %>" disabled="disabled">
		<br><!--둘 차이점은 readonly는 form으로 값 전송 시킬 수 있습니다.  -->
		email : <input type="text" value="<%=dto.getEmail() %>" readonly="readonly"> 
		<br>
		닉네임 : <input type="text" value="<%=dto.getName() %>" readonly="readonly">
		<br>
		<form action="./changepw" method="post" 
									onsubmit="return password()">
		암호 : <input type="password" name="pw" id="pw">
		<button type="submit">암호 변경</button>
		</form>
	</div>
	
	
</body>
</html>