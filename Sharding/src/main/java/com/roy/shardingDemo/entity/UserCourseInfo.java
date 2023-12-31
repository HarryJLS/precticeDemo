package com.roy.shardingDemo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @auth roykingw
 */
@TableName("user_course_info")
public class UserCourseInfo {

    private Long infoid;

    private String userid;

    private long courseid;

    @Override
    public String toString() {
        return "UserCourseInfo{" +
                "infoid=" + infoid +
                ", userid='" + userid + '\'' +
                ", courseid=" + courseid +
                '}';
    }

    public Long getInfoid() {
        return infoid;
    }

    public void setInfoid(Long infoid) {
        this.infoid = infoid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public long getCourseid() {
        return courseid;
    }

    public void setCourseid(long courseid) {
        this.courseid = courseid;
    }
}
