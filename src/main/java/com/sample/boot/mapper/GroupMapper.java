package com.sample.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sample.boot.dto.GroupDTO;

@Mapper
public interface GroupMapper {

	final String GROUP_COUNT = "select count(*) as count "
							 + "from kydbtest.GROUP";
	
	@Select(GROUP_COUNT)
	int getGroupCount();
	
	final String INSERT_U_G_RELATE = "insert into U_G_RELATE "
												+ "("
													+ "UGR_DATE, "
													+ "U_IDX, "
													+ "G_IDX"
												+ ") "
											+ "values"
												+ "("
													+ "now(), "
													+ "#{userIdx}, "
													+ "#{groupIdx}"
												+ ")";
	
	@Insert(INSERT_U_G_RELATE)
	void insert_User_Group_Relate(@Param("userIdx") int userIdx, @Param("groupIdx") int groupIdx);
	
	final String SELECT_GROUP_LIST_FROM_GROUP_IDX = "select * "
												  + "from GROUP "
												  + "where G_IDX in (${groupIdxList})"; 
	
	@Select(SELECT_GROUP_LIST_FROM_GROUP_IDX)
	List<GroupDTO> getGroupListFromGroupIdx(@Param("groupIdxList")String groupIdxList);
}
