package com.roy.shardingDemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roy.shardingDemo.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ：楼兰
 * @description:
 **/
public interface UserMapper extends BaseMapper<User> {
}
