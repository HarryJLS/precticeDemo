package com.jlstest.springbootdemo.dao;

import java.util.List;

import com.jlstest.springbootdemo.model.Permission;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: PermissionDao
 * @Description: TODO
 * @author: JLS
 * @date: 2023/6/28 14:49
 */
@Mapper
public interface PermissionDao {

    /**
     * 根据用户id查询用户权限
     */
    List<Permission> selectByUserId(Long userId);
}
