package com.roy.shardingDemo.entity;

import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @author ：楼兰
 * @description: 课程表，主要测试分库分表功能
 **/
public class Course {
    private Long cid;
//  如果使用id作为主键，注意MyBatis会默认对id字段生成主键。
//    private Long id;

    private String cname;
    private Long userId;
    private String cstatus;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCstatus() {
        return cstatus;
    }

    public void setCstatus(String cstatus) {
        this.cstatus = cstatus;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", userId=" + userId +
                ", cstatus='" + cstatus + '\'' +
                '}';
    }
}
