package com.spring.reservation.repository;

import org.apache.ibatis.annotations.Mapper;

import com.spring.reservation.domain.User;

@Mapper
public interface AccountRepository {
	public int save(User user);
	public User findUserByUserId(String userId);
}
