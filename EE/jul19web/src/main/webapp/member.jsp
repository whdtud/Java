<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member</title>
<link href="./css/main.css" rel="stylesheet">
<link href="./css/menu.css" rel="stylesheet">
<style type="text/css">
#adminMenu{
	width: 100%;
	height: 30px;
	background-color: blue;
}
#adminMain{
	width: 100%;
	height: clac(100% - 30px);
	/* background-color: gray; */
}
table {
	border-collapse: collapse;	
	height: auto;
	width: 100%;
}
th{
	background-color: gray;
	border-bottom: 1px white solid;
}
tr:nth-child(even){
	background-color: #c1c1c1;
}
tr:nth-child(odd){
	background-color:aqua;
}
tr:hover{
	background-color: gray;
}
td{
	border-bottom: 1px white solid;
}
#paging{
	margin-top:5px;
	display: block;
	margin:0 auto;
	width: 100%;
	height: 30px;
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
	<div id="mainWrapper">
		<div id="admin">
			<div id="adminMenu">
				<!-- 꾸며주세요 -->
				<a href="member">회원관리</a> | 게시글 관리 | <a href="admin">로그 관리</a> | ....
			</div>
			<div id="adminMain">
				전체 글 수 : ${totalCount } 개 / 페이지 : ${page }
				<c:choose>
					<c:when test="${fn:length(list) > 0 }">
				<table style="width: 100%; font-size: smaller;">
					<tr>
						<th>no</th>
						<th>이름</th>
						<th>아이디</th>
						<th>비밀번호</th>
						<th>email</th>
						<th>joindate</th>
						<th>birthdate</th>
						<th>grade</th>
					</tr>
					<c:forEach items="${list }" var="l">
					<tr>						
						<td>${l.no }</td>
						<td>${l.name }</td>
						<td>${l.id }</td>
						<td><span onclick="changePW(${l.no})">${l.pw }</span></td>
						<td>${l.email }</td>
						<td>${l.joindate }</td>
						<td>${l.birthdate }</td>
						<td>
							<select onchange="changeGrade(${l.no })">
								<c:forEach begin="0" end="9" var="g">
									<c:if test="${g eq l.grade }">
										<option selected="selected">${g }</option>
									</c:if>
									<c:if test="${g ne l.grade }">
										<option>${g }</option>
									</c:if>								
								</c:forEach>
							</select>
						</td>
					</tr>
					</c:forEach>
				</table>
					<div id="paging">
						<!-- 이동할 페이지명을 변수처리 -->
						<c:set var="pageName" value="admin" scope="request"/>
						<c:set var="PAGENUMBER" value="20" scope="request"/>
						<c:import url="paging.jsp"/>
					</div>
					</c:when>
					<c:otherwise>
						<h2>출력할 데이터가 없습니다</h2>
					</c:otherwise>
				</c:choose>
				
			</div>
		</div>
	</div>
</div>
</div>

<script type="text/javascript">
function changePW(no){
	//alert(no + "암호 번경을 눌렀습니다.");
	var pw = prompt("변경할 암호를 입력하세요.");
	//alert("입력한 암호는 : " + pw);
	location.href="adminChangePW?no="+no+"&pw="+pw;
	//나중에는 post전송으로도 보내보세요.
}
</script>



</body>
</html>



