package com.imc.contructure.service.impl;

import com.imc.contructure.service.QueryRunner;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * @author luoly
 * @date 2018/11/27 10:43
 * @description
 */
public class SybaseQueryRunner extends QueryRunner{

    @Override
    protected Connection createConnection() {
        System.out.println("createConnection~~");
        return null;
    }

    @Override
    protected String createSql() {
        System.out.println("createSql**");
        return null;
    }

    @Override
    protected ResultSet runSql(Connection connection, String sql) {
        System.out.println("runSql--->");
        return null;
    }
}
