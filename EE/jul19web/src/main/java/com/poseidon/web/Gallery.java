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

import com.poseidon.dao.GalleryDAO;
import com.poseidon.util.Util;

@WebServlet("/gallery")
public class Gallery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Gallery() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터 불러오기 galleryview에서 모든 데이터 가져오기
		//GalleryDAO dao =  GalleryDAO.getInstance();
		//ArrayList<HashMap<String, Object>> list = dao.galleryList();
		//ArrayList<HashMap<String, Object>> list2  = GalleryDAO.getInstance().galleryList(); 
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Util.str2Int(request.getParameter("page"));
		}
		//페이지 넘기기
		RequestDispatcher rd 
				= request.getRequestDispatcher("gallery.jsp");
		//request.setAttribute("list", list2);
		ArrayList<HashMap<String, Object>> list =  GalleryDAO.getInstance().galleryList((page - 1 ) * 5);
		request.setAttribute("list", list);
		
		if(list != null && list.size() > 0) {
			request.setAttribute("totalCount", list.get(0).get("totalcount"));
		}
		//page보내기
		request.setAttribute("page", page);
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
