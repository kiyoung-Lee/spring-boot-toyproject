package com.sample.boot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.boot.mapper.UserMapper;

@Repository
public class UserRepository {

	@Autowired
	UserMapper mapper;
	
	public int getUserInfo(String facebookId){
		return mapper.getUserInfo(facebookId);
	}
}
