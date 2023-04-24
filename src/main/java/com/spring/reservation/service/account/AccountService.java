package com.spring.reservation.service.account;

import java.util.List;

import com.spring.reservation.domain.User;
import com.spring.reservation.dto.account.RegisterReqDto;
import com.spring.reservation.dto.account.UserLIstRespDto;

public interface AccountService {
	public boolean checkDuplicateUserId(String userId);
	public boolean register(RegisterReqDto registerReqDto) throws Exception;
	public List<UserLIstRespDto> getUserList(int pageNumber, String searchText) throws Exception;
}
