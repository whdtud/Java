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

@WebServlet("/idpw")
public class Idpw extends HttpServlet {
	private static final long serialVersionUID = 1L;
    LoginDAO dao = new LoginDAO();
    
    public Idpw() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("./idpw.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//디스패쳐
		RequestDispatcher rd = request.getRequestDispatcher("./idpw.jsp");
		if(request.getParameter("email") != null) {			
			//오는 값 잡아주세요.
			String email = request.getParameter("email");
			//DAO통해서 서버에 질의 = ID값이 와야합니다.
			String result = dao.idpw(email);
			
			if(result != null) {
				request.setAttribute("result", "1");//아이디 찾기
				request.setAttribute("id", result);
			} else {
				//id찾기를 했으나 결과값이 없습니다.
				request.setAttribute("result", "2");//그런 id없음
			}
			
		} else if(request.getParameter("id") != null 
				&& request.getParameter("name") != null
				&& request.getParameter("pw1") != null
				&& request.getParameter("pw2") != null
				&& request.getParameter("pw1").equals(request.getParameter("pw2"))
				) {
			//비밀번호 설정 DTO
			LoginDTO dto = new LoginDTO();
			dto.setId(request.getParameter("id"));
			dto.setName(request.getParameter("name"));
			dto.setPw(request.getParameter("pw1"));

			int result = dao.passwordReset(dto);//DAO
			//성공했다면 보낼 페이지
			if(result == 1) {
				request.setAttribute("result", "3");//정상적으로 변경함
			} else {
				//변경불가라면
				request.setAttribute("result", "4");//변경 불가!!!
			}
			//이럴거라면 rd를 최상단에서 생성하고
			//setAttrobute()값만 다르게 해서
			//전송하는 것이 더 좋습니다.. ㅜㅜ
			
		} else {
			//오는 값이 없으면 던지기
			//response.sendRedirect("./idpw.jsp");
			request.setAttribute("result", "5");//오는 값이 잘못되었습니다.
		}
		rd.forward(request, response);
		
	}

}
