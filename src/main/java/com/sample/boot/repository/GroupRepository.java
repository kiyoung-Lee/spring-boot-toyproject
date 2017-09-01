package com.sample.boot.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.boot.dto.GroupDTO;
import com.sample.boot.mapper.GroupMapper;

@Repository
public class GroupRepository {

	@Autowired
	private GroupMapper mapper;
	
	public int selectTest(){
		return mapper.getGroupCount();
	}
	
	public void assignDefaultGroup(){
		
	}
	
	public List<GroupDTO> getGroupList(int userIdx){
		
		return null;
	}
}
