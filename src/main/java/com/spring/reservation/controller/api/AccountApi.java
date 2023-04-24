package com.spring.reservation.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.reservation.aop.annotation.LogAspect;
import com.spring.reservation.aop.annotation.ValidAspect;
import com.spring.reservation.dto.CMRespDto;
import com.spring.reservation.dto.account.RegisterReqDto;
import com.spring.reservation.dto.validation.ValidationSequence;
import com.spring.reservation.service.account.AccountService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountApi {

	private final AccountService accountService; 
	
	@LogAspect
	@ValidAspect
	@PostMapping("/register")         //validation check를 해당 class를 기준으로 실행
	public ResponseEntity<?> register(@Validated(ValidationSequence.class) @RequestBody RegisterReqDto registerReqDto, BindingResult bindingResult) throws Exception {
		
		accountService.checkDuplicateUserId(registerReqDto.getUserId());
		accountService.register(registerReqDto);
		
		return ResponseEntity.ok().body(new CMRespDto<>(1, "Registration successful", registerReqDto));
	}
	
	@GetMapping("/userList")
	public ResponseEntity<?> getUserList(@RequestParam int pageNumber, @RequestParam @Nullable String searchText) throws Exception {
		
		return ResponseEntity.ok(new CMRespDto<>(1, "success", accountService.getUserList(pageNumber, searchText)));
	}

}
