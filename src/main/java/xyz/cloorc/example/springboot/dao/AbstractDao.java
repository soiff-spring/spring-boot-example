package xyz.cloorc.example.springboot.dao;

import java.lang.reflect.ParameterizedType;

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
}