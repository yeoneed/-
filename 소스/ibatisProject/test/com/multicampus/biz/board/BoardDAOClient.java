package com.multicampus.biz.board;

import java.util.List;

public class BoardDAOClient {
	public static void main(String[] args) throws Exception {
		BoardVO vo = new BoardVO();
		vo.setTitle("iBATIS 테스트");
		vo.setWriter("테스터");
		vo.setContent("스프링 테스트 중입니다.");
		
		BoardDAO dao = new BoardDAO();
		//dao.insertBoard(vo);	
		
		List<BoardVO> boardList = dao.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
}
