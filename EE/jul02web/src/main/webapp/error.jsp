<%@page import="com.poseidon.dto.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.poseidon.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error</title>
</head>
<body>
<%@ include file="./menu.jsp"%>
	<h1>심각한 문제가 발생하였습니다.</h1>
	<a href="./board.jsp">board</a>
	<a href="./index.jsp">login</a>
</body>
</html>