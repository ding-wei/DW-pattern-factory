package com.dw.mybatis.V1;

public interface DWExecutor {
    public <T> T selectOne(String sql, String paramter) ;
}
