package com.multicampus.biz.board;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.multicampus.biz.user.UserService;
import com.multicampus.biz.user.UserVO;

public class UserServiceClient {

	public static void main(String[] args) {
		// ������ �����̳ʸ� �����Ѵ�. 
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("business-layer.xml");
		
		// �׽�Ʈ ��ü�� Lookup�Ѵ�. 
		UserService userService = (UserService) container.getBean("userService");
		
		// Lookup�� ��ü�� �׽�Ʈ�Ѵ�. 
		UserVO vo = new UserVO();
		vo.setId("aaa");
		vo.setPassword("aaa");
		UserVO findUser = userService.getUser(vo);
		if(findUser != null) {
			System.out.println(findUser.getName() + "�� �α��� ����");
		} else {
			System.out.println("�α��� ����");
		}
		
		// ������ �����̳ʸ� �����Ѵ�.
		container.close();
	}

}







