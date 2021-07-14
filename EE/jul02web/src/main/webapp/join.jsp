<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% 
 if(request.getParameter("error") != null){
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
*{padding:0; margin:0;}
h2{text-align:center;font-size:30px;padding:30px 0;letter-spacing:10px;}
#join_page{
	width:450px;
	min-height:580px;
	background-color:rgba(11,11,11,0.3);
	margin:20px auto 0;
	padding-top:20px;
	position:relative;
}
	#check_id{
		width:60px;
		position:absolute;
		top:51px;left:381px;
		cursor:pointer;
		height:35px;
		line-height:35px;
		border-radius: 0 10px 10px 0;
		border:none;
		border-left:2px solid #82E0AA;
		box-shadow: none;
		background-color: white;
		transition:0.3s;
	}
		#check_id:hover{
			background-color:#D6EAF8;
		}
	#jactionp{
		width:100%;
		padding-bottom:25px;
	}
		#jactionp .join_p{
			width:450px;
			padding-bottom:20px;
		}	
			.jtitle{
				display:block;
				width:430px;
				height:30px;
				padding:0 10px;
				color:#00FFFF;
			}
			#jactionp p input{
				width:400px;
				height:35px;
				line-height:35px;
				margin: 0 10px;
				padding:0 15px;
				border:1px solid #82E0AA;
				border-radius: 10px;
				box-shadow: none;
			}
			#birth_p{
				width:400px;
				height:35px;
				padding:0 15px;
			}
			
			#join_pw .jpw1, #join_pw .jpw2{
				margin-bottom:10px;
			}
	#jsubb{
		width:430px;
		padding:10px;
	}
		#join_join{
			width:428px;
			height:38px;
			cursor:pointer;
			background-color:#82E0AA;
			box-shadow: none;
			border:1px solid #82E0AA;
			border-radius: 10px;
			letter-spacing:10px;
			font-size:16px;
			margin-bottom:10px;
			transition:0.3s;
		}
		#join_join:hover{background-color:#84D0CA;color:#eee;}
		#jsarea{width:100%;text-align:center;position:relative;}
		#join_reset{position:absolute; top:0;left:0;cursor:pointer;border:none;width:40px;height:25px;transition:0.3s;background-color:rgba(11,11,11,0);color:#eee;}
		#join_reset:hover{background-color:#eee;color:black;}
		#join_index{color:#eee;text-decoration:none;font-size:12px;transition:0.3s;}
		#join_index:hover{color:blue;letter-spacing:6px;}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<script type="text/javascript">
function isSame() {
    if(document.getElementById('pw1').value !='' && document.getElementById('pw2').value !='') {
        if(document.getElementById('pw1').value == document.getElementById('pw2').value) {
            document.getElementById('same').innerHTML='비밀번호가 일치합니다.';
            document.getElementById('same').style.color='#BCE6D7';
        }
        else {
            document.getElementById('same').innerHTML='비밀번호가 일치하지 않습니다.';
            document.getElementById('same').style.color='#FFFF66';
        }
    }
}
function join(){
	//alert("들어옵니다.");
	var id = document.getElementById("id");
	var name = document.getElementById("name");
	var pw1 = document.getElementById("pw1");
	var pw2 = document.getElementById("pw2");
	var email = document.getElementById("email");
	//암호도 잡아주세요. email도 잡아주세요 
	//년월일 잡기
	var year = document.getElementById("year");
	var month = document.getElementById("month");
	var day = document.getElementById("day");
	
	var date2 = document.getElementById("date2");
	//alert(date2.value);
	
	//alert(id.value + " : " + name.value);
	//alert(pw1.value + " : " + pw2.value);
	//alert(email.value);
	
	//id가 없거나, 3글자 이하라면 
	if(id.value == "" || id.value.length < 4){
		alert("아이디를 입력하세요.");
		id.focus();//마우스 커셔를 해당 위치로 이동
		id.style.backgroundColor = '#F5B7B1';
		return false;
	}
	if(name.value == "" || name.value.length < 3){
		alert("닉네임을 입력하세요.");
		name.focus();
		name.style.backgroundColor = '#F5B7B1';
		return false;
	}
	//pw1
	if(pw1.value == "" || pw1.value.length < 4){
		alert("올바른 암호를 입력하세요.");
		pw1.focus();
		return false;
	}
	//pw2
	if(pw2.value == "" || pw2.value.length < 4){
		alert("올바른 암호를 입력하세요.");
		pw2.focus();
		return false;
	}
	if(pw1.value != pw2.value){
		alert("같은 비밀번호를 입력하세요.");
		pw1.value = "";//input값 지우기
		pw2.value = "";
		pw1.style.backgroundColor = '#F5B7B1';
		pw2.style.backgroundColor = '#F5B7B1';
		pw1.focus();
		return false;
	}
	if(email.value == ""){
		alert("email을 입력하세요.");
		email.style.backgroundColor = '#F5B7B1';
		email.focus();
		return false;
	}
	if(date2.value == ""){
		alert("생년월일을 입력하세요.");
		date2.style.backgroundColor = '#F5B7B1';
		date2.focus();
		return false;
	}
	//return false;//더이상 동작을 진행하지 않습니다.
	//여기에 있으면 안 됩니다. 작업 완료 후 지워주세요.
}

