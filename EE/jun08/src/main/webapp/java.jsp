<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
�ڹ� ȣ��
<!-- �ڹ� �ƴմϴ�. -->
<%
// ���� �ڹ��Դϴ�.
String hi = "hello";
%>

�ڹٷ� ������� ���� hi�� ����ϱ� : <%=hi %>

<hr>

<%
for (int i = 0; i < 10; i++) {
	

%>

<!-- html -->
	���� : <%=i %><br>

<%} %>

</body>
</html>