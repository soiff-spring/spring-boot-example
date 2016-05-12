package xyz.cloorc.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.cloorc.example.springboot.dao.DaoExample;
import xyz.cloorc.example.springboot.po.Example;

@Service
public class ServiceExample {
	@Autowired
	DaoExample example;
	
	@Transactional
	public boolean insert (Example e) {
		return example.insertOne(e) > 0;
	}
	
	@Transactional
	public Example select (Long id) {
		return example.selectOne(id);
	}
	
	@Transactional
	public List<Example> select () {
		return example.selectAll();
	}
}
