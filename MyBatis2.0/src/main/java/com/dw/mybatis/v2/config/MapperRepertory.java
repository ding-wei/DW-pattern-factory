package com.dw.mybatis.v2.config;

import com.dw.mybatis.v2.annotation.SqlAnnotation;
import com.dw.mybatis.v2.config.mappers.TestMapper;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @所有的配置文件在这里读取
 */
public class MapperRepertory {
    public static  final  String namespace = "com.dw.mybatis.v2.config.mappers.TestMapper";
    public static  final Map<String,MapperData> sqlMap  = new HashMap<String, MapperData>();

    public MapperRepertory() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //这一段可以解析配置文件
        Class clzz = TestMapper.class;
        Method[] methods = clzz.getMethods();
        for (Method method : methods) {
            Annotation sqlAnnotation = method.getAnnotation(SqlAnnotation.class);
            sqlMap.put("com.dw.mybatis.v2.config.mappers.TestMapper.selectByPrimaryKey",
                    new MapperData((String) sqlAnnotation.getClass().getMethod("Sql").invoke(sqlAnnotation), method.getDeclaringClass()));
        }
    }

    public MapperData get(String nameSpace){
        return  sqlMap.get(nameSpace);
    }
    public class MapperData<T>{
       private String   Sql;
       private Class<T> Type;

        public String getSql() {
            return Sql;
        }

        public void setSql(String sql) {
            Sql = sql;
        }

        public Class<T> getType() {
            return Type;
        }

        public void setType(Class<T> type) {
            Type = type;
        }

        public MapperData(String sql, Class<T> type) {
            Sql = sql;
            Type = type;
        }

    }
}
