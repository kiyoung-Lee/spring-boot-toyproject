package com.sample.boot.User;

import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.boot.User.Data.UserDTO;
import com.sample.boot.repository.GroupRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	GroupRepository groupRepository;
		
	//Unit Test: login_Test, login_Null_Test, login_ExternalId_Null_Test, 
	public UserDTO login(UserDTO user){
		Preconditions.checkNotNull(user, "UserInfo Is Null");
		Preconditions.checkNotNull(user.getExternalId(), "ExternalId Is Null");		
		
		return userRepository.getUserInfo(user.getExternalId());	
	}
	
	//Unit Test: join_Test, join_Null_Test, join_ExternalId_Null_Test, join_UserName_Null_Test, join_ExsistUser_Test
	public UserDTO Join(UserDTO user){
		Preconditions.checkNotNull(user, "UserInfo Is Null");
		Preconditions.checkNotNull(user.getExternalId(), "ExternalId Is Null");
		Preconditions.checkNotNull(user.getUserName(), "UserName Is Null");
		
		UserDTO exsistUser = login(user);
		
		// 로그인 & 회원가입
		if(exsistUser == null){
			userRepository.inserNewUser(user);
			groupRepository.assign_User_Group_Relate(user.getUserIdx(), 2);
			groupRepository.assign_User_Group_Relate(user.getUserIdx(), 3);
			groupRepository.assign_User_Group_Relate(user.getUserIdx(), 4);
			return login(user);
		}
		
		return exsistUser;
	}
}
