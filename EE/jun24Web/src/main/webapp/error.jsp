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
	<h2>�̹� ��ϵ� ���̵� �Դϴ�.</h2>
	<h2>�ٸ� ���̵�� �����ϼ���.</h2>
	<h3><a href=".join.jsp">�����ϱ�</a></h3>
<%
} else if (error.equals("e4080")) {
	
} else {
	
}
%>
</body>
</html>