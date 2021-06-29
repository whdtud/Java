<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>login</title>
<style type="text/css">
#loginbox{
	margin:0 auto;
	/* 여기를 100px; auto 0px;라고 주시면
	위는 100, 양 옆은 auto, 아래는 0이 됩니다.
	 */
	width: 280px;
	min-height: 300px;
	background-color: #c0c0c0;
	text-align: center;
	padding: 10px;
}
#loginbox input{
	width: 280px;
	height: 30px;
	margin-bottom: 5px;
	font-size: 16pt;
	color: green;
	font-weight: bold;
	font-family: 궁서체;
	text-align: center;	
}
#loginbox input[type="password"]{
	font-size: small;
	color: black;
}

#loginbox button {
	width: 280px;
	height: 40px;
	margin-bottom: 5px;
	font-size: 16pt;
	color: green;
	font-weight: bold;
}
</style>
<script type="text/javascript">
//함수 만들기
function check(){
	var id = document.getElementById("id");
	//alert(id.value);//문서에 있는 id="id"	
	var pw = document.getElementsByName("pw");
	//alert(pw[0].value);//문서에 있는 name="pw"

	if(id.value == "" || id.value.length < 4){
		alert("id의 길이가 짧습니다.");
		return false;//진행막기
	}
	
	if(pw[0].value.length < 4){
		alert("암호의 길이가 짧습니다.");
		return false;//더이상 진행 막기
	}
}
</script>
</head>
<body>
	<h1>login</h1>
	<button onclick="check()">check</button>
	
	<div id="loginbox">
		<img alt="" src="./login.png">
		<form action="./loginAction.jsp" method="post" onsubmit="return check()">
			<input type="text" name="id" id="id" maxlength="15" placeholder="아이디를 입력하세요">
			<input type="password" name="pw" maxlength="20" placeholder="비밀번호를 입력하세요"><br>
			<button type="reset">RESET</button><br>
			<button type="submit">LOGIN</button>
		</form>
		<a href="./join.jsp">가입하기</a>
	</div>
<%
String result = request.getParameter("result");
if(result != null && result.equals("success")){
%>
	<script type="text/javascript">
		alert("가입되셨습니다.\n가입하신 아이디로 로그인하세요.");
	</script>	


<%
}
%>
	
</body>
</html>