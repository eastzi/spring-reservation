package com.spring.reservation.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class TimerAop {

	//controller 패키지 및 하위 패키지의 모든 메서드
	@Pointcut("execution(* com.spring.reservation.controller..*.*(..))")
	private void executionPointCut() {
		
	}
	
	//joinPoint 전,후에 실행
	@Around("executionPointCut()") //advice
	public Object stopWatchAround(ProceedingJoinPoint joinPoint) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object result = joinPoint.proceed(); //인터셉터된 메서드 실행 결과 리턴-executionPointCut에서 지정한 모든 메서드
		
		stopWatch.stop();
		log.info("class: {}, method: {} >>> {}",
				joinPoint.getSignature().getDeclaringTypeName(), //클래스 명
				joinPoint.getSignature().getName(), //메소드 명
				stopWatch.getTotalTimeSeconds());
		
		return result;
	}
}
