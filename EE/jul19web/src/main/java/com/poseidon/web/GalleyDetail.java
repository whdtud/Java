package com.poseidon.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.poseidon.dao.GalleryDAO;
import com.poseidon.util.Util;

@WebServlet("/galleryDetail")
public class GalleyDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GalleyDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("gno") != null 
				&& Util.str2Int2(request.getParameter("gno")) != 0
				){
			int gno = Util.str2Int(request.getParameter("gno"));
			GalleryDAO dao = GalleryDAO.getInstance();
			HashMap<String, Object> dto = dao.detail(gno);
			//댓글은 갤러리 땐 하지 않겠습니다. 이미 자유게시판에 해서.
			/*
			 * if(((int)dto.get("commentcount")) > 0) { ArrayList<HashMap<String, Object>>
			 * commentList = dao.commentList(gno); request.setAttribute("commentList",
			 * commentList); }
			 */
			RequestDispatcher rd = request.getRequestDispatcher("./galleryDetail.jsp");
			request.setAttribute("dto", dto);
			rd.forward(request, response);			
		} else {
			response.sendRedirect("./gallery");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
