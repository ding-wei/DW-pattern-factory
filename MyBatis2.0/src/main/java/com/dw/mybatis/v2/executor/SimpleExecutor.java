package com.dw.mybatis.v2.executor;

import com.dw.mybatis.v2.config.DWConfiguration;
import com.dw.mybatis.v2.config.MapperRepertory;
import com.dw.mybatis.v2.statement.DWStatementHandler;

/**
 * 分解这个方法
 */
public class SimpleExecutor implements  DWExecutor{
    private DWConfiguration configuration;
    public SimpleExecutor(DWConfiguration configuration) {
        this.configuration = configuration;
    }

    public <T> T query(MapperRepertory.MapperData mapperData, String statement)  throws  Exception{
        DWStatementHandler statementHandler = new DWStatementHandler(configuration);

        return (T)statementHandler.query(mapperData,statement);
    }
}
