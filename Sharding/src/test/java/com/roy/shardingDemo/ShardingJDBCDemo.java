package com.roy.shardingDemo;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.shardingsphere.driver.api.ShardingSphereDataSourceFactory;
import org.apache.shardingsphere.infra.config.algorithm.AlgorithmConfiguration;
import org.apache.shardingsphere.sharding.api.config.ShardingRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.rule.ShardingTableRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.strategy.keygen.KeyGenerateStrategyConfiguration;
import org.apache.shardingsphere.sharding.api.config.strategy.sharding.StandardShardingStrategyConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author ：楼兰
 * @description:
 **/

public class ShardingJDBCDemo {
    public static void main(String[] args) throws SQLException {

        //=======一、配置数据库
        Map<String, DataSource> dataSourceMap = new HashMap<>(2);//为两个数据库的datasource
        // 配置第一个数据源
        HikariDataSource dataSource0 = new HikariDataSource();
        dataSource0.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource0.setJdbcUrl("jdbc:mysql://localhost:3306/coursedb?serverTimezone=GMT%2B8&useSSL=false");
        dataSource0.setUsername("root");
        dataSource0.setPassword("root");
        dataSourceMap.put("m0", dataSource0);
        // 配置第二个数据源
        HikariDataSource dataSource1 = new HikariDataSource();
        dataSource1.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource1.setJdbcUrl("jdbc:mysql://localhost:3306/coursedb2?serverTimezone=GMT%2B8&useSSL=false");
        dataSource1.setUsername("root");
        dataSource1.setPassword("root");
        dataSourceMap.put("m1", dataSource1);
        //=======二、配置分库分表策略
        ShardingRuleConfiguration shardingRuleConfig = createRuleConfig();
        //三、配置属性值
        Properties properties = new Properties();
        //打开日志输出 4.x版本是sql.show，5.x版本变成了sql-show
        properties.setProperty("sql-show", "true");
        //K1 创建ShardingSphere的数据源 ShardingDataSource
        DataSource dataSource = ShardingSphereDataSourceFactory.createDataSource(dataSourceMap,Collections.singleton(shardingRuleConfig), properties);

        //-------------测试部分-----------------//
        ShardingJDBCDemo test = new ShardingJDBCDemo();
        //建表
//        test.droptable(dataSource);
//        test.createtable(dataSource);

        //插入数据
//        test.addcourse(dataSource);
        //K1 调试的起点 查询数据
        test.querycourse(dataSource);
    }

    private static ShardingRuleConfiguration createRuleConfig(){
        ShardingRuleConfiguration result = new ShardingRuleConfiguration();
        //spring.shardingsphere.rules.sharding.tables.course.actual-data-nodes=m$->{0..1}.course_$->{1..2}
        ShardingTableRuleConfiguration courseTableRuleConfig = new ShardingTableRuleConfiguration("course",
                "m$->{0..1}.course_$->{1..2}");
        //spring.shardingsphere.rules.sharding.key-generators.alg_snowflake.type=SNOWFLAKE
        //spring.shardingsphere.rules.sharding.key-generators.alg_snowflake.props.worker.id=1
        Properties snowflakeprop = new Properties();
        snowflakeprop.setProperty("worker.id", "123");
        result.getKeyGenerators().put("alg_snowflake", new AlgorithmConfiguration("SNOWFLAKE", snowflakeprop));
        //spring.shardingsphere.rules.sharding.tables.course.key-generate-strategy.column=cid
        //spring.shardingsphere.rules.sharding.tables.course.key-generate-strategy.key-generator-name=alg_snowflake
        courseTableRuleConfig.setKeyGenerateStrategy(new KeyGenerateStrategyConfiguration("cid","alg_snowflake"));
        //spring.shardingsphere.rules.sharding.tables.course.database-strategy.standard.sharding-column=cid
        //spring.shardingsphere.rules.sharding.tables.course.database-strategy.standard.sharding-algorithm-name=course_db_alg
        courseTableRuleConfig.setDatabaseShardingStrategy(new StandardShardingStrategyConfiguration("cid","course_db_alg"));
        //spring.shardingsphere.rules.sharding.sharding-algorithms.course_db_alg.type=MOD
        //spring.shardingsphere.rules.sharding.sharding-algorithms.course_db_alg.props.sharding-count=2
        Properties modProp = new Properties();
        modProp.put("sharding-count",2);
        result.getShardingAlgorithms().put("course_db_alg",new AlgorithmConfiguration("MOD",modProp));
        //spring.shardingsphere.rules.sharding.tables.course.table-strategy.standard.sharding-column=cid
        //spring.shardingsphere.rules.sharding.tables.course.table-strategy.standard.sharding-algorithm-name=course_tbl_alg
        courseTableRuleConfig.setTableShardingStrategy(new StandardShardingStrategyConfiguration("cid","course_tbl_alg"));
        //#spring.shardingsphere.rules.sharding.sharding-algorithms.course_tbl_alg.type=INLINE
        //#spring.shardingsphere.rules.sharding.sharding-algorithms.course_tbl_alg.props.algorithm-expression=course_$->{cid%2+1}
        Properties inlineProp = new Properties();
        inlineProp.setProperty("algorithm-expression", "course_$->{((cid+1)%4).intdiv(2)+1}");
        result.getShardingAlgorithms().put("course_tbl_alg",new AlgorithmConfiguration("INLINE",inlineProp));

        result.getTables().add(courseTableRuleConfig);
        return result;
    }

    //添加10条课程记录
    public void addcourse(DataSource dataSource) throws SQLException {
        for (int i = 1; i < 10; i++) {
            long orderId = executeAndGetGeneratedKey(dataSource, "INSERT INTO course (cname, user_id, cstatus) VALUES ('java'," + i + ", '1')");
            System.out.println("添加课程成功，课程ID：" + orderId);
        }
    }

    public void querycourse(DataSource dataSource) throws SQLException {
        Connection conn = null;
        try {
            //ShardingConnectioin
            conn = dataSource.getConnection();
            //ShardingStatement
            Statement statement = conn.createStatement();
            String sql = "SELECT cid,cname,user_id,cstatus from course where cid=851198093910081536";
            //ShardingResultSet
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                System.out.println("result:" + result.getLong("cid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (null != conn) {
                conn.close();
            }
        }
    }

    private void execute(final DataSource dataSource, final String sql) throws SQLException {
        try (
                Connection conn = dataSource.getConnection();
                Statement statement = conn.createStatement()) {
            statement.execute(sql);
        }
    }

    private long executeAndGetGeneratedKey(final DataSource dataSource, final String sql) throws SQLException {
        long result = -1;
        try (
                Connection conn = dataSource.getConnection();
                Statement statement = conn.createStatement()) {
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                result = resultSet.getLong(1);
            }
        }
        return result;
    }

    /**
     * -----------------------------表初始化--------------------------------
     */
    public void droptable(DataSource dataSource) throws SQLException {
        execute(dataSource, "DROP TABLE IF EXISTS course_1");
        execute(dataSource, "DROP TABLE IF EXISTS course_2");
    }

    public void createtable(DataSource dataSource) throws SQLException {
        execute(dataSource, "CREATE TABLE course_1 (cid BIGINT(20) PRIMARY KEY,cname VARCHAR(50) NOT NULL,user_id BIGINT(20) NOT NULL,cstatus varchar(10) NOT NULL);");
        execute(dataSource, "CREATE TABLE course_2 (cid BIGINT(20) PRIMARY KEY,cname VARCHAR(50) NOT NULL,user_id BIGINT(20) NOT NULL,cstatus varchar(10) NOT NULL);");
    }
}
