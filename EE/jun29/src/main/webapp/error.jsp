<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Error</title>
</head>
<body>
	<h1>error</h1>
	<hr>
<%
//여기는 자바
//para~ error로 오는 것을 잡아서 사용하겠습니다.
//e3380

String error = request.getParameter("error");
if(error.equals("e3380")){
	//이미 등록된 ID입니다. 다른 ID로 가입하세요.
	//html코드로 변환
%>
	
	<h2>이미 등록된 ID입니다.</h2>
	<h2>다른 ID로 가입하세요.</h2>
	<h3><a href="./join.jsp">가입하기</a></h3>

<%
}else if(error.equals("e4080")){
	
}else{
	
}
%>











	
</body>
</html>