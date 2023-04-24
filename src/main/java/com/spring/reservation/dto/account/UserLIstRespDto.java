package com.spring.reservation.dto.account;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserLIstRespDto {
	private int id;
	private String userId;
	private String username;
	private String userEmail;
	private String userPhone;
	private LocalDateTime createDate;
	private int userTotalCount;
}
