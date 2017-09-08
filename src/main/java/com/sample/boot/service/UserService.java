package com.sample.boot.service;

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
		UserDTO exsistUser = userRepository.getUserInfo(user.getExternalId());
		
		if(exsistUser == null){
			userRepository.inserNewUser(user);
			groupRepository.assign_User_Group_Relate(user.getUserIdx(), 2);
			groupRepository.assign_User_Group_Relate(user.getUserIdx(), 3);
			groupRepository.assign_User_Group_Relate(user.getUserIdx(), 4);
		} 
		
		return exsistUser;
	}
}
