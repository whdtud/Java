<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if test="${list eq null }">
	<!-- 서블릿을 지나와야 list가 생성됩니다. -->
	<!-- list가 없다면 다시 서블릿으로 이동하게 설정 -->
	<c:redirect url="./gallery"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gallery</title>
<link href="./css/main.css" rel="stylesheet">
<link href="./css/menu.css" rel="stylesheet">
<link href="./css/gallery.css" rel="stylesheet">
</head>
<body>
<div id="container">
<div id="menu">
	<c:import url="menu.jsp"/>
</div>
<div id="main">
	<h1>gallery List</h1>
	<div id="mainWrapper">
	
	<c:choose>
		<c:when test="${fn:length(list) > 0 }">
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
		<c:forEach items="${list }" var="l">
		<li>
			<ul>
				<li>${l.gno }</li>
				<li>
				
				<a href="./galleryDetail?gno=${l.gno }">
					<c:choose>
						<c:when test="${l.gthumbnail eq null }">
							<img alt="no image" src="img/noimage.jpg"  style="vertical-align: middle; height: 80px;">
						</c:when>
						<c:otherwise>
							<img alt="thumb" src="./thumbnail/${l.gthumbnail }" style="vertical-align: middle; height: 80px;">
						</c:otherwise>
					</c:choose>
					
					${l.gtitle }
				</a>
				
				</li>
				<li>${l.name }</li>
				<li>${l.gdate }</li>
				<li>${l.gcount }</li>
			</ul>
		</li>
		</c:forEach>
	</ul>
		</c:when>
		<c:otherwise>찍어줄 글이 없습니다</c:otherwise>
	</c:choose>
	
	<div id="paging">
		<!-- 이동할 페이지명을 변수처리 -->
		<c:set var="pageName" value="gallery" scope="request"/>
		<c:set var="PAGENUMBER" value="5" scope="request"/>
		<c:import url="paging.jsp"/>
	</div>
	
	<c:if test="${sessionScope.id ne null }">
	<a href="./galleryWrite">글쓰기</a>
	</c:if>
	
	</div>
</div>
</div>
	
	
	
	
	
	
	
	
	
</body>
</html>