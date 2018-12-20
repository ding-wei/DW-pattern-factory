package com.dw.mybatis.V1;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class DWConfiguration {
    public <T> T getMapper(Class clazz,DWSqlSession sqlSession) {
        return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{clazz},new MapperProxy(sqlSession));
    }
    public static class TestMapperXml{
        public static final String nameSpace = "com.dw.mybatis.V1.TestMapper";
        public static final Map<String,String> sqlMap = new HashMap<String, String>();
        static {
            sqlMap.put("selectByPrimaryKey","select * from test where id=?");
        }
    }
}
