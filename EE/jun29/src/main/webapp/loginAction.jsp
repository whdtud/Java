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
	
	�Է��� id�� <%=id %>�Դϴ�.<br>
	�Է��� pw�� <%=pw %>�Դϴ�.<br>
	
	�ؾ� �� ��
	id/pw���� �ڹٷ� ������ LoginDAO/LoginDTO
	java�� db�� �����
	db�� �ᰡ ���� java���� �ݴϴ�.
	java�� ���� �����͸� �Ǻ��Ͽ�
	jsp�� ����ݴϴ�.
	<hr>
	<%
	LoginDAO dao = new LoginDAO();
	//�ڹٷ� ���� ������ �����
	LoginDTO dto = new LoginDTO();
	dto.setId(id);
	dto.setPw(pw);
	
	dto = dao.login(dto);
	//�� �߸��� ������ ���⼭���� ������...
	
	%>
	
	<h1>�α��� �� </h1>
	��ȣ : <%=dto.getNo() %><br>
	�̸� : <%=dto.getName() %><br>
	id : <%=dto.getId() %><br>
	pw : <%=dto.getPw() %><br>
	email : <%=dto.getEmail() %><br>
	<hr>
	�ùٸ� ����ڶ�� ~~~�� �ݰ����ϴ�.
	�߸��� ����ڶ�� �α��� ���ּ��� ��� �߰� �غ��ڽ��ϴ� 
	<hr>
	<%
	if(dto.getName() == null){
		// ���� ��� �� �غ��߰ڽ��ϴ�.
	%>	
		�α��� ���ּ���.
	<%
		//���� �ڹ��ڵ�
		response.sendRedirect("./login.jsp");
	}else{
	%>
		<%=dto.getName() %>�� �ݰ����ϴ�.
		
	<%	
		//���� �ڹ��ڵ�
		response.sendRedirect("./board.jsp");
		//�� ���� �ȿ��� �ڹٸ� ������ html/css/js�� ��� �����ϰڽ��ϴ�.
	}
	
	
	
	
	%>
	
	�ڹ��ڵ带 ���� ���ؼ��� < % �Դϴ�. === % >�� ��
	�� �ϳ� ����ֱ� ���ؼ���  < % = �Դϴ�. === % >�ѽ�
	
	
	
	
	
	
	
	
	
	
</body>
</html>