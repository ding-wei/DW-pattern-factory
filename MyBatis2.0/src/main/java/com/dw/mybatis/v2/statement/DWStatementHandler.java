package com.dw.mybatis.v2.statement;

import com.dw.mybatis.v2.config.DWConfiguration;
import com.dw.mybatis.v2.config.MapperRepertory;
import com.dw.mybatis.v2.result.DWResultSetHandler;

import java.sql.*;

/**
 * 获取参数并且执行出结果
 */
public class DWStatementHandler {
    private DWConfiguration configuration ;
    private  DWResultSetHandler resultSetHandler;
    public DWStatementHandler(DWConfiguration configuration) {
        this.configuration = configuration;
        resultSetHandler = new DWResultSetHandler(this.configuration );
    }

    public <T>T query(MapperRepertory.MapperData mapperData, String statement) throws Exception {
        DWResultSetHandler resultSetHandler = new DWResultSetHandler(configuration);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/runoob?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "123456");
            preparedStatement = connection.prepareStatement(mapperData.getSql());
            preparedStatement.setInt(1, Integer.parseInt(statement));
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getResultSet();
            return (T)resultSetHandler.handle(rs,mapperData);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
