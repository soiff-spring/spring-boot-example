package xyz.cloorc.example.springboot.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public abstract class AbstractDao<T> extends SqlSessionDaoSupport {

	private final String namespace;
	
	public AbstractDao() {
		namespace = getNameSpace();
	}
	
	public final String getNameSpace() {
        if (this.getClass().getGenericSuperclass() instanceof ParameterizedType) {
            return ((Class<?>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName()+".";
        } else {
            return ((Class<?>)((ParameterizedType)this.getClass().getSuperclass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName()+".";
        }
	}
	public final String route () {
        return namespace + Thread.currentThread().getStackTrace()[3].getMethodName();
	}
	
	public abstract void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory);
	
	public List<T> select () {
		return super.getSqlSession().selectList(route(), null);
	}
	public T select (Object id) {
		return super.getSqlSession().selectOne(route());
	}
	public int insert (T object) {
		return super.getSqlSession().insert(route(), object);
	}
}
