package com.sample.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.boot.repository.GroupRepository;

@Service
public class GroupService {

	@Autowired
	private GroupRepository repository;
	
}
