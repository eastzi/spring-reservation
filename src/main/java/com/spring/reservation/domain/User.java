package com.spring.reservation.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	private int user_code;
	private String user_id;
	private String user_name;
	private String user_password;
	private String user_email;
	private String user_phone;
	private int role_id;
	private Role role;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
}
