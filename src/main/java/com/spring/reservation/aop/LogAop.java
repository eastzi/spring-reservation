package com.spring.reservation.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LogAop {
	
	//@LogAspect를 붙인 메서드에 대해서만 logAround() 호출
	@Pointcut("@annotation(com.spring.reservation.aop.annotation.LogAspect)")
	private void annotationPointCut() {
		
	}

	/*api이하의 모든 메서드에 대해 logAround() 호출
	@Pointcut("execution(* com.spring.reservation.controller.api.*.*(..))")
	private void executionPointCut() {
		
	}
	*/
	
	@Around("annotationPointCut()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		
		//인터셉터되는 메소드에 전달된 인수(arg)를 객체 배열로 반환
		Object[] args = joinPoint.getArgs();
		
		//인터셉터된 메소드명
		CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
		//메소드의 매개변수명을 문자열 배열로 반환
		String[] argNames = codeSignature.getParameterNames();

		StringBuilder argNameString = new StringBuilder();
		StringBuilder argDataString = new StringBuilder();
		
		for(int i = 0; i < args.length; i++) {
			argNameString.append(argNames[i]); //매개변수명
			argDataString.append(args[i].toString()); //매개변수 데이터명
			
			if(i < args.length -1) {
				argNameString.append(", ");
				argDataString.append(", ");
			}
		}
		
		//before
		//클래스.메소드명.(매개변수)
		log.info("Method Call -- {}.{}({}) >> {}",
				joinPoint.getSignature().getDeclaringTypeName(), //클래스명
				joinPoint.getSignature().getName(), //메소드명
				argNameString.toString(), //매개변수명
				argDataString.toString()); //매개변수 데이터
		
		Object result = joinPoint.proceed();
		
		//after
		log.info("Method Return -- {}.{}({}) >> {}",
				joinPoint.getSignature().getDeclaringTypeName(), //클래스명
				joinPoint.getSignature().getName(), //메소드명
				argNameString.toString(), //매개변수명
				result); //응답 코드
		
		return result;
	}
}
