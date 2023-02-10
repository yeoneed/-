package com.multicampus.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.multicampus.biz.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {
	
	@AfterReturning(pointcut="BoardPointcut.getPointcut()", returning="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		System.out.println("[사후 처리] " + method + "() 메소드 리턴 값 : " + returnObj.toString());
		
		// 바인드 변수에 등록된 데이터가 UserVO 타입인지 확인
		if(returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			// 로그인 성공한 회원의 권한이 Admin인지 확인
			if(user.getRole().equals("Admin")) {
				System.out.println(user.getName() + "님 관리자 페이지로 이동합니다.");
			}
		}
	}
}
