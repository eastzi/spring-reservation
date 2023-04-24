package com.spring.reservation.controller;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/account")
public class AccountPageController {
	
	@GetMapping("/login")
	public String login(Model model, @RequestParam @Nullable String error) {
        if(error != null){
            model.addAttribute("error", error.equals("auth") ? "이메일 또는 비밀번호가 잘못되었습니다." : "");
        }
        return "account/login";
    }

	@GetMapping("/register")
	public String register() {
		return "account/register";
	}
	
	@GetMapping("/user/list")
	public String userList() {
		return "account/user_list";
	}
	
}
