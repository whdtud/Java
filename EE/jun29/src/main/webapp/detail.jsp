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
 	/* 테이블에서 공백 없애줍니다. */
}
#gray{
	background-color: gray;
}
</style>
</head>
<body>
	<h1>detail</h1>
	<%
	//파라미터로 들어오는 값을 변수에 저장하기
	String bno = request.getParameter("bno");
	//int?
	int str2Int = Integer.parseInt(bno);
	//detail은 bno에 해당하는 레코드
	//하나를 화면에 출력해야 합니다.
	//데이터베이스에게 질의
	//jsp -> java -> db -> java -> jsp
	//DAO를 활용해서 보내기
	//DAO에 detail(int)이라는 메소드 만들어주기 
	
	//객체 생성해서 값 받아오기
	BoardDAO dao = new BoardDAO();
	BoardDTO dto = dao.detail(str2Int);
	
	%>

	전송된 bno = <%=str2Int %>
	<br>
	1. getP~ = ?물음표 뒤에 오는 이름=값을 잡습니다.
	detail.jsp?no=12
	이름을 no, 값12
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
	
	<button onclick="location.href='./board.jsp'">리스트로</button>
	<input type="button" value="리스트로">
	
	
	
	
	
		
	
</body>
</html>