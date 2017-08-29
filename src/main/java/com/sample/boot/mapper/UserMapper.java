package com.sample.boot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

	
	final String SELECT_GET_USER_INFO = "select count(*) as count "
									  + "from USER U "
									  + "where U.U_FACEBOOK_ID = #{facebookId}";
	
	@Results({
		@Result(property = "count", column = "count")					
	})
	@Select(SELECT_GET_USER_INFO)
	int getUserInfo(@Param("facebookId")String facebookId);
}
