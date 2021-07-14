package com.poseidon.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poseidon.dao.LoginDAO;
import com.poseidon.dto.LoginDTO;

@WebServlet("/join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Join() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터를 잡아주세요.
		//한글처리
		
		//if 모두 들어온다면 다음작업으로
		if(request.getParameter("id") != null 
				&& request.getParameter("name") != null
				&& request.getParameter("pw1") != null
				&& request.getParameter("pw2") != null
				&& request.getParameter("email") != null
				&& request.getParameter("pw1").equals(request.getParameter("pw2"))
				) {
			
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String pw1 = request.getParameter("pw1");
			//String pw2 = request.getParameter("pw2");
			String email = request.getParameter("email");
			String date2 = request.getParameter("date2");
			
			//System.out.println(id + " : " + name + " : " + email);
			//System.out.println("pw : " + pw1 + " : " + pw2);
			
			//<, >, / 치환하기
			name = name.replaceAll("<", "&lt;");
			name = name.replaceAll(">", "&gt;");
			name = name.replaceAll("/", "&#47;");
			//글쓰기, 수정하기, 회원가입
			
			//DAO로 보내기 -> DTO에 담아주세요.
			LoginDTO dto = new LoginDTO();
			dto.setId(id);
			dto.setName(name);
			dto.setPw(pw1);//단, pw1만 담아주세요.
			dto.setEmail(email);
			dto.setDate2(date2);//여기에 생년 월 일 있습니다.
			//DB작업하기
			LoginDAO dao = new LoginDAO();
			int count = dao.join(dto);//DAO join메소드로 보냅니다
			//가입이 완료되었다면 성공페이지로
			//System.out.println(count + "개 완료");
			
			RequestDispatcher rd 
					= request.getRequestDispatcher("./joinResult.jsp");
			request.setAttribute("count", count);
			request.setAttribute("id", id);
			
			rd.forward(request, response);
			
			//RequestDispatcher rd = request.getRequestDispatcher("이동할 페이지");
			//request.setAttribute("호출할 이름", "보낼 값");
			//rd.forward(request, response);
			
			
		} else {
			response.sendRedirect("error.jsp?error=5985");
		}
		
		
		
	}

}
