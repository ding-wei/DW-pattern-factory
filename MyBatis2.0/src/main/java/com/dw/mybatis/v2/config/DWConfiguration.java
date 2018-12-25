package com.dw.mybatis.v2.config;

import com.dw.mybatis.v2.mapper.DWMapperProxy;
import com.dw.mybatis.v2.session.DWSqlsession;

import java.lang.reflect.Proxy;

public class DWConfiguration {
    private  MapperRepertory mapperRepertory = new MapperRepertory();

    public MapperRepertory getMapperRepertory() {
        return mapperRepertory;
    }

    public <T> T getMapper(Class clazz, DWSqlsession sqlsession) {
        return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{clazz},new DWMapperProxy(sqlsession));
}

}
