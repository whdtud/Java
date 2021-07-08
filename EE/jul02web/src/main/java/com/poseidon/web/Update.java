package com.poseidon.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poseidon.dao.BoardDAO;
import com.poseidon.dto.BoardDTO;
import com.poseidon.util.Util;


@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BoardDAO dao;
    
    public Update() {
        super();
        dao = new BoardDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리해주세요.
		response.setContentType("text/html;charset=UTF-8");
		//session만들어주세요.
		HttpSession session = request.getSession();
		if(session.getAttribute("id") != null
				&& session.getAttribute("name") != null 
				&& request.getParameter("bno") != null
				&& Util.str2Int2(request.getParameter("bno")) != 0) {
			//로그인 한 상태이고, bno가 숫자인 상태
			//여기서 작업
			//bno오는지 확인
			int bno = Util.str2Int(request.getParameter("bno"));
			//System.out.println("오는 데이터는 : " + bno);
			String id = (String) session.getAttribute("id");
			//bno를 데이터베이스로 보내서 글 얻어오기
			
			BoardDTO dto = dao.update(bno, id);
			//화면에 출력
//			System.out.println(dto.getBno());
//			System.out.println(dto.getBtitle());
//			System.out.println(dto.getBcontent());
//			System.out.println(dto.getId());
			
			if (dto != null) {
				//데이터베이스에서 리턴된 객체가 있다면 화면그리기
				//이제 디스패쳐라는 녀석을 사용합니다.
				RequestDispatcher dispatcher 
					= request.getRequestDispatcher("./update.jsp");
				request.setAttribute("dto", dto);//값 전달
				dispatcher.forward(request, response);
				
			} else {
				//에러로 보내기
				response.sendRedirect("error.jsp?error=5505");//값이 없습니다.
			}
			
		} else {
			//로그인 하지 않았거나, bno가 없거나, bno가 숫자가 아닌 경우
			//에러로 보내기
			response.sendRedirect("error.jsp?error=3306");//잘못된 접근입니다.
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//controller
		//글수정 -> servlet(get) -> update.jsp
		//update.jsp -> servelt(post) -> board.jsp
		//response.setContentType("text/html;charset=UTF-8");//한글처리
		request.setCharacterEncoding("UTF-8");//한글처리
		HttpSession session = request.getSession();
		
		if(request.getParameter("title") != null 
				&& request.getParameter("content") != null
				&& request.getParameter("bno") != null
				&& Util.str2Int2(request.getParameter("bno")) != 0
				&& session.getAttribute("id") != null
				&& session.getAttribute("name") != null) {
			//모든 데이터가 다 들어옵니다.
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int bno = Util.str2Int(request.getParameter("bno"));
			//System.out.println(title);
			//System.out.println(content);
			//System.out.println(bno);
			//if문으로 
			//데이터베이스로 보내기
			BoardDTO dto = new BoardDTO();
			dto.setBno(bno);
			dto.setBtitle(title);
			dto.setBcontent(content);
			dto.setId((String) session.getAttribute("id"));
			//DAO DTO
			dao.update2(dto);
			
			//페이지 이동
			response.sendRedirect("./detail.jsp?bno=" + bno);
		} else {
			//데이터가 빠졌습니다.
			response.sendRedirect("./error.jsp");
		}
		
		
		
		
		
	}

}
