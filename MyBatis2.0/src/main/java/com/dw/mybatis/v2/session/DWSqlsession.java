package com.dw.mybatis.v2.session;

import com.dw.mybatis.v2.config.DWConfiguration;
import com.dw.mybatis.v2.config.MapperRepertory;
import com.dw.mybatis.v2.executor.DWExecutor;

/**
 * mybatis 主要类
 */
public class DWSqlsession {
    private DWConfiguration configuration ;
    private DWExecutor executor;

    public DWConfiguration getConfiguration() {
        return configuration;
    }

    public DWSqlsession(DWConfiguration configuration, DWExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T>T getMapper(Class clazz){
        return (T)configuration.getMapper(clazz,this);
    }
    public <T>T selectOne(MapperRepertory.MapperData  mapperData, String statement) throws Exception {
        return  (T)executor.query(mapperData ,statement);
    }
}
