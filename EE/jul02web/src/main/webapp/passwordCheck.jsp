<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if(session.getAttribute("id") == null 
	|| request.getAttribute("check") == null){
	//로그인 하지 않았거나, check값이 없다면
	//잘못된 접근 -> 튕기기
	response.sendRedirect("./error.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Info</title>
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
#infobox input[type=password]{
/* input타입중에 password타입만 선택 */
	height: 30px;
	margin: 5px;
	width: 195px;
	padding: 5px;
}

#infobox button[type=submit]{
/* 버튼 타입 중에 submit속성만 선택 */
	height: 30px;
	width: 100%;
}
#infobox button[type=submit]:hover{
	background-color: skyblue;
	font-size: large;
	color: white;
}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script type="text/javascript">
/* 제이쿼리는 위 js파일이 있어야 실행됩니다. */
//	$(선택자).명령();
//	$(document).ready(function(){
//		alert("hi");
//	});//이걸 줄이면
	
	$(function(){
		$("#submit").click(function(){
			var pw = $("#pw").val();
			//alert(pw);
			if(pw == "" || pw.length < 4){
				alert("암호를 입력하세요.");
				$("#pw").focus();
				return false;
			}
		});
	});//이렇게 됩니다.

</script>
</head>
<body>
	<%@ include file="./menu.jsp"%>
	
	<div id="infobox">
		<form action="./myinfo" method="post">
		개인정보를 보기 위해서<br>암호를 입력하세요.
		암호 : <input type="password" name="pw" id="pw" required="required">
		<button type="submit" id="submit">개인정보보기</button>
		</form>
	</div>
	
</body>
</html>