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

@WebServlet("/writeAction")
public class WriteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>로그인하세요</title>");
		pw.println("<meta charset=\"UTF-8\">");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1>로그인하세요</h1>");
		pw.println("<a href=\"./index.jsp\">로그인하러가기</a>");		
		pw.println("<script>alert('로그인하세요!');</script>");
		pw.println("</body>");
		pw.println("</html>");
		//response.sendRedirect("");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();//올라왔습니다.
		//만약 타이틀, 본문, id가 없다면 로직 빠져나가기
		if(request.getParameter("title") == null 
				|| request.getParameter("title").length() < 5
				|| request.getParameter("content") == null 
				|| request.getParameter("content").length() < 5
				|| session.getAttribute("id") == null
				|| session.getAttribute("name") == null
				) {
			response.sendRedirect("./index.jsp");
			
		//모든 데이터가 있을때  = DB로 보내서 저장하기
		}else {
			//한글처리
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			//회원 ID받아오기
			//여기서 세션으로 id가져오시면 됩니다. 
			//변수에 저장해주세요.
			String id = (String) session.getAttribute("id");
			//오늘 드린 책은 읽어봐주세요.
			//가지고 오지 않으셔도 됩니다. 
			
			System.out.println("title : " + title);
			System.out.println("content : " + content);
			System.out.println("id : " + id);
			
			//<, >, / 치환하기
			title = title.replaceAll("<", "&lt;");
			title = title.replaceAll(">", "&gt;");
			title = title.replaceAll("/", "&#47;");			
			//글쓰기, 수정하기, 회원가입
			
			//boarddto에 담기
			BoardDTO dto = new BoardDTO();
			dto.setBtitle(title);
			dto.setBcontent(content);
			dto.setId(id);
			
			//dao에게 일 시키기
			BoardDAO dao = new BoardDAO();
			//insert(dto);
			dao.insert(dto);
			
			//board로 전환하기
			response.sendRedirect("./board.jsp");			
		}
		
		
		
		
		
		
	}

}
