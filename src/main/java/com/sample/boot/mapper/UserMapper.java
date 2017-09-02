package com.sample.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.sample.boot.dto.UserDTO;

@Mapper
public interface UserMapper {

	
	final String SELECT_GET_USER_INFO = "select * "
									  + "from USER U "
									  + "where U.U_EXTERNAL_ID = #{facebookId}";
	
	@Results({
		@Result(property = "userIdx", column = "U_IDX"),					
		@Result(property = "userName", column = "U_NAME"),					
		@Result(property = "externalId", column = "U_EXTERNAL_ID")					
	})
	@Select(SELECT_GET_USER_INFO)
	UserDTO getUserInfo(@Param("facebookId")String facebookId);
	
	final String INSERT_NEW_USER = "insert into USER "
								 + "(U_NAME, U_EXTERNAL_ID, U_DATE) "
								 + "values(#{user.userName}, #{user.externalId}, now())";
	
	@Insert(INSERT_NEW_USER)
	void inserNewUser(@Param("user")UserDTO user);
	
	final String SELECT_USER_GROUP_RELATE_GROUP_LIST_FROM_USER_IDX = 
										  "select * from U_G_RELATE "
										+ "where U_IDX = #{userIdx}";
	
	@Select(SELECT_USER_GROUP_RELATE_GROUP_LIST_FROM_USER_IDX)
	List<Integer> getGroupIdxListFromUserIdx(@Param("userIdx")int userIdx);
}
