package com.testspring.service;

import com.spring.Autowired;
import com.spring.Component;
import com.spring.InitializingBean;
import com.spring.JlsValue;
import com.spring.Scope;
import com.testspring.UserInterface;

/**
 * @author JLS
 * @description:
 * @since 2023-08-17 21:16
 */
@Component("userService")
@Scope("prototype")
public class UserService implements UserInterface {

    @Autowired
    private OrderService orderService;

    @JlsValue("jls")
    private String name;

    public void test() {
        System.out.println("test-->>>>" + orderService);
        System.out.println("test-->>>>" + name);
    }
}
