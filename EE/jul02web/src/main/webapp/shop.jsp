<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style type="text/css">
*{margin:0; padding:0;}
body{
  		background-image:url("./appleBack.jpg");
		background-position: center;
  		background-repeat: no-repeat;
  		background-size:auto;
  		height:100vh;
  		position:relative;
	}
#menu{
	position: fixed;
	z-index:100;
}
	#nav_remote{
		position:absolute;left:10px;top:12px;
		cursor:pointer;
	}
		#nav_remote span{display:block;border:1px solid skyblue;margin-bottom:5px;transition:all .5s; }
			#nav_remote .fs{width:8px;position:relative;top:3px;left:2px;}
			#nav_remote .ss{width:20px;}
			#nav_remote .ts{width:8px;margin-left:12px;position:relative;top:-3px;left:-2px;}
#nav{
	width: 300px;
	height:100vh;
	background-color:rgba(33,33,33,0.9);
	overflow:hidden;
}
#login_info{
	margin:0 auto;
	width:90%;
	height:40px;
	text-align:right;
	color:#fff;
	font-size:10px;
	line-height:40px;
	border-bottom:1px solid gray;
}
	#mname{
		font-size:12px;
		color:skyblue;
		text-decoration:underline;
	}
	#logout{
		color:skyblue;
		transition:0.4s;
		cursor:pointer;
		font-size:10px;
	}
	#logout:hover{
		color:white;
		font-weight:600;
	}
#menu_nav{
	list-style-type:none;
	width:100%;
	height:50px;
	margin:0 auto;
}
li{
	float:left;
	width:100%;
	text-align:center;
	height:50px;
	line-height:50px;
}
li a{
	display:block;
	color:white;
	text-align:conter;
	text-decoration:none;
	transition:0.4s;
}
li a:hover, li a:focus{color:#254A6C;}
#logo{
	display:inline-block;
	width:24px;
	padding-top:11px;
	vertical-align:top;
}
dl{width:100%;background-color:#ccc;}
dt{width:100%;height:27px; background-color:#ccc;  text-align:center; line-height:27px;cursor:pointer;}
dd{ width:96%; background-color:#333; color:#999; font-size:0.9em; padding:5px 2%;transition:all .5s; }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<div id="menu">
	<div id="nav_remote">
		<span class="fs"></span>
		<span class="ss"></span>
		<span class="ts"></span>
	</div>
	<div id="nav">
		<div id="login_info">
			<%
				if(session.getAttribute("name") != null){
			%>
				<span id="mname"><%=session.getAttribute("name") %></span>님 반갑습니다.
				<span id="logout" onclick="return logout()">로그아웃</span>
			<%
				}else{
			%>
				<a href="./index.jsp" id="logout">로그인해주세요.</a>
			<%
				}
			%>
		</div>
		<ul id="menu_nav">
			<li><a href="./index.jsp"><img src="./apple.png" alt="로고" id="logo"></a></li>
			<li><a href="./board.jsp" id="mboard">Board</a></li>
			<li><a href="./freeboard.jsp" id="mfreeboard">Free</a></li>
			<li><a href="./notice" id="mnotice">Notice</a></li>
			<li><a href="./shop.jsp" id="mshop">Shop</a></li>
			<%if(session.getAttribute("name") != null){ %>
			<li><a href="./myinfo" id="mmyinfo">My Info</a></li>
			<%} %>
			<li>
				<dl>
					<dt id="apple">애플(APPLE)</dt>
					<dd class="apple">
						<p>Iphone</p>
						<p>Ipad</p>
						<p>Imac</p>
					</dd>
					<dt id="sam">삼성(SAMSUNG)</dt>
					<dd class="sam">
						<p>Galaxy Note</p>
						<p>Galaxy S</p>
						<p>Galaxy Fold</p>
					</dd>
					<dt id="lg">엘지(LG)</dt>
					<dd class="lg">
						<p>단종</p>
						<p>안팔아요</p>
						<p>ㅠㅠ</p>
					</dd>
				</dl>
			</li>
		</ul>
	</div>
</div>
<script>
function logout(){
	//alert("로그아웃 성공!");
	var name = '<%=session.getAttribute("name")%>';
	//작은 따옴표가 있어야 자바에서 자바스크립트로 값을 줄 수 있다.
	if(confirm(name + "님, 로그아웃 하시겠습니까?")){
		alert("다음에 또 만나요!");
		//실제 로그아웃 호출하기
		location.href="./logout";
	}else{
		alert("믿고 있었다구~");
	}
}
$(document).ready(function(){
	$("#nav").hide();
	var check = "1";
	$("#nav_remote").click(function(){
		if(check == "1"){
			$("#nav").toggle(500, "swing");
			$("#nav_remote span").css("transform","rotate(45deg)");
			$("#nav_remote .ss").css("transform","rotate(135deg)");
			check="0";
		}else{
			$("#nav").toggle(500, "swing");
			$("#nav_remote span").css("transform","rotate(0deg)");
			check="1";
		}
	});
	$("dd").css({"display":"none"});
	$("dt").click(function(){
		$("dd").css({"display":"none"});
		$(this).next().css({"display":"block"});
	});
});
</script>