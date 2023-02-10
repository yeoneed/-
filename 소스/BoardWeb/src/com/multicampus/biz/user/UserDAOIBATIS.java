package com.multicampus.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

// 2. DAO Ŭ����
//@Repository
public class UserDAOIBATIS implements UserDAO {
	
	@Autowired
	private SqlMapClientTemplate ibatis;
	
	// CRUD ����� �޼ҵ� ����
	// ȸ�� �� ��ȸ
	public UserVO getUser(UserVO vo) {
		System.out.println("===> iBATIS ������� getUser() ��� ó��");	
		return (UserVO) ibatis.queryForObject("getUser", vo);
	}

	public void insertUser(UserVO vo) {}
}


