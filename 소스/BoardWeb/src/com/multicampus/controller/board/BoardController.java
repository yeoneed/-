package com.multicampus.controller.board;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.multicampus.biz.board.BoardService;
import com.multicampus.biz.board.BoardVO;

// Model�� "board"��� �̸����� ��ϵ� ��ü�� ������ �̸����� ���ǿ��� ����ض�.
@SessionAttributes("board")
@Controller
public class BoardController {
	
	// ����Ͻ� ������Ʈ�� �������� ������ ȹ���Ѵ�. 
	@Autowired
	private BoardService boardService;
	
	// �˻� ����� JSON���� �����Ѵ�
	// @ResponseBody 	: �޼ҵ� ���� �����͸� JSON���� ��ȯ�Ͽ� HTTP ���� �������� Body�� ����Ѵ�.
	// @RequestBody 	: HTTP ��û �������� Body�� ������ JSON �����͸� �ڹ� ��ü�� �����Ѵ�.
	@RequestMapping("/json.do")
	public @ResponseBody List<BoardVO> json(BoardVO vo) throws Exception {
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		return boardService.getBoardList(vo);
	}
	
	// �� ��� ȭ������ �̵�
	@RequestMapping("/insertBoardView.do")
	public String insertBoardView() throws Exception {
		return "insertBoard";
	}
	
	// �� ��� ó��
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws Exception {
		// ���� ���ε� ó��
		MultipartFile upload = vo.getUploadFile();
		if(!upload.isEmpty())
			upload.transferTo(new File("C:/DEV/" + upload.getOriginalFilename()));
		
		// ���� ��� ó��
		boardService.insertBoard(vo);
		return "forward:getBoardList.do";
	}
	
	// �� ���� ó��
	@RequestMapping("/updateBoard.do")
	// ���ǿ� "board"��� �̸����� ��ϵ� ��ü�� �ִٸ� �� ��ü�� ������ �����ض�
	public String updateBoard(@ModelAttribute("board") BoardVO vo) throws Exception {
		boardService.updateBoard(vo);
		return "forward:getBoardList.do";
	}
	
	// �� ���� ó��
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) throws Exception {
		boardService.deleteBoard(vo);
		return "forward:getBoardList.do";
	}
	
	// �� �� ��ȸ
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) throws Exception {
		model.addAttribute("board", boardService.getBoard(vo)); // Model ���� ����
		return "getBoard";   // View ���� ����
	}
	
	// �� ��� �˻�
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) throws Exception {
		// null check
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		// �˻� ����� Model�� �����ϸ� �� �̸��� ���ڿ��� ������ �� �ִ�. 
		model.addAttribute("boardList", boardService.getBoardList(vo)); // Model ���� ����
		return "getBoardList";   // View ���� ����
	}
}









