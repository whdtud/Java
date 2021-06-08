<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>list</h1>
	
	<ul type="circle">
		<li>소나무</li>
		<li>대나무</li>
		<li>사철나무</li>
	</ul>
	
	<ol type="1" type="I" start="5" reversed="reversed">
		<li>퇴근하기</li>
		<li>장보기</li>
		<li>요리하기</li>
		<li>청소하기</li>
		<li>잠자기</li>
	</ol>
	
	<ul>
		혼합목록
		<ol>
			<li>first</li>
			<li>second</li>
			<li>third</li>
		</ol>
		<li>41</li>
		<li>42</li>
		<li>43</li>
	</ul>
	
	<hr>
	<input type="text">
	<input type="password">
	<input type="number">
	<br>
	<input type="email">
	<input type="file">
	<br>
	<input type="date">
	<input type="range" max="10" min="1" value="5">
	<input type="reset">
	<input type="time">
	<input type="month">
	<input type="color">
	<input type="button">
	<button>button</button>
	
	<hr>
	<select>
		<option>사과</option>
		<option>배</option>
		<option>포도</option>
		<option>오렌지</option>
		<option>오이</option>
	</select>
	
	<a href="java.jsp">Java</a>
	
</body>
</html>