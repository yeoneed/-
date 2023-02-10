package com.multicampus.biz.board;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.multicampus.biz.user.UserService;
import com.multicampus.biz.user.UserVO;

public class UserServiceClient {

	public static void main(String[] args) {
		// 스프링 컨테이너를 구동한다. 
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("business-layer.xml");
		
		// 테스트 객체를 Lookup한다. 
		UserService userService = (UserService) container.getBean("userService");
		
		// Lookup한 객체를 테스트한다. 
		UserVO vo = new UserVO();
		vo.setId("aaa");
		vo.setPassword("aaa");
		UserVO findUser = userService.getUser(vo);
		if(findUser != null) {
			System.out.println(findUser.getName() + "님 로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
		
		// 스프링 컨테이너를 종료한다.
		container.close();
	}

}







