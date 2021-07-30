<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:if test="${dto eq null }">
	<!-- dto가 없다면 서블릿으로 던지기 -->
	<c:redirect url="./index"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
<link href="./css/main.css" rel="stylesheet">
<link href="./css/menu.css" rel="stylesheet">
<link href="./css/index.css" rel="stylesheet">
<style type="text/css">
#paging{
	display: block;
	margin:0 auto;
	width: 100%;
	height: 30px;
	background-color: #c0c0c0;
	text-align: center;
	/* margin: 5px; */
}
</style>
</head>
<body>
<div id="container">
<div id="menu">
	<c:import url="menu.jsp"/>
</div>
<div id="main">
	<h1>boardList</h1>
	<div id="mainWrapper">
	<ul id="ulTable">
		<li>
			<ul>
				<li>No</li>
				<li>Title</li>
				<li>Writer</li>
				<li>Date</li>
				<li>Count</li>
			</ul>
		</li>
		<c:forEach items="${dto }" var="dto">
		<li>
			<ul>
				<li>${dto.fno }</li>
				<li>
				
				<a href="./detail?fno=${dto.fno }">${dto.ftitle }
				<c:if test="${dto.commentcount > 0}"><small>${dto.commentcount }</small></c:if>
				</a>
				
				</li>
				<li>${dto.name }</li>
				<li>${dto.fdate }</li>
				<li>${dto.fcount }</li>
			</ul>
		</li>
		</c:forEach>
	</ul>
	<br>
	<!-- 여기가 페이징입니다 -->
	<div id="paging">
		<!-- 이동할 페이지명을 변수처리 -->
		<c:set var="pageName" value="index" scope="request"/>
		<c:set var="PAGENUMBER" value="10" scope="request"/>
		<c:import url="paging.jsp"/>
	</div>
	
	<c:if test="${sessionScope.id ne null }">
	<a href="./freeWrite">글쓰기</a>
	</c:if>
	
	</div>
</div>
</div>
	
	
	
	
	
	
	
	
	
</body>
</html>