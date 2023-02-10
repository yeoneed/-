package com.multicampus.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.multicampus.biz.common.JDBCUtil;

// 2. DAO Ŭ����
//@Repository
public class UserDAOJDBC implements UserDAO {
	// JDBC ���� ���� ����
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;

	// USERS ���̺� ���� SQL ��ɾ��
	private final String USER_GET = "select * from users where id=? and password=?";
	
	// CRUD ����� �޼ҵ� ����
	// ȸ�� �� ��ȸ
	public UserVO getUser(UserVO vo) {
		System.out.println("===> JDBC ������� getUser() ��� ó��");
		UserVO user = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
		return user;
	}

	public void insertUser(UserVO vo) {
		// TODO Auto-generated method stub
		
	}
}
