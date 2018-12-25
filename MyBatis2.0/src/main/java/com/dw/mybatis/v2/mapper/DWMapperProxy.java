package com.dw.mybatis.v2.mapper;

import com.dw.mybatis.v2.config.MapperRepertory;
import com.dw.mybatis.v2.session.DWSqlsession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DWMapperProxy implements InvocationHandler {
    private DWSqlsession sqlsession ;

    public DWMapperProxy(DWSqlsession sqlsession) {
        this.sqlsession = sqlsession;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MapperRepertory.MapperData mapperData = sqlsession.getConfiguration().
                getMapperRepertory().get(method.getDeclaringClass().getName() + "." + method.getName());;
        if (mapperData != null){

            System.out.println(String.format("SQL :", mapperData.getSql()));

            return sqlsession.selectOne(mapperData, String.valueOf(args[0]));
        }
        return method.invoke(this,args);
    }
}
