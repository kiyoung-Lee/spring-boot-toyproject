package com.sample.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sample.boot.common.BaseResponse;
import com.sample.boot.dto.GroupDTO;
import com.sample.boot.dto.UserDTO;
import com.sample.boot.service.GroupService;

@RestController
public class GroupController {

	@Autowired
	GroupService service;
	
	@RequestMapping(value = "/grouplist", method = RequestMethod.GET)
	public BaseResponse getGroupList(@RequestParam("userIdx") int userIdx){
		BaseResponse response = new BaseResponse();
		
		List<GroupDTO> result = service.getGroupList(userIdx);
		if(result != null){
			response.setSuccess(true);
			response.setMessage("그룹 리스트 가져오기 성공.");
			response.setData(result);
		}else{
			response.setSuccess(false);
			response.setMessage("그룹 리스트 가져오기 실패.");
		}
		
		return response;
	}
}
