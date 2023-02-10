package com.multicampus.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.board.BoardDAOJDBC;
import com.multicampus.biz.board.BoardVO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("�� ��� �˻� ��� ó��");
		
		// 1. DB ���� ó��
		BoardVO vo = new BoardVO();
		BoardDAOJDBC dao = new BoardDAOJDBC();
		List<BoardVO> boardList = dao.getBoardList(vo);
		
		// 2. Model(DAO)�� �̿��Ͽ� �˻��� ����� View(JSP)���� �̿��� �� �ֵ��� ���ǿ� ����Ѵ�.
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		
		// 3. ȭ�� �̵�
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList.jsp");
		return mav;
	}

}






