package com.sample.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.boot.dto.GroupDTO;
import com.sample.boot.repository.GroupRepository;

@Service
public class GroupService {

	@Autowired
	private GroupRepository repository;
		
	public List<GroupDTO> getGroupList(int userIdx){
		
		return repository.getGroupList(userIdx);
	}
}
