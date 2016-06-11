package xyz.cloorc.example.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xyz.cloorc.example.springboot.autoconfigure.SimpleProperties;
import xyz.cloorc.example.springboot.dao.DaoExample;
import xyz.cloorc.example.springboot.po.Example;

@Service
@EnableConfigurationProperties({SimpleProperties.Simple.class})
public class ServiceExample {
	@Autowired
	DaoExample example;
	@Autowired(required = false)
	SimpleProperties.Simple properties;

	public String simple () {
		return null != properties ? properties.toString() : null;
	}

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
