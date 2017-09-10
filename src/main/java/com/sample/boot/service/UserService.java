package com.sample.boot.service;

import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.boot.dto.UserDTO;
import com.sample.boot.repository.GroupRepository;
import com.sample.boot.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	GroupRepository groupRepository;
		
	public UserDTO login(UserDTO user){
		Preconditions.checkNotNull(user, "UserInfo Is Null");
		Preconditions.checkNotNull(user.getExternalId(), "ExternalId Is Null");		
		return userRepository.getUserInfo(user.getExternalId());	
	}
	
	public UserDTO Join(UserDTO user){
		Preconditions.checkNotNull(user, "UserInfo Is Null");
		UserDTO exsistUser = login(user);
		
		// 회원가입 & 자동로그인
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
