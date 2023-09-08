package com.example.springbootdemo.designpatterns.abstractFactory;

/**
 * @author JLS
 * @description: 抽象工厂模式 (定义接口，来进行不同的实现)
 * @since 2023-05-13 15:45
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        IDatabaseUtils iDatabaseUtils = new MysqlDataBaseUtils();
        IConnection connection = iDatabaseUtils.getConnection();
        connection.connect();
        ICommend commend = iDatabaseUtils.getCommend();
        commend.command();

    }
}
interface IConnection {
    void connect();
}
class MysqlConnection implements IConnection {
    @Override
    public void connect() {
        System.out.println("connect is start !");
    }
}
interface ICommend {
    void command();
}
class MysqlCommend implements ICommend {
    @Override
    public void command() {
        System.out.println("commend is start!");
    }
}
interface IDatabaseUtils {
    IConnection getConnection();
    ICommend getCommend();
}
class MysqlDataBaseUtils implements IDatabaseUtils {
    @Override
    public IConnection getConnection() {
        return new MysqlConnection();
    }

    @Override
    public ICommend getCommend() {
        return new MysqlCommend();
    }
}
