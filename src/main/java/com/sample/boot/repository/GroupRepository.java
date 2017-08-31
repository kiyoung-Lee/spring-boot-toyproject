package com.sample.boot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.boot.mapper.GroupMapper;

@Repository
public class GroupRepository {

	@Autowired
	private GroupMapper mapper;
	
	public int selectTest(){
		return mapper.getGroupCount();
	}
	
	public void insertDefaultGroup(){
		
	}
}
