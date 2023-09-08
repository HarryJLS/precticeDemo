package com.jlstest.springbootdemo.service;

import com.jlstest.springbootdemo.model.User;

/**
 * @className: TestService
 * @Description: TODO
 * @author: JLS
 * @date: 2023/3/22 19:10
 */
public interface TestService {

    /**
     * 查询所有的用户信息
     * 
     * @return String 用户信息json
     */
    String queryUserMessage();

    /**
     * 新增用户数据
     * 
     * @param user
     *            用户信息
     * @return String 反馈信息
     */
    String saveData(User user);
}
