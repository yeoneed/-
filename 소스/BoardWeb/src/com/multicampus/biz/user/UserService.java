package com.multicampus.biz.user;

// 3. Service �������̽�
public interface UserService {

	// CRUD ����� �޼ҵ� ����
	// ȸ�� �� ��ȸ
	UserVO getUser(UserVO vo);

	void insertUser(UserVO vo);

}