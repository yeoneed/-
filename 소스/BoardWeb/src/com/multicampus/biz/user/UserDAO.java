package com.multicampus.biz.user;

public interface UserDAO {

	// CRUD ����� �޼ҵ� ����
	// ȸ�� �� ��ȸ
	UserVO getUser(UserVO vo);

	void insertUser(UserVO vo);

}