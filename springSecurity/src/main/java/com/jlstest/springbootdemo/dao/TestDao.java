package com.jlstest.springbootdemo.dao;

import com.jlstest.springbootdemo.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @className: testDao
 * @Description: TODO
 * @author: JLS
 * @date: 2023/3/22 19:10
 */
@Mapper
public interface TestDao {

    /**
     * 获取所有的用户信息
     * 
     * @return list 用户信息列表
     */
    List<User> listAllUserMessage();

    /**
     * 保存用户信息
     * 
     * @param user
     *            用户信息
     */
    void saveUser(User user);
}
