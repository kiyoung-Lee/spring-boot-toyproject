package com.sample.boot.repository;

import java.util.List;

import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.boot.dto.GroupDTO;
import com.sample.boot.mapper.GroupMapper;

@Repository
public class GroupRepository {

	@Autowired
	private GroupMapper mapper;
	
	public void assign_User_Group_Relate(int userIdx, int groupIdx){
		Preconditions.checkArgument(userIdx > 0, "UserIdx Is Invalid");
		Preconditions.checkArgument(groupIdx > 0, "GroupIdx Is Invalid");		
		mapper.insert_User_Group_Relate(userIdx, groupIdx);
	}
	
	public List<GroupDTO> getGroupList(String groupIdxList){
		return mapper.getGroupListFromGroupIdx(groupIdxList);		
	}
}
