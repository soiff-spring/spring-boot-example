package xyz.cloorc.example.springboot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import xyz.cloorc.example.springboot.po.Example;

@Repository
public class DaoExample extends AbstractDao<Example> {
	
	public List<Example> select () {
		return super.select();
	}
	
	public Example select (Long id) {
		return super.select(id);
	}
	
	public boolean create (Example e) {
		return super.insert(e) > 0;
	}

	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		((SqlSessionDaoSupport)this).setSqlSessionFactory(sqlSessionFactory);
	}
}
