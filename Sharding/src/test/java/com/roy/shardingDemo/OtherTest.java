package com.roy.shardingDemo;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.roy.shardingDemo.entity.Dict;
import com.roy.shardingDemo.entity.User;
import com.roy.shardingDemo.entity.UserCourseInfo;
import com.roy.shardingDemo.mapper.DictMapper;
import com.roy.shardingDemo.mapper.UserCourseInfoMapper;
import com.roy.shardingDemo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * 其他测试案例。主要包含主键生成算法、数据加密算法、广播表、绑定表
 * @auth roykingw
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OtherTest {

    @Resource
    private UserMapper userMapper;
    @Resource
    private DictMapper dictMapper;
    @Resource
    private UserCourseInfoMapper userCourseInfoMapper;


    /**
     * 主键生成策略，生成字符串型的ID。
     * 密码加密策略：对password字段进行加密
     * 读写分离测试
     */
    @Test
    public void addUser(){
        for (int i = 0; i < 10; i++) {
            User user = new User();
//            user.setUserid();
            user.setUsername("user"+i);
            user.setPassword("123qweasd");
            user.setUserstatus("NORMAL");
            user.setAge(30+i);
            user.setSex(i%2==0?"F":"M");

            userMapper.insert(user);
        }
    }

    /**
     * 查询用户测试：
     *  根据userid进行SQL路由
     *  对password，会转为按照加密后的passowrd_cipher字段进行查询。
     *  读写分离测试
     */
    @Test
    public void queryUser() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("userid","1644954727911317506");
        queryWrapper.eq("password","123qweasd");
        List<User> users = userMapper.selectList(queryWrapper);
        for(User user : users){
            System.out.println(user);
        }
    }

    /**
     * 添加dict： 广播表测试
     */
    @Test
    public void addDict() {
        Dict dict = new Dict();
        dict.setDictkey("F");
        dict.setDictval("女");
        dictMapper.insert(dict);

        Dict dict2 = new Dict();
        dict2.setDictkey("M");
        dict2.setDictval("男");
        dictMapper.insert(dict2);
    }

    /**
     * 查询dict： 广播表测试
     * 只从一个库中查询。随机选一个库。
     */
    @Test
    public void queryDict() {
        QueryWrapper<Dict> wrapper = new QueryWrapper<Dict>();
        wrapper.eq("dictkey", "F");
        List<Dict> dicts = dictMapper.selectList(wrapper);
        dicts.forEach(dict -> System.out.println(dict));
    }

    /**
     * 添加用户订阅的课程信息： 绑定表测试
     * 用户信息和用户课程关联信息，都按照userid进行分片
     * user表没有使用序列化生成器，后面的user_course_info表也就不能用序列化生成器。
     */
    @Test
    public void addUserCourseInfo(){
        for (int i = 0; i < 10; i++) {
            String userId = NanoIdUtils.randomNanoId();
            User user = new User();
            user.setUserid(userId);
            user.setUsername("user"+i);
            user.setPassword("123qweasd");
            user.setUserstatus("NORMAL");
            user.setAge(30+i);
            user.setSex(i%2==0?"F":"M");

            System.out.println("userId:"+userMapper.insert(user));
            for (int j = 0; j < 5; j++) {
                UserCourseInfo userCourseInfo = new UserCourseInfo();
                userCourseInfo.setInfoid(System.currentTimeMillis()+j);
                userCourseInfo.setUserid(userId);
                userCourseInfo.setCourseid(10000+j);
                System.out.println("userCourseInfo Id:"+userCourseInfoMapper.insert(userCourseInfo));
            }
        }
    }

    /**
     * 绑定表查询测试
     * user和user_course_info两张表有相同的分片建userid。
     * 如果不配置绑定表，那么两张表的联合查询将要进行笛卡尔集合查询。需要查询四次
     * 配置绑定表后，两张表的联合查询就可以按相同的分片键进行关联。就只需要查询两次了
     */
    @Test
    public void queryUserCourseInfo(){
        List<UserCourseInfo> userCourseInfos = userCourseInfoMapper.queryUserCourse();
        for (UserCourseInfo userCourseInfo : userCourseInfos) {
            System.out.println(userCourseInfo);
        }
    }
}
