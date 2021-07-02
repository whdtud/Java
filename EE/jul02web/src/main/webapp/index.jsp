<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#panel {
	width: 50%;
	height: 300px;
	border: 1px solid;
}

#side_left {
	width: 50%;
	height: 100%;
	float: left;
}

#side_right {
	width: 50%;
	height: 100%;
	float: left;
}

#image {
	margin-top: 20px;
	margin-left: 10px;
}

#form {
	margin-top: 100px;
	float: left;
}

form input {
	width: 90%;
	height: 30px;
	float: left;
	margin-left: 10px;
}

form button {
	width: 92%;
	height: 30px;
	float: left;
	margin-left: 10px;
}
</style>
</head>
<body>
	<%@ include file="./menu.jsp"%>

	<div id="panel">
		<div id="side_left">
			<img id="image" alt="icon_dog_login" src="./icon_dog_login.png">
		</div>
		<div id="side_right">
			<form id="form" action="./login.jsp">
				<input type="text" name="id" placeholder="아이디를 입력하세요."> 
				<input type="password" name="pw" placeholder="비밀번호를 입력하세요.">
				<button type="submit" name="login">로그인</button>
			</form>
		</div>
	</div>
</body>
</html>