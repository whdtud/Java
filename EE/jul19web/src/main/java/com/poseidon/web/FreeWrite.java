package com.poseidon.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.poseidon.dao.BoardDAO;
import com.poseidon.util.Util;

@WebServlet("/freeWrite")
public class FreeWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FreeWrite() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("./freeWrite.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String savePath = request.getServletContext().getRealPath("/");
		//System.out.println("저장위치 : " + savePath + "upload/");
		savePath = savePath + "upload/";//진짜 파일 저장경로
		int maxSize = 1024 * 1024 * 10;//10MB
		
		MultipartRequest multi = new MultipartRequest(
						request, savePath, maxSize, "UTF-8",
						new DefaultFileRenamePolicy() );
		/* 
		 * 1. request 리퀘스트
		 * 2. 파일 저장 위치
		 * 3. 업로드될 파일 크기
		 * 4. 인코딩 문자 
		 * 5. 만약 파일중복처리? 
		 */
		HttpSession session = request.getSession();
		if ((multi.getParameter("title")).length() == 0 
				|| (multi.getParameter("content")).length() == 0) {
			response.sendRedirect("./freeWrite?code=4556");

		} else if (session.getAttribute("id") == null 
				|| session.getAttribute("name") == null) {
			response.sendRedirect("./login?code=write");

		} else {
			String title = multi.getParameter("title");
			String content = multi.getParameter("content");
			//String uploadFile = null;
			String realFile = null;
			
			if(multi.getOriginalFileName("file1") != null) {				
				//uploadFile = multi.getOriginalFileName("file1");//이름만
				realFile = multi.getFilesystemName("file1");//실제 저장
			}
			
			//System.out.println(title);
			//System.out.println(content);
			//System.out.println(uploadFile);//사용자가 올릴때 이름
			//System.out.println("실제 저장명 : " + realFile);
			
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", title);
			map.put("content", content);
			map.put("id", session.getAttribute("id"));
			map.put("ip", Util.getIP(request));
			map.put("file", realFile);
			// 데이터베이스 전송
			BoardDAO dao = BoardDAO.getInstance();
			int result = dao.write(map);

			if (result == 1) {
				// 페이지 이동
				response.sendRedirect("./index");
			} else {
				response.sendRedirect("./error?code=2599");
			}

		}
	}

}
