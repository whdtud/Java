package com.poseidon.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poseidon.dao.LoginDAO;
import com.poseidon.dto.LoginDTO;

@WebServlet("/loginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// UUID와 같이 찾아봐주세요.
	public LoginAction() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("get으로 요청이 들어왔습니다.");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//doGet(request, response);
		//System.out.println("post로 요청이 들어왔습니다.");
		//java 파일을 수정했으면 반드시 프로젝트를 다시 서버에 올려주세요.
		
		//한글처리
		response.setContentType("text/html;charset=UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//이것을 데이터베이스에 보내서 DBConnection / DTO / DAO
		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();
		dto.setId(id);
		dto.setPw(pw);
		LoginDTO result = dao.login(dto);
		
		//질의하고 PSTMT sql
		//결과 받고 ResultSet
		//결과 판정 if(){}
		//이동할 페이지로 이동시키기
		if(result != null && result.getName() != null) {
			//세션만들기 = 서버에 저장합니다.
			//해당 브라우저로 로그인한 사용자의 ID, name을 올립니다.
			HttpSession session = request.getSession();
			//session.getAttribute(""); 세션 가져오기
			//session.setAttribute(이름, 값)//세션 저장,만들기
			//세션만들기
			session.setAttribute("id", result.getId());
			session.setAttribute("name", result.getName());
			//no로 올릴 수도 있습니다.
			
			//session 출력해보기
			//System.out.println(session.getAttribute("id"));
			//System.out.println(session.getAttribute("name"));
			response.sendRedirect("./board.jsp");
		}else {
			response.sendRedirect("./index.jsp");
		}
		
		
		//System.out.println("ID : " + id + " PW : " + pw);
//		PrintWriter printw = response.getWriter();
//		printw.println("<html>");
//		printw.println("<head>");
//		printw.println("<meta charset=\"UTF-8\">");
//		printw.println("<title>loginAction</title>");
//		printw.println("</head>");
//		printw.println("<body>");
//		printw.println("<h1>Login Action</h1>");
//		printw.println("당신이 입력한 id는 " + id + "입니다.");
//		printw.println("당신이 입력한 pw는 " + pw + "입니다.");
//		printw.println("</body>");
//		printw.println("</html>");
		
		
		
		//꼭 기어해주셔야 할것
		//순수 자바 (POJO)에 web이 들어갑니다. = web작성 불편
		//		로직은 짜기 편해요.
		
		//이 페이지에는 html이 없습니다. send redirect만 있습니다.
		//.java파일을 수정했기 때문에 반드시 컴파일 해야 합니다.
		
		//MVC모델 ------ Spring
		//Model			데이터베이스와 관련된 일(DAO/DTO)
		//View			화면구성(jsp)
		//Controller	M/V를 조작합니다. / 사용자의 요청이 들어오면 처리
		
		
		
		
		
		
	}

}
