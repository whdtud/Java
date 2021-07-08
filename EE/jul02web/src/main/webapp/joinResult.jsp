<%@page import="com.poseidon.util.Util"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입 결과</title>
</head>
<body>
	<%@ include file="./menu.jsp"%>
	<h1>가입 결과</h1>
<%
if(request.getAttribute("count").equals(1)){
%>
	<h2><%=request.getAttribute("id") %>님, 가입이 완료되었습니다.</h2>
	<h3>로그인 해주세요.</h3>
	<button onclick="location.href='./index.jsp'">로그인하기</button>
<%
} else{
%>
	<h2><%=request.getAttribute("id") %>님, 문제가 발생했습니다.</h2>
	<h3>가입을 완료하지 못했습니다. 다시 시도해주세요.</h3>
<%
}
%>

</body>
</html>