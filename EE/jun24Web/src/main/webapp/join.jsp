<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>join</h1>
	<form action="./joinAction.jsp" method="post">
	<table border=1>
		<tr>
			<td>���̵�</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>�̸�</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>��ȣ</td>
			<td><input type="password" name="pw1"><br>
				<input type="password" name="pw2">
			</td>
		</tr>
		<tr>
			<td>�̸���</td>
			<td><input type="text" name="email"></td>
		</tr>
	</table>
	<button>����</button>
	<button>�����ϱ�</button>
	</form>
</body>
</html>