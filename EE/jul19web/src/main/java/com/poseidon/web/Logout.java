package com.poseidon.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poseidon.dao.LogDAO;
import com.poseidon.util.Util;

@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Logout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그아웃 하기 = 세션 끊기		
		HttpSession session = request.getSession();
		
		//log남기기
		HashMap<String, Object> log = new HashMap<String, Object>();
		log.put("ip", Util.getIP(request));
		log.put("id", session.getAttribute("id"));
		log.put("target", "logout");
		log.put("etc", request.getHeader("User-Agent"));
		LogDAO.insertLog(log);
		
		//로그 삭제하기
		if(session.getAttribute("id") != null){
			session.removeAttribute("id");
		}
		if(session.getAttribute("name") != null){
			session.removeAttribute("name");
		}
		if(session.getAttribute("grade") != null) {
			session.removeAttribute("grade");
		}
		//session.invalidate();// 해당 브라우져의 모든 세션 끊기
		
		//페이지 이동
		response.sendRedirect("./index");//다 서블릿계열로 보냅니다.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
