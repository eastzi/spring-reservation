package com.spring.reservation.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.reservation.domain.User;
import com.spring.reservation.repository.AccountRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService{

	private final AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
		User user = accountRepository.findUserByUserId(userId);
		
		if(user == null) {
			log.error("아이디를 찾지 못함");
			throw new UsernameNotFoundException("존재하지 않는 아이디 입니다");
		}
		
		return new PrincipalDetails(user);
	}
	
	
}
