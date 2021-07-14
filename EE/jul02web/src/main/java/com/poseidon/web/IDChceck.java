package com.poseidon.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poseidon.dao.LoginDAO;

@WebServlet("/idCheck")
public class IDChceck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IDChceck() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//막아주세요.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("요청 들어왔습니다.");
		//보완하겠습니다.
		int result = 1;//있다 = 1 = 무조건 1로 만들기
		String id = request.getParameter("id");
		//response.getWriter().write(1);//아이디가 있으면 1
		//System.out.println(id);
		//DAO에게 결과값 받아오게 일 시키기
		LoginDAO dao = new LoginDAO();
		result = dao.idCheck(id);//아이디가 없다면 0 
		
		PrintWriter pw = response.getWriter();
		pw.print(result);
	}

}
