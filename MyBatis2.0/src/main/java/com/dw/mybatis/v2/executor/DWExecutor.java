package com.dw.mybatis.v2.executor;

import com.dw.mybatis.v2.config.MapperRepertory;

public interface DWExecutor {
    <T> T query(MapperRepertory.MapperData mapperData, String statement) throws Exception;
}
