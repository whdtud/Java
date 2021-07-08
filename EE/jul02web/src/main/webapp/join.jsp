<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입하기</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
}
table {
	margin: 0 auto;
	height: 400px;
	width: 400px;
	border-collapse: collapse;
}
table input{
	width: 200px;
	height: 30px;
	margin: 5px;
	border: 0px;
	padding: 5px;
	
}
table button{
	width: 140px;
	height: 50px;
	border: 0px;
}
table td{
	background-color: #c0c0c0;
}
table tr{
	border: 1px white solid;
	text-align: center;
	
}
#itext{
	width: 150px;
}

</style>
<script type="text/javascript">
function join(){
	//alert("들어옵니다.");
	var id = document.getElementById("id");
	var name = document.getElementById("name");
	var pw1 = document.getElementById("pw1");
	var pw2 = document.getElementById("pw2");
	var email = document.getElementById("email");
	//암호도 잡아주세요. email도 잡아주세요 
	
	//alert(id.value + " : " + name.value);
	//alert(pw1.value + " : " + pw2.value);
	//alert(email.value);
	
	//id가 없거나, 3글자 이하라면 
	if(id.value == "" || id.value.length < 4){
		alert("아이디를 입력하세요.");
		id.focus();//마우스 커셔를 해당 위치로 이동
		id.style.backgroundColor = 'red';
		return false;
	}
	if(name.value == "" || name.value.length < 3){
		alert("이름을 입력하세요.");
		name.focus();
		name.style.backgroundColor = 'red';
		return false;
	}
	//pw1
	if(pw1.value == "" || pw1.value.length < 4){
		alert("올바른 암호를 입력하세요.");
		pw1.focus();
		pw1.style.backgroundColor = 'red';
		return false;
	}
	//pw2
	if(pw2.value == "" || pw2.value.length < 4){
		alert("올바른 암호를 입력하세요.");
		pw2.focus();
		pw2.style.backgroundColor = 'red';
		return false;
	}
	if(pw1.value != pw2.value){
		alert("같은 비밀번호를 입력하세요.");
		pw1.value = "";//input값 지우기
		pw2.value = "";
		pw1.style.backgroundColor = 'red';
		pw2.style.backgroundColor = 'red';
		pw1.focus();
		return false;
	}
	if(email.value == ""){
		alert("email을 입력하세요.");
		email.style.backgroundColor = 'red';
		email.focus();
		return false;
	}
	//return false;//더이상 동작을 진행하지 않습니다.
	//여기에 있으면 안 됩니다. 작업 완료 후 지워주세요.
}
</script>
</head>
<body>
	<%@ include file="./menu.jsp"%>
	<h1>가입하기</h1>
	<form action="./join" method="post" onsubmit="return join()">
	<table>
		<tr>
			<td id="itext">아이디</td>
			<td><input type="text" name="id" id="id"></td>
		</tr>
		<tr>
			<td>이&ensp;&ensp;름</td>
			<td><input type="text" name="name" id="name"></td>
		</tr>
		<tr>
			<td>암&ensp;&ensp;호</td>
			<td><input type="password" name="pw1" id="pw1"><br>
				<input type="password" name="pw2" id="pw2"></td>
		</tr>
		<tr>
			<td>email</td>
			<td><input type="email" name="email" id="email"></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="reset">지우기</button>
				<button type="submit">가입하기</button>
			</td>
		</tr>
	</table>
	</form>

</body>
</html>