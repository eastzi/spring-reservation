package com.spring.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountPageController {
	
	@GetMapping("/login")
	public String login() {
		return "main/main";
	}

	@GetMapping("/register")
	public String register() {
		return "account/register";
	}
}
