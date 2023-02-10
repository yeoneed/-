package com.multicampus.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

// 2. DAO(Data Access Object) Ŭ����
//@Repository
public class BoardDAOIBATIS implements BoardDAO {
	
	@Autowired
	private SqlMapClientTemplate ibatis;

	// CRUD ����� �޼ҵ� ����
	// �� ���
	public void insertBoard(BoardVO vo) {
		System.out.println("===> iBATIS ������� insertBoard() ��� ó��");
		ibatis.insert("insertBoard", vo);
	}

	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> iBATIS ������� updateBoard() ��� ó��");
		ibatis.update("updateBoard", vo);
	}

	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> iBATIS ������� deleteBoard() ��� ó��");
		ibatis.delete("deleteBoard", vo);
	}
	
	// �� �� ��ȸ
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> iBATIS ������� getBoard() ��� ó��");
		return (BoardVO) ibatis.queryForObject("getBoard", vo);
	}

	// �� ��� �˻�
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> iBATIS ������� getBoardList() ��� ó��");
		return ibatis.queryForList("getBoardList", vo);
	}
}











