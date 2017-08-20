package com.sample.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.boot.repository.SampleRepository;

@Controller
public class SampleController {
	
	@Autowired
	private SampleRepository repository;
	
	@RequestMapping(path = "/")
	@ResponseBody
	public String hello(){
		return "hello world";
	}
}
