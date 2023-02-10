package com.multicampus.biz.user;

// 3. Service 인터페이스
public interface UserService {

	// CRUD 기능의 메소드 구현
	// 회원 상세 조회
	UserVO getUser(UserVO vo);

	void insertUser(UserVO vo);

}