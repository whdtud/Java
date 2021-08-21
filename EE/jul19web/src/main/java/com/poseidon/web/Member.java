package com.poseidon.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poseidon.dao.LogDAO;
import com.poseidon.util.Util;

@WebServlet("/member")
public class Member extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LogDAO dao = LogDAO.getInstance();
       
    public Member() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Util.str2Int(request.getParameter("page"));
		}
		ArrayList<HashMap<String, Object>> list 
			= dao.memberList((page - 1) * 10);
		RequestDispatcher rd = request.getRequestDispatcher("member.jsp");
		request.setAttribute("list", list);
		request.setAttribute("ip", request.getParameter("ip"));
		request.setAttribute("target", request.getParameter("target"));
		
		if(list != null && list.size() > 0) {
			request.setAttribute(
					"totalCount", list.get(0).get("totalcount"));
		}
		request.setAttribute("page", page);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
