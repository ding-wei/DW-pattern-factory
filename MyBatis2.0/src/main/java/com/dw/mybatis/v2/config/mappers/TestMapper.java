package com.dw.mybatis.v2.config.mappers;

import com.dw.mybatis.v2.annotation.SqlAnnotation;
import com.dw.mybatis.v2.bean.Test;
import org.apache.ibatis.annotations.ResultType;
public interface TestMapper {
     @SqlAnnotation(Sql = "select * from test where id= ?")
     @ResultType(TestMapper.class)
     Test selectByPrimaryKey(Integer id);
}
