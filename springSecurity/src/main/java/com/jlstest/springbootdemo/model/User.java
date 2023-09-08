package com.jlstest.springbootdemo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author JLS
 * @description:
 * @since 2023-03-22 19:12
 */
@Data
public class User implements Serializable {

    public static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 注册手机号
     */
    private String phone;

    /**
     * 注册邮箱
     */
    private String email;
}
