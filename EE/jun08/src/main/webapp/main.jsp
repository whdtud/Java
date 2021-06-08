<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="index.css">

<style type="text/css">
	body {
		background-color: green;
	}
</style>

</head>
<body style="background-color: yellow;">
	<h1 id="main">main</h1>
	<h1>main</h1>

	<div id="box">
		this is div box.
		<div class="boxinbox">
			inner box.
			<div></div>
			<a href="list.jsp">list</a>
		</div>
	</div>
	
	here is outside of div.
	
	<div id="box">
		this is div box.
		this is div box.
	</div>
	
</body>
</html>