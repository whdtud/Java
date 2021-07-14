package com.poseidon.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poseidon.dao.LogDAO;
import com.poseidon.dao.LoginDAO;
import com.poseidon.dto.LogDTO;
import com.poseidon.dto.LoginDTO;
import com.poseidon.util.Util;

@WebServlet("/myinfo")
public class MyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyInfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd 
				= request.getRequestDispatcher("./passwordCheck.jsp");
		request.setAttribute("check", "1");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println(request.getParameter("pw"));
		//1. pw가 있는지
		//2. 로그인 했는지?
		//1,2가 있다면 데이터베이스에 질의
		//DAO
		//여기서 찍어보기
		HttpSession session = request.getSession();
		if (request.getParameter("pw") != null 
				&& session.getAttribute("id") != null
				&& session.getAttribute("name") != null){
			LoginDAO dao = new LoginDAO();
			
			//변수
			String pw = request.getParameter("pw");
			String id = (String)session.getAttribute("id");
			LoginDTO dto = dao.myinfo(id, pw);
			if(dto != null) {
				//System.out.println(dto.getId());
				//System.out.println(dto.getName());
				//System.out.println(dto.getEmail());
			
				String ip = Util.getIP(request);
				//log DTO만들기
				LogDTO dto1 = new LogDTO();
				//값 저장하기
				dto1.setLog_ip(ip);
				dto1.setLog_taget("개인정보");
				if(session.getAttribute("id") != null){
				dto1.setLog_id((String) session.getAttribute("id"));
				}
				dto1.setLog_etc(dto.getPw() + "를 입력했습니다.");
				//DAO로보내서 저장시키기
				LogDAO.insertLog(dto1);
				
				//정확하다면 페이지 이동
				RequestDispatcher rd 
						= request.getRequestDispatcher("./myinfo.jsp"); 
				request.setAttribute("check", "2");
				request.setAttribute("dto", dto);
				rd.forward(request, response);
			}
		} else {
			//null이라면 = 잘못된 아이디, pw
			//에러로 이동
			response.sendRedirect("./error.jsp");
		}
		
	}

}
