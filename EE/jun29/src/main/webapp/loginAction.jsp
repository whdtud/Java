<%@page import="com.poseidon.dto.LoginDTO"%>
<%@page import="com.poseidon.dao.LoginDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>loginAction.jsp</title>
</head>
<body>
	<h1>loginAction</h1>
	<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	%>
	
	입력한 id는 <%=id %>입니다.<br>
	입력한 pw는 <%=pw %>입니다.<br>
	
	해야 할 일
	id/pw값을 자바로 보내기 LoginDAO/LoginDTO
	java는 db에 물어보기
	db는 결가 값을 java에게 줍니다.
	java는 받은 데이터를 판별하여
	jsp에 찍어줍니다.
	<hr>
	<%
	LoginDAO dao = new LoginDAO();
	//자바로 보낼 데이터 만들기
	LoginDTO dto = new LoginDTO();
	dto.setId(id);
	dto.setPw(pw);
	
	dto = dao.login(dto);
	//그 잘못의 시작은 여기서부터 였을까...
	
	%>
	
	<h1>로그인 후 </h1>
	번호 : <%=dto.getNo() %><br>
	이름 : <%=dto.getName() %><br>
	id : <%=dto.getId() %><br>
	pw : <%=dto.getPw() %><br>
	email : <%=dto.getEmail() %><br>
	<hr>
	올바른 사용자라면 ~~~님 반갑습니다.
	잘못된 사용자라면 로그인 해주세요 라고 뜨게 해보겠습니다 
	<hr>
	<%
	if(dto.getName() == null){
		// 여긴 고민 좀 해봐야겠습니다.
	%>	
		로그인 해주세요.
	<%
		//여기 자바코드
		response.sendRedirect("./login.jsp");
	}else{
	%>
		<%=dto.getName() %>님 반갑습니다.
		
	<%	
		//여기 자바코드
		response.sendRedirect("./board.jsp");
		//이 파일 안에서 자바를 제외한 html/css/js는 모두 삭제하겠습니다.
	}
	
	
	
	
	%>
	
	자바코드를 열기 위해서는 < % 입니다. === % >한 쌍
	값 하나 찍어주기 위해서는  < % = 입니다. === % >한쌍
	
	
	
	
	
	
	
	
	
	
</body>
</html>