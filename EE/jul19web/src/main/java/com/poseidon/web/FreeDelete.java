package com.poseidon.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poseidon.dao.BoardDAO;
import com.poseidon.util.Util;

@WebServlet("/freeDelete")
public class FreeDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("id") != null && request.getParameter("fno") != null && Util.str2Int2(request.getParameter("fno")) != 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", session.getAttribute("id"));
			map.put("fno", request.getParameter("fno"));
			
			BoardDAO dao = BoardDAO.getInstance();
			int result = dao.freeDelete(map);
			if(result == 1) {
				response.sendRedirect("./index");
			}else {
				response.sendRedirect("./error?code=freeDelete");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
