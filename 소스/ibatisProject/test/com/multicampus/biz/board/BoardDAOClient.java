package com.multicampus.biz.board;

import java.util.List;

public class BoardDAOClient {
	public static void main(String[] args) throws Exception {
		BoardVO vo = new BoardVO();
		vo.setTitle("iBATIS �׽�Ʈ");
		vo.setWriter("�׽���");
		vo.setContent("������ �׽�Ʈ ���Դϴ�.");
		
		BoardDAO dao = new BoardDAO();
		//dao.insertBoard(vo);	
		
		List<BoardVO> boardList = dao.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
}
