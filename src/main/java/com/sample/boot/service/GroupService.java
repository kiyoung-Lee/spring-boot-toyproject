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
		
	public List<Integer> getRelateGroupIdxList(int userIdx){
		Preconditions.checkArgument(userIdx > 0, "UserIdx Is Invalid");
		return repository.getRelateGroupIdxList(userIdx);		
	}
	
	public List<GroupDTO> getGroupList(String groupIdxList){
		Preconditions.checkNotNull(groupIdxList, "GroupIdxList Is Null");
		
		return repository.getGroupList(groupIdxList);
	}
}
