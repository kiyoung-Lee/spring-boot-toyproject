package com.sample.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.boot.service.GroupService;

@Controller
public class SampleController {
	
	@Autowired
	private GroupService service;
	
	@RequestMapping(path = "/test")
	@ResponseBody
	public void hello(){
	
		
	}
}
