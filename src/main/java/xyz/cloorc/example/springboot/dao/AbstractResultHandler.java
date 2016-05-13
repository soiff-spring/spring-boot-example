package xyz.cloorc.example.springboot.dao;

import org.apache.ibatis.session.ResultHandler;

public abstract class AbstractResultHandler<T> implements ResultHandler<T> {
    public abstract T getObject();
}
