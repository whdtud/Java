<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디/비밀번호 찾기</title>
<style type="text/css">
*{
	margin: 0;
	padding: 0;
}
#idpw{
	margin: 0 auto;
	width: 400px;
	min-height: 400px;
	padding: 10px;
	background-color: #c0c0c0;
	text-align: center;
}
#idpw h2{
	margin: 10px;
}
#idpw h3{
	margin: 10px;
}
#idpw input {
	height: 50px;
	width: 70%;
}
#idpw button {	
	height: 50px;
	width: 20%;
}
</style>
</head>
<body>
<%@ include file="./menu.jsp"%>
<%
//서블릿이 보내주는 result값으로 제어하기
//1 id찾기 정상  2 실패, 3비밀번호 변경 성공 4.비번변경불가 5모든 에러
String result = (String) request.getAttribute("result");
%>
	<h1>아이디 비번 찾기</h1>
	<!-- 1. 꾸며주시는 거, 스크립트, 그림,   -->
	<div id="idpw">
		<%		if(result == null){		%>
		<h2>계정 찾기</h2>
		<img alt="id" src="./img/id.png">
		<h3>계정을 찾으려면 이메일 주소를 입력하세요.</h3>
		<form action="./idpw" method="post" onsubmit="return email()">
			<input type="email" name="email" id="email" required="required">
			<button type="submit">아이디 찾기</button>
		</form>
		<%} else if(result.equals("1")){%>
		<img alt="error" src="./img/ok.png">
		<h1>등록된 ID는 <%=request.getAttribute("id") %>입니다.</h1>
		<hr>
		비밀번호 찾기<br>
		비밀번호를 잃어버리셨나요?<br>
		닉네임과 ID, 초기화 할 비밀번호를 입력하세요.
		<form action="./idpw" method="post">
			<input type="text" name="name" id="name" placeholder="이름을 입력하세요">
			<input type="text" name="id" id="id" placeholder="ID를 입력하세요">
			<input type="password" name="pw1" id="pw1" placeholder="암호를 입력하세요">
			<input type="password" name="pw2" id="pw2" placeholder="암호를 입력하세요"><br>
			<button type="submit">비밀번호설정</button>
		</form>
		<%}else if(result.equals("2")){ %>
			<img alt="error" src="./img/error.png">
			<h1>error</h1>
			<h2>email로 등록된 ID가 없습니다.</h2>
			<h4>해당 email로 가입하시거나</h4>
			<h4>다시 시도해주세요.</h4>
			
		<%}else if(result.equals("3")){ %>
			<img alt="error" src="./img/ok.png">
			<h1>변경되었습니다.</h1>
			<h2>변경된 비밀번호로 다시 로그인 해주세요.</h2>
			
			<button onclick="location.href='./index.jsp'">로그인하러 가기</button>
			
		<%}else if(result.equals("4")){ %>
			<img alt="error" src="./img/error.png">
			<h1>변경할 수 없습니다.</h1>
			<h2>입력된 정보가 올바르지 않습니다.</h2>
			<h2>확인 후 다시 시도하세요.</h2>
			
		<%}else if(result.equals("5")){ %>
			<img alt="error" src="./img/error.png">
			<h1>정보가 올바르지 않습니다.</h1>
			<h2>문제가 발생하여 정보가 전송되지 않았습니다.</h2>
		<%} %>
	</div>
</body>
</html>