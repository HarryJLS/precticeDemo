package com.roy.shardingDemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roy.shardingDemo.entity.Course;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ：楼兰
 * @description:
 **/
public interface CourseMapper extends BaseMapper<Course> {

//    @Select("select * from coursedb.course")//会忽略schema
//    @Select("select * from course union all select * from course")//后面一个course就不会改写了。
//    @Select("select max(cid) from course group by user_id having user_id='1001'") //不支持这个SQL
    @Select("select * from course where MOD(cid,2)=1")
    List<Long> unsupportSql();
}
