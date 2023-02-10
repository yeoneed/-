package com.multicampus.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

// 2. DAO Ŭ����
//@Repository
public class UserDAOSPRING implements UserDAO {
	
	@Autowired
	private JdbcTemplate spring;
	
	// USERS ���̺� ���� SQL ��ɾ��
	private final String USER_GET = "select * from users where id=? and password=?";
	
	// CRUD ����� �޼ҵ� ����
	// ȸ�� �� ��ȸ
	public UserVO getUser(UserVO vo) {
		System.out.println("===> SPRING ������� getUser() ��� ó��");	
		Object[] args = {vo.getId(), vo.getPassword()};
		return spring.queryForObject(USER_GET, args, new UserRowMapper());
	}

	public void insertUser(UserVO vo) {}
}


