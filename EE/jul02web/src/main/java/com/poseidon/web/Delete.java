package com.poseidon.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poseidon.dao.BoardDAO;
import com.poseidon.util.Util;

@WebServlet("/delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Delete() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	//bno정확해야 하고
    	//로그인 한 사용자
    	//sql = DELETE FROM 테이블명 WHERE 조건=값 AND 조건=값
    	
    	if(request.getParameter("bno") == null 
    			|| Util.str2Int2(request.getParameter("bno")) == 0
    			|| session.getAttribute("id") == null 
    			|| session.getAttribute("name") == null) {
    		//bno가 안 오거나, bno가 숫자가 아니거나
    		//id와 name이 없으면 로직 실행 못하게 막음
    	}else {    		
    		int bno = Util.str2Int(request.getParameter("bno"));
    		//System.out.println(bno);
    		String id = (String) session.getAttribute("id");
    		
    		BoardDAO dao = new BoardDAO();
    		int result = dao.delete(bno, id);
    		if(result == 1) {
    			//정상 삭제
    			response.sendRedirect("success.jsp");
    		}else {
    			//삭제 실패
    			response.sendRedirect("fail.jsp");
    		}
    	}
    	
    	
    	
    	
    	
    	
    	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
