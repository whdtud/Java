<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link href="./css/main.css" rel="stylesheet">
<link href="./css/menu.css" rel="stylesheet">
<link href="./css/login.css" rel="stylesheet">
</head>
<body>
<div id="container">
<div id="menu">
	<c:import url="menu.jsp"/>
</div>
<div id="main">
	<div id="mainWrapper">
		<div id="login">
			<form action="./login" method="post">
			<img alt="logo" src="./img/logo.png"><br>
			<input type="text" name="id" 
				placeholder="아이디를 입력하세요." required="required">
			<input type="password" name="pw" 
				placeholder="비밀번호를 입력하세요" required="required">
			<button>Login</button>
			</form>
		</div>
	</div>
</div>
</div>
	
	
<!--  
	1.servlet -> login(Login)
			get   화면보여주기
					login.jsp보여주기
					
			post  데이터베이스로 값 보내기
					진짜 있는 사람?
					세션 만들어주기
-->	
</body>
</html>