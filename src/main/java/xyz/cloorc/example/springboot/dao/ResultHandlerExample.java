package xyz.cloorc.example.springboot.dao;

import org.apache.ibatis.session.ResultContext;

import xyz.cloorc.example.springboot.po.Example;

public class ResultHandlerExample extends AbstractResultHandler<Example> {

    private ResultContext<? extends Example> context;

    @Override
    public void handleResult(ResultContext< ? extends Example> resultContext) {
        context = resultContext;
    }

    @Override
    public Example getObject() {
        return null != context ? context.getResultObject() : null;
    }
}
