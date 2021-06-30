<%@page import="com.whdtud.dao.LoginDAO"%>
<%@page import="com.whdtud.dto.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
LoginDTO dto = new LoginDTO();
	dto.setId(request.getParameter("id"));
	dto.setName(request.getParameter("name"));
	dto.setPw(request.getParameter("pw1"));
	dto.setEmail(request.getParameter("email"));
	
	LoginDAO dao = new LoginDAO();
	dto = dao.join(dto);
	if (dto != null) {
		System.out.println("successed");
		response.sendRedirect("./login.jsp?result=success");
	}
	else {
		System.out.println("failed");
		response.sendRedirect("./error.jsp?error=e3380");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>joinAction</title>
</head>
<body>
	<h1>joinAction</h1>
	id = <%=request.getParameter("id") %>
	name = <%=request.getParameter("name") %>
	pw1 = <%=request.getParameter("pw1") %>
	pw2 = <%=request.getParameter("pw2") %>
	email = <%=request.getParameter("email") %>
	
</body>
</html>