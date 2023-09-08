package com.testspring;

import com.spring.JlsApplicationContext;
import com.testspring.service.OrderService;
import com.testspring.service.UserService;

/**
 * @author JLS
 * @description:
 * @since 2023-08-17 21:15
 */
public class Test {
    public static void main(String[] args) {

        // 扫描---->创建单例bean

        JlsApplicationContext jlsApplicationContext = new JlsApplicationContext(AppConfig.class);

        UserInterface userService = (UserInterface)jlsApplicationContext.getBean("userService");
        System.out.println(userService);
        userService.test();
//        UserService userService1 = (UserService)jlsApplicationContext.getBean("userService");
//        OrderService userService2 = (OrderService)jlsApplicationContext.getBean("orderService");
//        userService.test();
    }
}
