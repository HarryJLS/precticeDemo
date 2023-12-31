package com.roy.shardingDemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.roy.shardingDemo.entity.Course;
import com.roy.shardingDemo.mapper.CourseMapper;
import org.apache.shardingsphere.infra.hint.HintManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：楼兰
 * @description: 分库分表测试案例
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingTest {

    @Resource
    private CourseMapper courseMapper;

    //插入数据会进行分片
    @Test
//    @Transactional
    public void addcourse() {
        for (int i = 0; i < 10; i++) {
            Course c = new Course();
            c.setCname("java");
            c.setUserId(1001L);
            c.setCstatus("1");
            courseMapper.insert(c);
            //insert into course values ....
            System.out.println(c);
        }
    }

    /**
     * 针对分片键进行精确查询，都可以使用表达式控制
     * 对于in查询，4.x遇到混合分片结果，会直接走全分片路由。 新版本会进行精确分片
     * select * from course where cid=xxx
     */
    @Test
    public void queryCourse() {
        QueryWrapper<Course> wrapper = new QueryWrapper<Course>();
//        wrapper.eq("cid",851198095084486657L);
//        wrapper.in("cid",851198095084486657L,851198095139012609L,851198095180955649L,4L);
        //带上排序条件不影响分片逻辑
//        wrapper.orderByDesc("user_id");
        List<Course> courses = courseMapper.selectList(wrapper);
        courses.forEach(course -> System.out.println(course));
    }

    /**
     * 针对分片键进行范围查询。  （BETWEEN AND、>、<、>=、<=
     * 使用表达式控制时，无法直接支持范围查询。
     * 需要将参数allow-range-query-with-inline-sharding 设定为true(默认是false)，
     * 但此时，SQL执行将改为查询每一个数据分片。
     * ShardingJDBC新版本在实现时，是在每个库里以UNION的方式查询每个表。减少了SQL语句的数量。实际上对于所有全分片路由，都采用了这种优化方式。
     */
    @Test
    public void queryCourseRange(){
        //select * from course where cid between xxx and xxx
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.between("cid",799020475735871489L,799020475802980353L);
        List<Course> courses = courseMapper.selectList(wrapper);
        courses.forEach(course -> System.out.println(course));
    }


    /**
     * 使用COMPLEX_INLINE策略，使用多个分片键进行组合路由
     * cid和user_id进行组合分片
     */
    @Test
    public void queryCourseComplexSimple(){
        QueryWrapper<Course> wrapper = new QueryWrapper<Course>();
//        wrapper.orderByDesc("user_id");
        wrapper.in("cid",851198095084486657L,851198095139012609L);
//        wrapper.between("cid",799020475735871489L,799020475802980353L);
        wrapper.eq("user_id",1001L);
        List<Course> course = courseMapper.selectList(wrapper);
        //select * fro couse where cid in (xxx) and user_id between(8,3)
        System.out.println(course);
    }

    /**
     * 多个分片键进行自定义路由
     * INLINE方式只能通过表达式配置简单的路由逻辑。但是如果要配置复杂逻辑就需要自行扩展分片算法了。
     * 在这个示例中，我们知道user_id都是传的一个固定的1001。那么如果进行范围查询时，user_id的范围下限超过上限，或者范围明显不包含1001的时候，明显是不会有结果的，去数据库查询反而是浪费性能。
     * 这时，我们就会希望在分片算法时就快速做出错误判断，减少无谓的数据库查询。这就需要自定义分片算法。
     * 5.x版本中扩展分片算法的方式和4.x基本是差不多的。
     */
    @Test
    public void queryCourdeComplex(){
        QueryWrapper<Course> wrapper = new QueryWrapper<Course>();
        wrapper.in("cid",799020475735871489L,799020475802980353L);
        wrapper.between("user_id",3L,8L);
//        wrapper.between("user_id",3L,3L);
        List<Course> course = courseMapper.selectList(wrapper);
        //select * fro couse where cid in (xxx) and user_id between(8,3)
        System.out.println(course);
    }

    /**
     * 查询cid为奇数的课程信息。
     * 示例中course记录是按照cid的奇偶分片的。现在希望只查询cid为奇数的课程信息。
     * 直接通过MOD函数计算cid的奇偶，shardingJDBC无法识别虚拟列，因此无法进行分片计算，就只能全分片路由。
     */
    @Test
    public void unsupportTest(){
        //select * from course where mod(cid,2)=1
        List<Long> res = courseMapper.unsupportSql();
        res.forEach(System.out::println);
    }

    /**
     * 使用HINT强制路由策略。
     * 脱离SQL自己指定分片策略。
     * 强制查询course_1表
     */
    @Test
    public void queryCourseByHint(){
        //强制只查course_1表
        HintManager hintManager = HintManager.getInstance();
        //注意这两个属性，dataSourceBaseShardingValue用于强制分库
        // 强制查course_1表
//        hintManager.setDatabaseShardingValue(1L);
        hintManager.addTableShardingValue("course","1");
        //select * from course;
        List<Course> courses = courseMapper.selectList(null);
        courses.forEach(course -> System.out.println(course));
        //线程安全，所有用完要注意关闭。
        hintManager.close();
        //hintManager关闭的主要作用是清除ThreadLocal，释放内存。HintManager实现了AutoCloseable接口，所以建议使用try-resource的方式，用完自动关闭。
        //try(HintManager hintManager = HintManager.getInstance()){ xxxx }
    }


    @Test
//    @Transactional
    public void updateCourse(){
        Course c = new Course();
        UpdateWrapper<Course> wrapper = new UpdateWrapper<>();
        wrapper.set("user_id","5");
        courseMapper.update(c,wrapper);
    }
}
