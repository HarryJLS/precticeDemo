package com.roy.shardingDemo;

import org.junit.Test;

import java.sql.*;

/**
 * @auth roykingw
 */
public class ShardingJDBCDriverTest {

    @Test
    public void test() throws ClassNotFoundException, SQLException {
        String jdbcDriver = "org.apache.shardingsphere.driver.ShardingSphereDriver";
        String jdbcUrl = "jdbc:shardingsphere:classpath:config.yaml";
        String sql = "select * from sharding_db.course";

        Class.forName(jdbcDriver);
        try(Connection connection = DriverManager.getConnection(jdbcUrl);) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("course cid= "+resultSet.getLong("cid"));
            }
        }
    }
}
