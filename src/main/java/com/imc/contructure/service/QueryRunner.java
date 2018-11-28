package com.imc.contructure.service;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * @author luoly
 * @date 2018/11/27 10:15
 * @description db连接抽象类，具体连接由子类实现，模板方法模式+工厂方法模式
 */
public abstract class QueryRunner {

    public ResultSet run() throws Exception{
        Connection connection = this.createConnection();
        String sql = this.createSql();
        ResultSet resultSet = this.runSql(connection, sql);
        return resultSet;
    }

    protected abstract Connection createConnection();
    protected abstract String createSql();
    protected abstract ResultSet runSql (Connection connection, String sql) throws Exception;
}
