package com.sample.boot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.boot.dto.UserDTO;
import com.sample.boot.mapper.UserMapper;

@Repository
public class UserRepository {

	@Autowired
	UserMapper mapper;
	
	//Unit Test: getUserInfo_Test, getUserInfo_Null_Test, getUserInfo_Invalid_Id_Test
	public UserDTO getUserInfo(String facebookId){
		return mapper.getUserInfo(facebookId);
	}
	
	public void inserNewUser(UserDTO user){
		if(user == null){
			throw new NullPointerException("UserInfo Is Null");
		}
		
		if(user.getUserName() == null){
			throw new NullPointerException("UserName Is Null");
		}
		
		mapper.inserNewUser(user);
	}
}
