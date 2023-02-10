package com.multicampus.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

// 2. DAO 클래스
//@Repository
public class UserDAOIBATIS implements UserDAO {
	
	@Autowired
	private SqlMapClientTemplate ibatis;
	
	// CRUD 기능의 메소드 구현
	// 회원 상세 조회
	public UserVO getUser(UserVO vo) {
		System.out.println("===> iBATIS 기반으로 getUser() 기능 처리");	
		return (UserVO) ibatis.queryForObject("getUser", vo);
	}

	public void insertUser(UserVO vo) {}
}


