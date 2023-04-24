package com.spring.reservation.service.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.spring.reservation.domain.User;
import com.spring.reservation.dto.account.RegisterReqDto;
import com.spring.reservation.dto.account.UserLIstRespDto;
import com.spring.reservation.exception.CustomValidationException;
import com.spring.reservation.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
	
	private final AccountRepository accountRepository;
	
	@Override
	public boolean checkDuplicateUserId(String userId) {
		
		User user = accountRepository.findUserByUserId(userId);
		
		if(user != null) {
			Map<String, String> errorMap = new HashMap<String, String>();
			
			errorMap.put("duplicateFlag", "이미 가입된 아이디입니다.");
			throw new CustomValidationException("DuplicateUserId Error", errorMap);
		}
		
		return true;
	}

	@Override
	public boolean register(RegisterReqDto registerReqDto) throws Exception {

		User userEntity = registerReqDto.toUserEntity();
		int result = accountRepository.save(userEntity);
		
		return result != 0;
	}

	@Override
	public List<UserLIstRespDto> getUserList(int pageNumber, String searchText) throws Exception {
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("index", (pageNumber - 1) * 10);
		userMap.put("searchText", searchText);

		List<UserLIstRespDto> list = new ArrayList<UserLIstRespDto>();
		
		accountRepository.getUserList(userMap).forEach(user -> {
			list.add(user.toUserListRespDto());
		});
		
		return list;
	}

}
