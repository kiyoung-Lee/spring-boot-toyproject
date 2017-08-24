package com.sample.boot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GroupMapper {

	final String GROUP_COUNT = "select count(*) as count "
							 + "from kydbtest.GROUP";
	
	@Select(GROUP_COUNT)
	int getGroupCount();
	
}
