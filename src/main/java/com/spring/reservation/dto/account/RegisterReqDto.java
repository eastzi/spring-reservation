package com.spring.reservation.dto.account;

import lombok.Data;

@Data
public class RegisterReqDto {
	private String lastName;
	private String firstName;
	private String userName;
	private String password;
	private String email;
	private String phoneNum;
}
