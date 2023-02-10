package com.multicampus.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.multicampus.biz.board.BoardDAOJDBC;
import com.multicampus.biz.board.BoardVO;
import com.multicampus.biz.user.UserDAOJDBC;
import com.multicampus.biz.user.UserVO;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DispatcherServlet() {
        System.out.println("===> DispatcherServlet 생성");
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 한글 인코딩 설정
		request.setCharacterEncoding("EUC-KR");
		
		// 1. 사용자 요청 path 정보를 추출한다. 
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		// 2. 요청 path에 따라 분기처리한다. 
		if(path.equals("/login.do")) {

		} else if(path.equals("/logout.do")) {
			System.out.println("로그아웃 기능 처리");
			
			// 브라우저에 해당하는 세션을 강제 종료하고 index 페이지로 이동한다.
			HttpSession session = request.getSession();
			session.invalidate();

			response.sendRedirect("/");
			
		} else if(path.equals("/insertBoard.do")) {
			System.out.println("글 등록 기능 처리");

			// 1. 사용자 입력정보 추출
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAOJDBC dao = new BoardDAOJDBC();
			dao.insertBoard(vo);
			
			// 3. 화면 이동
			response.sendRedirect("getBoardList.do");
			
		} else if(path.equals("/updateBoard.do")) {
			System.out.println("글 수정 기능 처리");
			
			// 1. 사용자 입력정보 추출
			String title = request.getParameter("title");
			String seq = request.getParameter("seq");
			String content = request.getParameter("content");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setSeq(Integer.parseInt(seq));
			vo.setContent(content);
			
			BoardDAOJDBC dao = new BoardDAOJDBC();
			dao.updateBoard(vo);
			
			// 3. 화면 이동
			response.sendRedirect("getBoardList.do");
			
		} else if(path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제 기능 처리");
			
			// 1. 사용자 입력정보 추출
			String seq = request.getParameter("seq");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAOJDBC dao = new BoardDAOJDBC();
			dao.deleteBoard(vo);
			
			// 3. 화면 이동
			response.sendRedirect("getBoardList.do");
			
		} else if(path.equals("/getBoard.do")) {
			System.out.println("글 상세 조회 기능 처리");
			
			// 1. 사용자 입력정보 추출
			String seq = request.getParameter("seq");

			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAOJDBC dao = new BoardDAOJDBC();
			BoardVO board = dao.getBoard(vo);
			
			// 3. Model(DAO)을 이용하여 검색한 결과를 View(JSP)에서 이용할 수 있도록 세션에 등록한다.
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			
			// 4. 화면 이동
			response.sendRedirect("getBoard.jsp");			
			
		} else if(path.equals("/getBoardList.do")) {

		}
	}

}







