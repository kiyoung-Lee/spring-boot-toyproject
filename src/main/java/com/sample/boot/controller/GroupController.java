package com.sample.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.boot.common.BaseResponse;
import com.sample.boot.dto.UserDTO;

@Controller
public class GroupController {

	@RequestMapping(value = "/grouplist", method = RequestMethod.GET)
	public BaseResponse getGroupList(@RequestBody UserDTO joinUser){
		BaseResponse response = new BaseResponse();
		
		return response;
	}
}
