package com.spring.reservation.domain;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.spring.reservation.dto.account.UserLIstRespDto;

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
	
	private int user_total_count;
	
	public UserLIstRespDto toUserListRespDto() {
		return UserLIstRespDto.builder()
				.id(user_code)
				.userId(user_id)
				.username(user_name)
				.userEmail(user_email)
				.userPhone(user_phone)
				.createDate(create_date)
				.userTotalCount(user_total_count)
				.build();
	}
}
