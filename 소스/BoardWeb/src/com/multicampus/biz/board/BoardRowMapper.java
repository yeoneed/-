package com.multicampus.biz.board;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BoardRowMapper implements RowMapper<BoardVO> {

	// ResultSet에 있는 검색 결과를 어떤 VO 객체에 어떻게 매핑할 것인지를 기술한다.
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		//System.out.println("rowNum---" + rowNum);
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("SEQ"));
		board.setTitle(rs.getString("TITLE"));
		board.setWriter(rs.getString("WRITER"));
		board.setContent(rs.getString("CONTENT"));
		board.setRegDate(rs.getDate("REGDATE"));
		board.setCnt(rs.getInt("CNT"));
		return board;
	}

}
