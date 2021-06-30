<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>error</h1>
	<hr>
<%
String error = request.getParameter("error");
if (error.equals("e3308")) {
%>
	<h2>이미 등록된 아이디 입니다.</h2>
	<h2>다른 아이디로 가입하세요.</h2>
	<h3><a href=".join.jsp">가입하기</a></h3>
<%
} else if (error.equals("e4080")) {
	
} else {
	
}
%>
</body>
</html>