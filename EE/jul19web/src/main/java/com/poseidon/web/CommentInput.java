package com.poseidon.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poseidon.dao.CommentDAO;
import com.poseidon.util.Util;

@WebServlet("/commentInput")
public class CommentInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CommentInput() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		//먼저 모든 값이 들어오는지 검사
		//content     fno     세션
		HttpSession session = request.getSession();
		
		//System.out.println(request.getParameter("content"));
		///System.out.println(request.getParameter("fno"));
		//System.out.println(session.getAttribute("id"));
		//System.out.println((Util.str2Int2(request.getParameter("fno")) != 0));
		
		
		if(request.getParameter("content") != null
				&& request.getParameter("fno") != null
				&& (Util.str2Int2(request.getParameter("fno")) != 0)
				&& session.getAttribute("id") != null
				&& session.getAttribute("name") != null){
			
			//System.out.println(request.getParameter("content"));
			//System.out.println(request.getParameter("fno"));
			String content = request.getParameter("content");
			int fno = Util.str2Int(request.getParameter("fno"));
			String id = (String) session.getAttribute("id");
			//값을 다 정리했습니다. 이거 데이터베이스로 보내주세요.
			
			//Map
			HashMap<String, Object> map = new HashMap<String, Object>();
			content = Util.str2Replace(content);
			map.put("content", content);
			map.put("fno", fno);
			map.put("id", id);
			//CommentDAO
			//int count = commentInput(map);
			CommentDAO dao = CommentDAO.getInstance();//싱글턴
			int result = dao.commentInput(map);//결과값이 날아옵니다.

			//페이지 이동
			if(result == 1) {
				//정상작업
				response.sendRedirect("./detail?fno=" + fno);
			} else {
				//비정상
				response.sendRedirect("./error?code=commentInsertError");
			}
		} else {
			//값이 하나라도 없다면
			response.sendRedirect("./error?code=commentInsertError");
		}
		
		
		
	}

}
