package com.sample.boot.repository;

import java.util.List;

import org.assertj.core.util.Preconditions;
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
	
	//Unit Test: insertNewUser_Test, insertNewUser_Null_Test, insertNewUser_UserName_Null_Test, insertNewUser_ExternalId_Null_Test 
	public void inserNewUser(UserDTO user){
		if (checkNewUserValidate(user))		
			mapper.inserNewUser(user);
	}
	
	private boolean checkNewUserValidate(UserDTO user){
		Preconditions.checkNotNull(user, "UserInfo Is Null");
		Preconditions.checkNotNull(user.getUserName(), "UserName Is Null");
		Preconditions.checkNotNull(user.getExternalId(), "ExternalId Is Null");		
		return true;
	}
	
	//Unit Test : getGroupIdxList_From_UserIdx_Test, getGroupIdxList_From_UserIdx_Invalid_Test
	public List<Integer> getGroupIdxList_From_UserIdx(int userIdx){
		Preconditions.checkArgument(userIdx > 0, "UserIdx Invalid");
		return mapper.getGroupIdxListFromUserIdx(userIdx);
	}
}
