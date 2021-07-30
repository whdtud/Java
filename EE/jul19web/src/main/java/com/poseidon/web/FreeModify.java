package com.poseidon.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poseidon.dao.BoardDAO;
import com.poseidon.dao.LogDAO;
import com.poseidon.util.Util;

@WebServlet("/freeModify")
public class FreeModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardDAO dao = BoardDAO.getInstance();
       
    public FreeModify() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("id") != null && request.getParameter("fno") != null && Util.str2Int2(request.getParameter("fno")) != 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", session.getAttribute("id"));
			map.put("fno", request.getParameter("fno"));
			
			//BoardDAO dao = BoardDAO.getInstance();
			HashMap<String, Object> result = dao.freeModify(map);
			
			//log
			HashMap<String, Object> modify = new HashMap<String, Object>();
			modify.put("ip", Util.getIP(request));
			modify.put("target", "modify.jsp");
			modify.put("id", session.getAttribute("id") != null?session.getAttribute("id"):"");
			modify.put("etc", result.get("fcontent"));
			LogDAO.insertLog(modify);
			
			if(result != null) {
				RequestDispatcher rd = null;
				rd = request.getRequestDispatcher("freeModify.jsp");
				request.setAttribute("map", result);
				rd.forward(request, response);
			}else {
				response.sendRedirect("error?code=freeModify");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if(session.getAttribute("id") != null && request.getParameter("fno") != null && Util.str2Int2(request.getParameter("fno")) != 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", session.getAttribute("id"));
			map.put("fno", request.getParameter("fno"));
			map.put("ftitle", request.getParameter("title"));
			map.put("fcontent", request.getParameter("content"));
			
			int result = dao.freeModify2(map);
			//log
			HashMap<String, Object> modify = new HashMap<String, Object>();
			modify.put("ip", Util.getIP(request));
			modify.put("target", "modify.jsp");
			modify.put("id", session.getAttribute("id") != null?session.getAttribute("id"):"");
			modify.put("etc", map.get("fcontent"));
			LogDAO.insertLog(modify);
			
			if(result == 1) {
				response.sendRedirect("detail?fno=" + map.get("fno"));
			}else {
				response.sendRedirect("error?code=freeModify");
			}
		}
	}

}
