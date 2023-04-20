package com.spring.reservation.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //runtime시 사용
@Target({ElementType.TYPE, ElementType.METHOD}) //적용가능한TYPE = class / method
public @interface LogAspect {

}
