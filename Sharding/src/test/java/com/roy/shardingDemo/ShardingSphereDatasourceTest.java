package com.roy.shardingDemo;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @auth roykingw
 */
public class ShardingSphereDatasourceTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("org.apache.shardingsphere.driver.ShardingSphereDriver");
        dataSource.setJdbcUrl("jdbc:shardingsphere:classpath:config.yaml");

//        Class.forName("org.apache.shardingsphere.driver.ShardingSphereDriver");
//        String jdbcUrl = "jdbc:shardingsphere:classpath:config.yaml";
//        Connection conn = DriverManager.getConnection(jdbcUrl);

        Connection conn = dataSource.getConnection();

        String sql = "SELECT cid,cname,user_id,cstatus from course where cid=851198093910081536";
        try {
            //ShardingConnectioin
            conn = dataSource.getConnection();
            //ShardingStatement
            Statement statement = conn.createStatement();
            //ShardingResultSet
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                System.out.println("result:" + result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (null != conn) {
                conn.close();
            }
        }
    }
}
