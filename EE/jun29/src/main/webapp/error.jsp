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
//����� �ڹ�
//para~ error�� ���� ���� ��Ƽ� ����ϰڽ��ϴ�.
//e3380

String error = request.getParameter("error");
if(error.equals("e3380")){
	//�̹� ��ϵ� ID�Դϴ�. �ٸ� ID�� �����ϼ���.
	//html�ڵ�� ��ȯ
%>
	
	<h2>�̹� ��ϵ� ID�Դϴ�.</h2>
	<h2>�ٸ� ID�� �����ϼ���.</h2>
	<h3><a href="./join.jsp">�����ϱ�</a></h3>

<%
}else if(error.equals("e4080")){
	
}else{
	
}
%>











	
</body>
</html>