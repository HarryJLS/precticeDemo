package com.roy.shardingDemo;



/**
 * @author ：楼兰
 * @description:
 **/
@SpringBootApplication()
@MapperScan("com.roy.shardingDemo.mapper")
//集成cosid的springbootstarter需要声明这两个注解。其实应该放到框架里面去声明的，不应该交给应用声明。
//@EnableConfigurationProperties({MachineProperties.class})
//@ComponentScans(value = {@ComponentScan("me.ahoo.cosid")})
public class ShardingJDBCApplication{

    public static void main(String[] args) {
        SpringApplication.run(ShardingJDBCApplication.class,args);
    }

}
