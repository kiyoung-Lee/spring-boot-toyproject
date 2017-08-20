package com.sample.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.boot.Entity.Group;

public interface SampleRepository extends JpaRepository <Group, Integer> {

}
