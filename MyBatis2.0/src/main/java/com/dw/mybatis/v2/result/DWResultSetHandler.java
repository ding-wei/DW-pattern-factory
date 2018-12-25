package com.dw.mybatis.v2.result;

import com.dw.mybatis.v2.config.DWConfiguration;
import com.dw.mybatis.v2.config.MapperRepertory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DWResultSetHandler {
    private DWConfiguration configuration ;

    public DWResultSetHandler(DWConfiguration configuration) {
        this.configuration = configuration;
    }

    public <T>T handle(ResultSet rs, MapperRepertory.MapperData mapperData) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object resultObject = new DefaultObjectFactory().create(mapperData.getType());
        if (rs.next()){
            int i = 0;
        for (Field field : resultObject.getClass().getDeclaredFields()){
            setValue(resultObject,field,rs,i);
        }
    }
     return (T)resultObject;
    }

    private void setValue(Object resultObject, Field field, ResultSet rs, int i) throws NoSuchMethodException, SQLException, InvocationTargetException, IllegalAccessException {
        Method setMethod = resultObject.getClass().getMethod("set"+upperCapital(field.getName()),field.getType());
        setMethod.invoke(resultObject,getResult(field,rs));
    }

    private Object getResult(Field field, ResultSet rs) throws SQLException {
        Class<?> type = field.getType();
        if (Integer.class == type){
            return rs.getInt(field.getName());
        }
        if (String.class == type){
            return rs.getString(field.getName());
        }
        return rs.getString(field.getName());
    }

    private String upperCapital(String name) {
        String first = name.substring(0,1);
        String tail = name.substring(1);
        return first.toUpperCase()+tail;
    }

}
