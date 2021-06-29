<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>login</title>
<style type="text/css">
#loginbox{
	margin:0 auto;
	/* ���⸦ 100px; auto 0px;��� �ֽø�
	���� 100, �� ���� auto, �Ʒ��� 0�� �˴ϴ�.
	 */
	width: 280px;
	min-height: 300px;
	background-color: #c0c0c0;
	text-align: center;
	padding: 10px;
}
#loginbox input{
	width: 280px;
	height: 30px;
	margin-bottom: 5px;
	font-size: 16pt;
	color: green;
	font-weight: bold;
	font-family: �ü�ü;
	text-align: center;	
}
#loginbox input[type="password"]{
	font-size: small;
	color: black;
}

#loginbox button {
	width: 280px;
	height: 40px;
	margin-bottom: 5px;
	font-size: 16pt;
	color: green;
	font-weight: bold;
}
</style>
<script type="text/javascript">
//�Լ� �����
function check(){
	var id = document.getElementById("id");
	//alert(id.value);//������ �ִ� id="id"	
	var pw = document.getElementsByName("pw");
	//alert(pw[0].value);//������ �ִ� name="pw"

	if(id.value == "" || id.value.length < 4){
		alert("id�� ���̰� ª���ϴ�.");
		return false;//���ื��
	}
	
	if(pw[0].value.length < 4){
		alert("��ȣ�� ���̰� ª���ϴ�.");
		return false;//���̻� ���� ����
	}
}
</script>
</head>
<body>
	<h1>login</h1>
	<button onclick="check()">check</button>
	
	<div id="loginbox">
		<img alt="" src="./login.png">
		<form action="./loginAction.jsp" method="post" onsubmit="return check()">
			<input type="text" name="id" id="id" maxlength="15" placeholder="���̵� �Է��ϼ���">
			<input type="password" name="pw" maxlength="20" placeholder="��й�ȣ�� �Է��ϼ���"><br>
			<button type="reset">RESET</button><br>
			<button type="submit">LOGIN</button>
		</form>
		<a href="./join.jsp">�����ϱ�</a>
	</div>
<%
String result = request.getParameter("result");
if(result != null && result.equals("success")){
%>
	<script type="text/javascript">
		alert("���ԵǼ̽��ϴ�.\n�����Ͻ� ���̵�� �α����ϼ���.");
	</script>	


<%
}
%>
	
</body>
</html>