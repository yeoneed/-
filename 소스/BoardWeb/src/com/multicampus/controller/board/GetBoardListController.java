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
		System.out.println("글 목록 검색 기능 처리");
		
		// 1. DB 연동 처리
		BoardVO vo = new BoardVO();
		BoardDAOJDBC dao = new BoardDAOJDBC();
		List<BoardVO> boardList = dao.getBoardList(vo);
		
		// 2. Model(DAO)을 이용하여 검색한 결과를 View(JSP)에서 이용할 수 있도록 세션에 등록한다.
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		
		// 3. 화면 이동
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoardList.jsp");
		return mav;
	}

}






