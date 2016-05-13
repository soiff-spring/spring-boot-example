package xyz.cloorc.example.springboot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xyz.cloorc.example.springboot.po.Example;

@Repository
public class DaoExample extends AbstractDao<Example> {
	
	public List<Example> selectAll () {
		return super.select();
	}
	
	public Example selectOne (Long id) {
		return super.select(id, new ResultHandlerExample());
	}
	
	public int insertOne (Example e) {
		return super.insert(e);
	}

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
