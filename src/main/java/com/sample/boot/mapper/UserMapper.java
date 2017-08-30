package com.sample.boot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.sample.boot.dto.UserDTO;

@Mapper
public interface UserMapper {

	
	final String SELECT_GET_USER_INFO = "select count(*) as count "
									  + "from USER U "
									  + "where U.U_EXTERNAL_ID = #{facebookId}";
	
	@Results({
		@Result(property = "count", column = "count")					
	})
	@Select(SELECT_GET_USER_INFO)
	int getUserInfo(@Param("facebookId")String facebookId);
	
	final String INSERT_NEW_USER = "insert into USER "
								 + "(U_NAME, U_EXTERNAL_ID, U_DATE) "
								 + "values(#{user.userName}, #{user.externalId}, now())";
	
	@Insert(INSERT_NEW_USER)
	void inserNewUser(@Param("user")UserDTO user);
}
