package com.spring.reservation.aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;

import com.spring.reservation.exception.CustomValidationException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class ValidationAop {

	@Pointcut("@annotation(com.spring.reservation.aop.annotation.ValidAspect)")
	private void annotationPointCut() {
		
	}
	
	@Before("annotationPointCut()")
	public void beforeValidAround(JoinPoint joinPoint) throws Throwable {
	
		Object[] args = joinPoint.getArgs();
		
		//arg중에서 bindingResult 객체 찾기
		BeanPropertyBindingResult bindingResult = null;

        for(Object arg : args) {
            if(arg.getClass() == BeanPropertyBindingResult.class){
                bindingResult = (BeanPropertyBindingResult) arg;
                break;
            }
        }
		
		if(bindingResult.hasErrors()){
            log.error("유효성 검사 요류 발생");
            
            Map<String, String> errorMap = new HashMap<String, String>();

            bindingResult.getFieldErrors().forEach(error -> {
            	//errorMap에 모든 오류가 포함
                errorMap.put(error.getField(), error.getDefaultMessage());

            });
            
            log.error("error: {}" + errorMap);
            throw new CustomValidationException("validation falied", errorMap);
            //aop는 controller가 아니기 때문에 응답을 할 수 없음. 전달할 필요가 있음.
            //유효성 검사 후 예외가 발생하면 -> restControllerExceptionHandler에서 인터셉터
            //이 후 customValidationException에서 예외가 생성됨.
            //-> restControllerExceptionHandler의 validationErrorException메서드에서 가져와서 매개변수로 사용 후 리턴(@restControllerAdvice)
		}
	}
	
	@AfterReturning(value = "annotationPointCut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        log.info("Validation success: {}", returnObj);
    }
}
