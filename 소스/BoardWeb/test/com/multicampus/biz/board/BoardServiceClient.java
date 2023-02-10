package com.multicampus.biz.board;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		// ������ �����̳ʸ� �����Ѵ�. 
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("business-layer.xml");
		
		// �׽�Ʈ ��ü�� Lookup�Ѵ�. 
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		// Lookup�� ��ü�� �׽�Ʈ�Ѵ�. 
		BoardVO vo = new BoardVO();
		vo.setSeq(101);
		vo.setTitle("Spring �׽�Ʈ");
		vo.setWriter("�׽���");
		vo.setContent("������ �׽�Ʈ ���Դϴ�.");
		//boardService.insertBoard(vo);	
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
		
		// ������ �����̳ʸ� �����Ѵ�.
		container.close();
	}

}







