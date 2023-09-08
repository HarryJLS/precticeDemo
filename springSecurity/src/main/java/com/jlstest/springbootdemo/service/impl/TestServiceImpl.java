package com.jlstest.springbootdemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.jlstest.springbootdemo.dao.TestDao;
import com.jlstest.springbootdemo.model.User;
import com.jlstest.springbootdemo.service.TestService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2023-03-22 19:11
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestDao testDao;

    /**
     * 查询所有的用户信息
     *
     * @return String 用户信息json
     */
    @Override
    public String queryUserMessage() {
        // 获取所有的用户信息
        List<User> userList = testDao.listAllUserMessage();
        // 判空校验
        if (!CollectionUtils.isEmpty(userList)) {
            return JSON.toJSONString(userList);
        }
        return "没有数据";
    }

    /**
     * 新增用户数据
     *
     * @param user 用户信息
     * @return String 反馈信息
     */
    @Override
    public String saveData(User user) {
        try {
            // 数据保存
            testDao.saveUser(user);
            return "success!";
        } catch (Exception e) {
            return "fail！";
        }
    }
}
