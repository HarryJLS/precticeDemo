package com.jlstest.springbootdemo.model;

import lombok.Data;

/**
 * @author JLS
 * @description:
 * @since 2023-06-29 15:21
 */
@Data
public class LoginForm {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
