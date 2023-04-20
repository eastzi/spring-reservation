package com.spring.reservation.dto.account;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.spring.reservation.domain.User;
import com.spring.reservation.dto.validation.ValidationGroups;

import lombok.Data;

@Data
public class RegisterReqDto {
	
	@NotBlank(message = "이름은 비워둘 수 없습니다.",
			groups = ValidationGroups.NotBlankGroup.class)
	@Size(min = 1, max = 3, 
		message = "이름은 1글자에서 3글자 사이입니다.",
		groups = ValidationGroups.SizeCheckGroup.class)
	@Pattern(regexp = "^[가-힇]{1,3}$", 
			message = "이름은 한글만 입력가능합니다.",
			groups = ValidationGroups.PatternCheckGroup.class)
	private String lastName;
	
	@NotBlank(message = "성은 비워둘 수 없습니다.",
			groups = ValidationGroups.NotBlankGroup.class)
	@Size(min = 1, max = 2,
		message = "성은 1글자에서 2글자 사이입니다.",
		groups = ValidationGroups.SizeCheckGroup.class)
	@Pattern(regexp = "^[가-힇]{1,2}$",
			message = "성은 한글만 입력가능합니다.",
			groups = ValidationGroups.PatternCheckGroup.class)
	private String firstName;
	
	@NotBlank(message = "아이디는 비워둘 수 없습니다.",
			groups = ValidationGroups.NotBlankGroup.class)
	@Size(min = 4, max = 10,
		message = "아이디는 4자리에서 10자리 사이 입니다.",
		groups = ValidationGroups.SizeCheckGroup.class)
	private String userId;
	
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[~!@#$%^&*_])[a-zA-Z\\d-~!@#$%^&*_]{8,16}$",
			message = "비밀번호는 숫자, 영문(대소문자), 특수기호를 하나 이상 포함해야합니다.",
			groups = ValidationGroups.PatternCheckGroup.class)
	@NotBlank(message = "비밀번호는 비워둘 수 없습니다.",
			groups = ValidationGroups.NotBlankGroup.class)
	@Size(min = 8, max = 16,
		message = "비밀번호는 8자리에서 16자리 사이 입니다.",
		groups = ValidationGroups.SizeCheckGroup.class)
	private String password;
	
	@Email
	@NotBlank(message = "이메일은 비워둘 수 없습니다.",
			groups = ValidationGroups.NotBlankGroup.class)
	private String email;
	
	@NotBlank(message = "전화번호는 비워둘 수 없습니다.",
			groups = ValidationGroups.NotBlankGroup.class)
	@Pattern(regexp = "^\\d{3}-\\d{3,4}-\\d{4}$", 
			groups = ValidationGroups.PatternCheckGroup.class)
	private String phoneNum;
	
	public User toUserEntity() {
		return User.builder()
				.user_id(userId)
				.user_name(firstName + lastName)
				.user_password(password)
				.user_email(email)
				.user_phone(phoneNum)
				.role_id(1)
				.build();
	}
	
}
