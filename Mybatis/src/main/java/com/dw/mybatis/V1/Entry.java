package com.dw.mybatis.V1;

import com.dw.mybatis.V1.bean.Test;

public class Entry {
    public static void main(String[] args) {
        DWSqlSession sqlSession = new DWSqlSession(new DWConfiguration(),new DWSimpleExecutor());
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        Test test = testMapper.selectByPrimaryKey(4222);
        System.out.println(test.toString());;
    }
}
