<%@page import="com.poseidon.dto.BoardDTO"%>
<%@page import="com.poseidon.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>detail</title>
<style type="text/css">
table{
	border: 1px gray solid;
	
	border-collapse: collapse;
 	/* ���̺��� ���� �����ݴϴ�. */
}
#gray{
	background-color: gray;
}
</style>
</head>
<body>
	<h1>detail</h1>
	<%
	//�Ķ���ͷ� ������ ���� ������ �����ϱ�
	String bno = request.getParameter("bno");
	//int?
	int str2Int = Integer.parseInt(bno);
	//detail�� bno�� �ش��ϴ� ���ڵ�
	//�ϳ��� ȭ�鿡 ����ؾ� �մϴ�.
	//�����ͺ��̽����� ����
	//jsp -> java -> db -> java -> jsp
	//DAO�� Ȱ���ؼ� ������
	//DAO�� detail(int)�̶�� �޼ҵ� ������ֱ� 
	
	//��ü �����ؼ� �� �޾ƿ���
	BoardDAO dao = new BoardDAO();
	BoardDTO dto = dao.detail(str2Int);
	
	%>

	���۵� bno = <%=str2Int %>
	<br>
	1. getP~ = ?����ǥ �ڿ� ���� �̸�=���� ����ϴ�.
	detail.jsp?no=12
	�̸��� no, ��12
	<hr>
	<table style="width: 300px; margin: 0 auto;">
		<tr>
			<td colspan="2" style="border-bottom: 4px solid skyblue;">
			<%=dto.getBtitle() %>
			</td>
		</tr>
		<tr>
			<td id="gray"><%=dto.getName() %>(<%=dto.getId() %>)
			</td>
			<td id="gray"><%=dto.getBcount() %></td>
		</tr>
		<tr>
			<td id="gray"><%=dto.getBdate() %></td>
			<td id="gray"></td>
		</tr>
		<tr>
			<td colspan="2" style="height: 100px; border-top: 1px solid gray;">
			<%=dto.getBcontent() %>
			</td>
		</tr>	
	</table>
	
	<button onclick="location.href='./board.jsp'">����Ʈ��</button>
	<input type="button" value="����Ʈ��">
	
	
	
	
	
		
	
</body>
</html>