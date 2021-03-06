package com.sample.boot.service;

import java.util.List;

import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.boot.dto.GroupDTO;
import com.sample.boot.repository.GroupRepository;

@Service
public class GroupService {

	@Autowired
	private GroupRepository repository;
	
	//Unit Test: getGroupList_Test, getGroupList_userIdx_Invalid_Test
	public List<GroupDTO> getGroupList(int userIdx){
		Preconditions.checkArgument(userIdx > 0, "UserIdx Is Invalid");		
		return repository.getGroupList(userIdx);
	}
}
