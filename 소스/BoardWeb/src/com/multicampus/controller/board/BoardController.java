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

// Model에 "board"라는 이름으로 등록된 객체를 동일한 이름으로 세션에도 등록해라.
@SessionAttributes("board")
@Controller
public class BoardController {
	
	// 비즈니스 컴포넌트에 대한참조 정보를 획득한다. 
	@Autowired
	private BoardService boardService;
	
	// 검색 결과를 JSON으로 리턴한다
	// @ResponseBody 	: 메소드 리턴 데이터를 JSON으로 변환하여 HTTP 응답 프로토콜 Body에 출력한다.
	// @RequestBody 	: HTTP 요청 프로토콜 Body에 설정된 JSON 데이터를 자바 객체에 매핑한다.
	@RequestMapping("/json.do")
	public @ResponseBody List<BoardVO> json(BoardVO vo) throws Exception {
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		return boardService.getBoardList(vo);
	}
	
	// 글 등록 화면으로 이동
	@RequestMapping("/insertBoardView.do")
	public String insertBoardView() throws Exception {
		return "insertBoard";
	}
	
	// 글 등록 처리
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws Exception {
		// 파일 업로드 처리
		MultipartFile upload = vo.getUploadFile();
		if(!upload.isEmpty())
			upload.transferTo(new File("C:/DEV/" + upload.getOriginalFilename()));
		
		// 새글 등록 처리
		boardService.insertBoard(vo);
		return "forward:getBoardList.do";
	}
	
	// 글 수정 처리
	@RequestMapping("/updateBoard.do")
	// 세션에 "board"라는 이름으로 등록된 객체가 있다면 그 객체를 꺼내서 재사용해라
	public String updateBoard(@ModelAttribute("board") BoardVO vo) throws Exception {
		boardService.updateBoard(vo);
		return "forward:getBoardList.do";
	}
	
	// 글 삭제 처리
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) throws Exception {
		boardService.deleteBoard(vo);
		return "forward:getBoardList.do";
	}
	
	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) throws Exception {
		model.addAttribute("board", boardService.getBoard(vo)); // Model 정보 저장
		return "getBoard";   // View 정보 리턴
	}
	
	// 글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) throws Exception {
		// null check
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		// 검색 결과를 Model에 저장하면 뷰 이름을 문자열로 리턴할 수 있다. 
		model.addAttribute("boardList", boardService.getBoardList(vo)); // Model 정보 저장
		return "getBoardList";   // View 정보 리턴
	}
}









