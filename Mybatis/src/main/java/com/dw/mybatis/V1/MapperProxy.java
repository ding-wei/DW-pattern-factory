package com.dw.mybatis.V1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxy implements InvocationHandler {
    private DWSqlSession sqlSession ;

    public MapperProxy(DWSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(method.getDeclaringClass().getName());
        System.out.println(method.getName());
        if(method.getDeclaringClass().getName().equals(DWConfiguration.TestMapperXml.nameSpace)){
            String sql = DWConfiguration.TestMapperXml.sqlMap.get(method.getName());
          return  sqlSession.selectOne(sql,String.valueOf(args[0]));
        }
        return method.invoke(this,args);
    }
}
