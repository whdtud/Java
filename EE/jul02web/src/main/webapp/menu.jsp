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
	background-color: black;
	overflow: hidden;
}

#navi {
	float: left;
	width: calc(100% - 200px);
	height: 50px;
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
	font-family: "맑은 고딕";
	font-size: 12pt;
	text-align: center;
	padding: 15px;
	text-decoration: none;
}

#logo {
	vertical-align: bottom;
}

#menusession {
	float: right;
	width: 200px;
	height: 50px;
	color: white;
	line-height: 50px;
	font-weight: bold;
	text-align: right;
	overflow: hidden;
}

#menusession a{
	color: white;
	text-decoration: none;
}
#menusession img{
	vertical-align: text-bottom;
}
</style>
<div id="menu">
	<div id="navi">
		<ul>
			<li><a href="./index.jsp"><img alt="apple" src="./apple.png" id="logo"></a></li>
			<li><a href="./board.jsp">board</a></li>
			<li><a href="./freeboard.jsp">free</a></li>
			<li><a href="./notice">notice</a></li>
			<li><a href="./shop.jsp">shop</a></li>
			<%if(session.getAttribute("name") != null){ %>
			<li><a href="./myinfo">my info</a></li>
			<%} %>
		</ul>
	</div>
	<div id="menusession">
		<%if (session.getAttribute("name") != null) {%>
		<img alt="login" src="./open.png" onclick="return logout();">
		<%=session.getAttribute("name")%>님 반갑습니다.
		<%} else {%>
		<a href="./index.jsp">로그인 해주세요.
		<img alt="login" src="./lock.png"></a>
		<%}%>
	</div>
</div>
<script>
function logout(){
	//alert("로그아웃을 눌렀습니다.");
	var name = '<%=session.getAttribute("name") %>';
	if(confirm(name + "님, 로그아웃 하시겠습니까?")){
		alert("로그아웃 하겠습니다.");
		//실제 로그아웃 호출하기
		location.href="./logout";
	}else{
		alert("취소합니다.");
	}
}
</script>












