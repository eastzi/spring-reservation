package com.spring.reservation.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.reservation.dto.account.RegisterReqDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/account")
public class AccountApi {

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody RegisterReqDto registerReqDto) {
		
		log.info("{}", registerReqDto);
		
		return ResponseEntity.ok(null);
	}
}
