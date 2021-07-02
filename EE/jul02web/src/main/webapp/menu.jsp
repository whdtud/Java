<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style type="text/css">
body {
	margin: 0;
	padding: 0;
}

#menu {
	width: 100%;
	height: 50px;
	background-color: #2471A3;
	overflow: hidden;
}

#home {
	float: left;
	margin-top: 9px;
	margin-left: 15px;
}

#navi {
	float: left;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	height: 50px;
}

li {
	float: left;
	margin: 0 10px;
}

li a {
	display: block;
	color: white;
	font-weight: bold;
	text-align: center;
	padding: 15px;
	text-decoration: none;
}

li img {
	
}

li a:hover {
	color: gray;
}
</style>
<div id="menu">
	<a href="./index.jsp"><img id="home" alt="icon_dog"
		src="./icon_dog.png"></a>
	<div id="navi">
		<ul>
			<li><a href="./index.jsp">홈</a></li>
			<li><a href="./board.jsp">게시판</a></li>
			<li><a href="./freeboard.jsp">유머</a></li>
			<li><a href="./notice.jsp">공지사항</a></li>
			<li><a href="./shop.jsp">마켓</a></li>
		</ul>
	</div>
</div>
