package com.multicampus.biz.user;

public interface UserDAO {

	// CRUD 기능의 메소드 구현
	// 회원 상세 조회
	UserVO getUser(UserVO vo);

	void insertUser(UserVO vo);

}