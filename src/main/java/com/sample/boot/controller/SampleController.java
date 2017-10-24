package com.sample.boot.controller;

import com.sample.boot.dto.GroupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.sample.boot.service.GroupService;

import java.util.List;

@RestController
public class SampleController {
	
	@Autowired
	private GroupService service;
	
	@RequestMapping(path = "/test/{userIdx}", method = RequestMethod.GET)
	public List<GroupDTO> hello(@PathVariable("userIdx") int userIdx){
		List<GroupDTO> result =  service.getGroupList(userIdx);

		if(result != null)
			System.out.println("Not Null");
		else
			System.out.println("Null");

		return result;
	}
}
