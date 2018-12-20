package com.dw.mybatis.V1;

public class DWSqlSession {
 private DWConfiguration configuration ;
 private DWExecutor executor ;

    public DWSqlSession(DWConfiguration configuration, DWExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }
    public <T>T getMapper(Class clazz){
      return configuration.getMapper(clazz,this);
    }
    public <T>T selectOne(String sql,String paramter){
         return executor.selectOne(sql,paramter);
    }
}
