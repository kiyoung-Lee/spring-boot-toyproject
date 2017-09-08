package com.sample.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.boot.common.BaseResponse;
import com.sample.boot.dto.UserDTO;
import com.sample.boot.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService service;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public BaseResponse login(@RequestBody UserDTO loginUser){
		BaseResponse response = new BaseResponse();
		
		UserDTO loginResult = service.login(loginUser);
		if(loginResult != null){
			response.setSuccess(true);
			response.setData(loginResult);
			response.setMessage("�α��� ����");
		}else {
			response.setSuccess(false);
			response.setMessage("�α��� ����");
		}
		
		return response;
	}
}
