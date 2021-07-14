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

@WebServlet("/changepw")
public class ChangePW extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChangePW() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("pw"));
		// 값 오는지 확인해주세요.
		// 값 온다면 다음에 할 일은?
		// 세션 가져오기
		HttpSession session = request.getSession();
		if (session.getAttribute("id") != null && request.getParameter("pw") != null) {
			// pw저장하기
			// DAO에 보내기
			LoginDAO dao = new LoginDAO();
			LoginDTO dto = new LoginDTO();
			dto.setId((String) session.getAttribute("id"));
			dto.setPw(request.getParameter("pw"));
			dto.setName((String) session.getAttribute("name"));// 추가

			int result = dao.passwordReset(dto);
			// 결과값 받아서 출력하기
			// System.out.println("결과값은 : " + result);
			response.sendRedirect("./ok.jsp");// 성공
		} else {
			// 세션이 없거나 pw가 안 들어왔다면
			response.sendRedirect("./error.jsp");//
		}
	}

}
