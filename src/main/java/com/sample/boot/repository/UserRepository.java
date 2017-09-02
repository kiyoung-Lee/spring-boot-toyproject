package com.sample.boot.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.boot.dto.UserDTO;
import com.sample.boot.mapper.UserMapper;

@Repository
public class UserRepository {

	@Autowired
	UserMapper mapper;
	
	//Unit Test: getUserInfo_Test, getUserInfo_Null_Test, getUserInfo_Invalid_Id_Test
	public UserDTO getUserInfo(String externalId){
		return mapper.getUserInfo(externalId);
	}
	
	public void inserNewUser(UserDTO user){
		if (checkNewUserValidate(user))		
			mapper.inserNewUser(user);
	}
	
	private boolean checkNewUserValidate(UserDTO user){
		if(user == null){
			throw new NullPointerException("UserInfo Is Null");
		}
		
		if(user.getUserName() == null){
			throw new NullPointerException("UserName Is Null");
		}
		
		if(user.getExternalId() == null){
			throw new NullPointerException("ExternalId Is Null");
		}
		
		return true;
	}
	
	public List<Integer> getGroupIdxList_From_UserIdx(int ueserIdx){
		return mapper.getGroupIdxListFromUserIdx(ueserIdx);
	}
}
