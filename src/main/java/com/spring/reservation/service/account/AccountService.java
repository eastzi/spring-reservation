package com.spring.reservation.service.account;

import com.spring.reservation.dto.account.RegisterReqDto;

public interface AccountService {
	public boolean checkDuplicateUserId(String userId);
	public boolean register(RegisterReqDto registerReqDto) throws Exception;
}
