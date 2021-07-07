package com.poseidon.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poseidon.dao.BoardDAO;
import com.poseidon.dto.BoardDTO;
import com.poseidon.util.Util;


@WebServlet("/update2")
public class Update2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BoardDAO dao;
    
    public Update2() {
        super();
        dao = new BoardDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리해주세요.
		response.setContentType("text/html;charset=UTF-8");
		//session만들어주세요.
		HttpSession session = request.getSession();
		if(session.getAttribute("id") != null
				&& session.getAttribute("name") != null 
				&& request.getParameter("bno") != null
				&& Util.str2Int2(request.getParameter("bno")) != 0) {
			//로그인 한 상태이고, bno가 숫자인 상태
			//여기서 작업
			//bno오는지 확인
			int bno = Util.str2Int(request.getParameter("bno"));
			//System.out.println("오는 데이터는 : " + bno);
			String id = (String) session.getAttribute("id");
			//bno를 데이터베이스로 보내서 글 얻어오기
			
			BoardDTO dto = dao.update(bno, id);
			//화면에 출력
//			System.out.println(dto.getBno());
//			System.out.println(dto.getBtitle());
//			System.out.println(dto.getBcontent());
//			System.out.println(dto.getId());
			
			if(dto != null) {
				//데이터베이스에서 리턴된 객체가 있다면 화면그리기
				PrintWriter pw = response.getWriter();
				pw.println("<html>");
				pw.println("<head>");
				pw.println("<title>수정하기</title>");
				pw.println("<meta charset=\"UTF-8\">");
				pw.println("<link href=\"https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
						+ "<script src=\"https://code.jquery.com/jquery-3.5.1.min.js\"></script>\r\n"
						+ "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\r\n"
						+ "<link href=\"./summernote/summernote.min.css\" rel=\"stylesheet\">\r\n"
						+ "<script src=\"./summernote/summernote.min.js\"></script>");
				pw.println("<style type=\"text/css\">\r\n"
						+ "body {margin: 0;padding: 0;}\r\n"
						+ "#write {min-height: 500px;width: 800px;background-color: gray;margin: 0 auto;padding: 10px;}\r\n"
						+ "#title {width: 100%;height: 30px;margin-bottom: 10px;}\r\n"
						+ "#content {width: 100%;height: 400px;margin-bottom: 10px;}\r\n"
						+ "#sub {width: 100%;height: 35px;background-color: #82E0AA;color: olive;font-size: large;border: 1px solid #82E0AA;\r\n"
						+ "}\r\n"
						+ "</style>");
				pw.println("</head>");
				pw.println("<body>");
				pw.println("<style type=\"text/css\">"
						+ "body {margin: 0;padding: 0;}\r\n"
						+ "#menu {width: 100%;height: 50px;background-color: black;overflow: hidden;}\r\n"
						+ "#navi {float: left;width: calc(100% - 200px);height: 50px;}\r\n"
						+ "ul {list-style-type: none;margin: 0;padding: 0;height: 50px;}\r\n"
						+ "li {float: left;margin: 0 10px;}\r\n"
						+ "li a {display: block;color: white;font-family: \"맑은 고딕\";font-size: 12pt;text-align: center;padding: 15px;text-decoration: none;}\r\n"
						+ "#logo {vertical-align: bottom;}\r\n"
						+ "#menusession {float: right;width: 200px;height: 50px;color: white;line-height: 50px;font-weight: bold;text-align: right;overflow: hidden;}\r\n"
						+ "#menusession a{color: white;text-decoration: none;}\r\n"
						+ "#menusession img{vertical-align: text-bottom;}\r\n"
						+ "</style>\r\n"
						+ "<div id=\"menu\">\r\n"
						+ "	<div id=\"navi\">\r\n"
						+ "		<ul>\r\n"
						+ "			<li><a href=\"./index.jsp\"><img alt=\"apple\" src=\"./apple.png\" id=\"logo\"></a></li>\r\n"
						+ "			<li><a href=\"./board.jsp\">board</a></li>\r\n"
						+ "			<li><a href=\"./freeboard.jsp\">free</a></li>\r\n"
						+ "			<li><a href=\"./notice.jsp\">notice</a></li>\r\n"
						+ "			<li><a href=\"./shop.jsp\">shop</a></li>\r\n"
						+ "		</ul>\r\n"
						+ "	</div>\r\n"
						+ "	<div id=\"menusession\">");
			pw.println("");
			if(session.getAttribute("name") != null) {
				pw.println("<img alt=\"login\" src=\"./open.png\" onclick=\"return logout();\">\r\n");
				pw.println(session.getAttribute("name") + "님 반갑습니다.\r\n");
				
			}else {				
				pw.println("<a href=\"./index.jsp\">로그인 해주세요.<img alt=\"login\" src=\"./lock.png\"></a>\r\n");
			}
			pw.println("</div>\r\n");
			pw.println("</div>\r\n");
			pw.println("<script>\r\n"
			+ "function logout(){\r\n"
			+ "	//alert(\"로그아웃을 눌렀습니다.\");\r\n"
			+ "	var name = '"+session.getAttribute("name")+"';\r\n"
			+ "	if(confirm(name + \"님, 로그아웃 하시겠습니까?\")){\r\n"
			+ "		alert(\"로그아웃 하겠습니다.\");\r\n"
			+ "		location.href=\"./logout\";\r\n"
			+ "	}else{\r\n"
			+ "		alert(\"취소합니다.\");\r\n"
			+ "	}\r\n"
			+ "}\r\n"
			+ "</script>");
			pw.println("");
//				pw.println("<%@ include file=\"./menu.jsp\"%>");
				pw.println("<h1>수정하기</h1>");
				pw.println("<div id=\"write\">");
				pw.println("<form action=\"update\" method=\"post\">");
				pw.println("<input type=\"text\" name=\"title\" id=\"title\" value=\""+dto.getBtitle()+ "\">");
				pw.println("<textarea name=\"content\" id=\"content\">"+dto.getBcontent()+"</textarea>");
				pw.println("<button id=\"sub\" type=\"submit\">글쓰기</button>");
				pw.println("</form>");
				pw.println("</div>");				
				pw.println("<script type=\"text/javascript\">\r\n"
						+ "		$(document).ready(function() {\r\n"
						+ "			$('#content').summernote({\r\n"
						+ "				height : 400\r\n"
						+ "			});\r\n"
						+ "		});\r\n"
						+ "	</script>");
				pw.println("</body>");
				pw.println("</html>");
			}else {
				
			}
			
		}else {
			//로그인 하지 않았거나, bno가 없거나, bno가 숫자가 아닌 경우
			//에러로 보내기
			response.sendRedirect("error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
	}

}
