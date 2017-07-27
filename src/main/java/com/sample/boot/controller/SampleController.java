package com.sample.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {
	@RequestMapping(path = "/")
	@ResponseBody
	public String hello(){
		return "hello world";
	}
}
