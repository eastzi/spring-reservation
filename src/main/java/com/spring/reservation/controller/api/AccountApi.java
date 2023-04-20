package com.spring.reservation.controller.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.reservation.aop.annotation.LogAspect;
import com.spring.reservation.aop.annotation.ValidAspect;
import com.spring.reservation.dto.account.RegisterReqDto;
import com.spring.reservation.dto.validation.ValidationSequence;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/account")
public class AccountApi {

	@LogAspect
	@ValidAspect
	@PostMapping("/register")         //validation check를 해당 class를 기준으로 실행
	public ResponseEntity<?> register(@Validated(ValidationSequence.class) @RequestBody RegisterReqDto registerReqDto, BindingResult bindingResult) {
		
		return ResponseEntity.ok(null);
	}
}
