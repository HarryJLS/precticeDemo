package com.jlstest.entitytodtoDemo.entity;

import lombok.Data;

/**
 * @author JLS
 * @description:
 * @since 2023-11-17 17:06
 */
@Data
public class CcTasklogEntity implements java.io.Serializable {
    public static final long serialVersionUID = 1L;

//    id           int auto_increment
//    primary key,
//    service_name varchar(100) not null comment '服务器标识',
//    task_name    varchar(100) not null comment '任务名称',
//    module_name  varchar(200) not null comment '模块名称',
//    start_time   datetime     not null comment '任务开始时间',
//    end_time     datetime     null comment '任务结束时间',
//    state        char(2)      not null comment '任务状态：0开始;1成功结束;2失败结束;99其他异常',
//    fail_content text         null comment '失败内容',
//    remark       text         null comment '其他备注'

    private Integer id;
    private String serviceName;
    private String taskName;
    private String moduleName;
    private String startTime;
    private String endTime;
    private String state;
    private String failContent;
    private String remark;

}
