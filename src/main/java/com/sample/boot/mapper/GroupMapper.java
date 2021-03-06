package com.sample.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.sample.boot.dto.GroupDTO;

@Mapper
public interface GroupMapper {
	
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
	
	
	final String SELECT_GROUP_LIST_FROM_USER_IDX = "select * "
												  + "from kydbtest.GROUP "
												  + "where G_IDX in (select G_IDX from U_G_RELATE where U_IDX = #{userIdx})"; 
	
	@Results({
		@Result(property = "groupIdx", column = "G_IDX"),					
		@Result(property = "groupName", column = "G_NAME"),					
		@Result(property = "thumbnail", column = "G_THUMBNAIL"),
		@Result(property = "date", column = "G_DATE")
	})
	@Select(SELECT_GROUP_LIST_FROM_USER_IDX)
	List<GroupDTO> getGroupListFromGroupIdx(@Param("userIdx")int userIdx);
}
