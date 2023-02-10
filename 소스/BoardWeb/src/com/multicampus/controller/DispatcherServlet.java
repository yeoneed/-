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
        System.out.println("===> DispatcherServlet ����");
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// �ѱ� ���ڵ� ����
		request.setCharacterEncoding("EUC-KR");
		
		// 1. ����� ��û path ������ �����Ѵ�. 
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		// 2. ��û path�� ���� �б�ó���Ѵ�. 
		if(path.equals("/login.do")) {

		} else if(path.equals("/logout.do")) {
			System.out.println("�α׾ƿ� ��� ó��");
			
			// �������� �ش��ϴ� ������ ���� �����ϰ� index �������� �̵��Ѵ�.
			HttpSession session = request.getSession();
			session.invalidate();

			response.sendRedirect("/");
			
		} else if(path.equals("/insertBoard.do")) {
			System.out.println("�� ��� ��� ó��");

			// 1. ����� �Է����� ����
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAOJDBC dao = new BoardDAOJDBC();
			dao.insertBoard(vo);
			
			// 3. ȭ�� �̵�
			response.sendRedirect("getBoardList.do");
			
		} else if(path.equals("/updateBoard.do")) {
			System.out.println("�� ���� ��� ó��");
			
			// 1. ����� �Է����� ����
			String title = request.getParameter("title");
			String seq = request.getParameter("seq");
			String content = request.getParameter("content");
			
			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setSeq(Integer.parseInt(seq));
			vo.setContent(content);
			
			BoardDAOJDBC dao = new BoardDAOJDBC();
			dao.updateBoard(vo);
			
			// 3. ȭ�� �̵�
			response.sendRedirect("getBoardList.do");
			
		} else if(path.equals("/deleteBoard.do")) {
			System.out.println("�� ���� ��� ó��");
			
			// 1. ����� �Է����� ����
			String seq = request.getParameter("seq");
			
			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAOJDBC dao = new BoardDAOJDBC();
			dao.deleteBoard(vo);
			
			// 3. ȭ�� �̵�
			response.sendRedirect("getBoardList.do");
			
		} else if(path.equals("/getBoard.do")) {
			System.out.println("�� �� ��ȸ ��� ó��");
			
			// 1. ����� �Է����� ����
			String seq = request.getParameter("seq");

			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAOJDBC dao = new BoardDAOJDBC();
			BoardVO board = dao.getBoard(vo);
			
			// 3. Model(DAO)�� �̿��Ͽ� �˻��� ����� View(JSP)���� �̿��� �� �ֵ��� ���ǿ� ����Ѵ�.
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			
			// 4. ȭ�� �̵�
			response.sendRedirect("getBoard.jsp");			
			
		} else if(path.equals("/getBoardList.do")) {

		}
	}

}







