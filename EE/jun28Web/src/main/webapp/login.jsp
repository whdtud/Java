<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>login</h1>
	<div id="loginbox">
		<img alt="" src="./login.png">
		<form action="./loginAction.jsp" method="post">
			<input type="text" name="id" maxlength="15" placeholder="">
			<input type="text" name="id" maxlength="15" placeholder="">
			<button type="reset">RESET</button>
			<button type="submit">LOGIN</button>
		</form>
		<a href="./join.jsp">가입하기</a>
	</div>
<%
String result = request.getParameter("result");
if (result.equals("success")) {
%>
	<script type="text/javascript">
		alert("가입되셨습니다.\n가입하신 아이디로 로그인하세요.")
	</script>
<%
}
%>
</body>
</html>