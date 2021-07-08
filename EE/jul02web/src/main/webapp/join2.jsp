<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if (request.getParameter("error") != null) {
%>
<script>
	alert("이미 사용중인 ID입니다. 다시 입력해주십시오.");
</script>
<%
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join</title>
<style type="text/css">
* {
	padding: 0;
	margin: 0;
}

h2 {
	text-align: center;
	font-size: 30px;
	padding: 30px 0;
	letter-spacing: 10px;
}

#join_page {
	width: 450px;
	height: 580px;
	background-color: rgba(11, 11, 11, 0.3);
	margin: 20px auto 0;
	padding-top: 20px;
}

#jactionp {
	width: 100%;
	padding-bottom: 25px;
}

#jactionp p {
	width: 450px;
	padding-bottom: 20px;
}

.jtitle {
	display: block;
	width: 430px;
	height: 30px;
	padding: 0 10px;
	color: #00FFFF;
}

#jactionp p input {
	width: 400px;
	height: 35px;
	lineheight: 35px;
	margin: 0 10px;
	padding: 0 15px;
	border: 1px solid #82E0AA;
	border-radius: 10px;
	box-shadow: none;
}

#join_pw .jpw1, #join_pw .jpw2 {
	margin-bottom: 10px;
}

#jsubb {
	width: 430px;
	padding: 0 10px;
}

#join_join {
	width: 428px;
	height: 38px;
	cursor: pointer;
	background-color: #82E0AA;
	box-shadow: none;
	border: 1px solid #82E0AA;
	border-radius: 10px;
	letter-spacing: 10px;
	font-size: 16px;
	margin-bottom: 10px;
	transition: 0.3s;
}

#join_join:hover {
	background-color: #84D0CA;
	color: #eee;
}

#jsarea {
	width: 100%;
	text-align: center;
	position: relative;
}

#join_reset {
	position: absolute;
	top: 0;
	left: 0;
	cursor: pointer;
}

#join_index {
	color: #eee;
	text-decoration: none;
	font-size: 12px;
	transition: 0.3s;
}

#join_index:hover {
	color: blue;
	letter-spacing: 6px;
}
</style>
</head>
<body>
	<%@ include file="./menu.jsp"%>
	<!-- 페이지 포함시키기 -->
	<h2>JOIN US!</h2>
	<div id="join_page">
		<form action="./joinAction" method="post">
			<div id="jactionp">
				<p id="join_id">
					<span class="jtitle">아이디</span> <input type="text" name="id"
						required>
				</p>
				<p id="join_name">
					<span class="jtitle">닉네임</span> <input type="text" name="name"
						required>
				</p>
				<p id="join_pw">
					<span class="jtitle">비밀번호</span> <input type="password" id="pw1"
						name="pw" class="jpw1" placeholder="비밀번호를 입력해주세요" required>
					<input type="password" id="pw2" class="jpw2" placeholder="비밀번호 확인"
						required onchange="isSame()"> &nbsp;&nbsp;<span id="same"></span>
				</p>
				<p id="join_email">
					<span class="jtitle">이메일</span> <input type="email" name="email"
						required>
				</p>
			</div>
			<div id="jsubb">
				<button type="submit" id="join_join">가입하기</button>
				<p id="jsarea">
					<button type="reset" id="join_reset">reset</button>
					<a href="./index.jsp" id="join_index">로그인하러가기</a>
				</p>
			</div>
		</form>
	</div>
</body>
</html>
<script type="text/javascript">
	function isSame() {
		if (document.getElementById('pw1').value != '' && document.getElementById('pw2').value != '') {
			if (document.getElementById('pw1').value == document.getElementById('pw2').value) {
				document.getElementById('same').innerHTML = '비밀번호가 일치합니다.';
				document.getElementById('same').style.color = '#BCE6D7';
			} else {
				document.getElementById('same').innerHTML = '비밀번호가 일치하지 않습니다.';
				document.getElementById('same').style.color = '#FFFF66';
			}
		}
	}
</script>