//html이 로딩 되고 바로 가입버튼 비활성화 하기
$(function(){
	$("#join_join").prop("disabled", true);
	$("#resultText").css("color", "red");
});//end

function checkID(){
	//var id = $(선택자).명령();
	var id = $("#id").val();
	//alert(id);
	if(id == "" || id.length < 4){
		alert("아이디를 입력해주세요.");
		$("#id").focus();
		return false;
	}
	$.ajax({
		type:'post',
		dataType:'text',
		data: 'id='+id,
		url: './idCheck',
		success: function(rData, textStatus, xhr){
			//var checkResult = rData;
			//alert("성공 : " + checkResult);
			if(rData == 1){
				alert(id + "는 이미 등록되어 있습니다.");
				$("#join_join").prop("disabled", true);//비활성화
				$("#resultText").css("color", "red");
				$("#resultText").text(id + "는 이미 등록되어 있습니다.");
				
			}else{
				alert(id + "는 가입 할 수 있습니다.");
				$("#join_join").prop("disabled", false);//활성화
				$("#resultText").css("color", "blue");
				$("#resultText").text(id + "는 가입 할 수 있습니다.");
			}
		},
		error: function(xhr, status, e){
			alert("문제 발생 : " + e);
		}
	});
}
</script>
<body>
	<%@ include file="./menu.jsp"%>
	<!-- 페이지 포함시키기 -->
	<h2>JOIN US!</h2>
	<div id="join_page">
		<button onclick="return checkID()" id="check_id">중복확인</button>
		<form action="./joinAction" method="post" onsubmit="return join()">
			<div id="jactionp">
				<p id="join_id" class="join_p">
					<span class="jtitle">아이디</span>
					<input type="text" name="id" id="id" onchange="checkID()">
				</p>
				<p id="join_name" class="join_p">
					<span class="jtitle">닉네임</span>
					<input type="text" name="name" id="name">
				</p>
				<p id="join_pw" class="join_p">
					<span class="jtitle">비밀번호</span>
					<input type="password" id="pw1" name="pw1" class="jpw1" placeholder="비밀번호를 입력해주세요" >
					<input type="password" id="pw2" name="pw2" class="jpw2" placeholder="비밀번호 확인"   onchange="isSame()">
					&nbsp;&nbsp;<span id="same"></span>
				</p>
				<p id="join_email" class="join_p">
					<span class="jtitle">이메일</span>
					<input type="email" name="email" id="email" >
				</p>
				<p id="join_birth" class="join_p">
					<span class="jtitle">생일</span>
					<input type="date" name="date2" id="date2">
					<!--<p id="birth_p">
						<select name="year" id="year">
							<option>년도 선택</option>
							<%for(int i = 2021; i > 1970; i--){ %>
							<option value="<%=i%>"><%=i %></option>
							<%} %>
						</select>
						<select name="month" id="month">
							<option>월선택</option>
							<%for(int i = 1; i < 13; i++){ %>
							<option value="<%=i%>"><%=i %></option>
							<%} %>
						</select>
						<select name="day" id="day">
							<option>일선택</option>
							<%for(int i = 1; i < 32; i++){ %>
							<option value="<%=i%>"><%=i %></option>
							<%} %>
						</select>
					</p>-->
				</p>
			</div>
			<div id="jsubb">
				<p id="resultText">ID중복확인을 먼저 실행하셔야 가입가능합니다.</p>
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