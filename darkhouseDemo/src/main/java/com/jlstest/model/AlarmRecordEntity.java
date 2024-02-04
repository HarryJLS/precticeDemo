package com.jlstest.model;

import lombok.Data;

/**
 * @author JLS
 * @description:
 * @since 2024-01-11 20:19
 */
@Data
public class AlarmRecordEntity implements java.io.Serializable{
    public static final long serialVersionUID = 1L;

//    alarmId 告警ID string 告警ID
//    alarmTitle 告警标题 string 告警标题
//    alarmLevel 告警级别 int 1/2/3/4 分别表示一/二/三/四级告警
//    alarm_ne_id 告警网元ID string 告警网元ID
//    alarm_ne_type 告警网元类型 string HX 核心网告警 WX 无线网告警
//    alarm_time 告警发生时间 string 告警发生时间
//    cleanTime 告警清除时间 string 告警清除时间
//    alarmStatus 告警状态 string 0 已清除告警 1 活动告警

    /**
     * 告警ID
     */
    private String alarmId;

    /**
     * 告警标题
     */
    private String alarmTitle;

    /**
     * 告警级别 1/2/3/4 分别表示一/二/三/四级告警
     */
    private Integer alarmLevel;

    /**
     * 告警网元ID
     */
    private String alarmNeId;

    /**
     * 告警网元类型 HX 核心网告警 WX 无线网告警
     */
    private String alarmNeType;

    /**
     * 告警发生时间
     */
    private String alarmTime;

    /**
     * 告警清除时间
     */
    private String cleanTime;

    /**
     * 告警状态 0 已清除告警 1 活动告警
     */
    private String alarmStatus;
}
