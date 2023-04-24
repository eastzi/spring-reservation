package com.spring.reservation.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.spring.reservation.domain.User;

@Mapper
public interface AccountRepository {
	public int save(User user);
	public User findUserByUserId(String userId);
	public List<User> getUserList(Map<String, Object> map) throws Exception;
}
