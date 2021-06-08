<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
		<link rel="stylesheet" href="index.css" type="text/css">
		
		<style type="text/css">
		/*
		호출 id는 #, class는 .으로
		*/
			#red {
				color : blue;
				font-size : 20pt;
			}
			.head1{
				text-decoration: underline;
				text-shadow: 2px 2px red;
				font-style: italic;
				background-color: orange;
			}
		</style>
	</head>
	<body>
		<h1 class="head1">index</h1>
		<h2 class="head1">this is h2</h2>
		html 뼈대<br>
		css 꾸며주기<br>
		<img>
		<a>link</a>
		<b style="color:red; background-color: blue;">bold 인라인 방법</b>
		<b style="color:red;">여기 또 있다면?</b>
		<b id="red">바뀌나요?</b>
		
		<hr>
		<a id="main" href="main.jsp">main</a>
		<a id="list" href="list.jsp">list</a>
	</body>
</html>