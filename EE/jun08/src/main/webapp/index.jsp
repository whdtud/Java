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
		ȣ�� id�� #, class�� .����
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
		html ����<br>
		css �ٸ��ֱ�<br>
		<img>
		<a>link</a>
		<b style="color:red; background-color: blue;">bold �ζ��� ���</b>
		<b style="color:red;">���� �� �ִٸ�?</b>
		<b id="red">�ٲ��?</b>
		
		<hr>
		<a id="main" href="main.jsp">main</a>
		<a id="list" href="list.jsp">list</a>
	</body>
</html>