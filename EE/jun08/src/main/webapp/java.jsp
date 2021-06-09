<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
자바 호출
<!-- 자바 아닙니다. -->
<%
// 여긴 자바입니다.
String hi = "hello";
%>

자바로 만들어진 변수 hi를 출력하기 : <%=hi %>

<hr>

<%
for (int i = 0; i < 10; i++) {
	

%>

<!-- html -->
	값은 : <%=i %><br>

<%} %>

</body>
</html>