package com.jlstest.model;

import lombok.Data;

/**
 * @author JLS
 * @description:
 * @since 2024-01-11 20:39
 */
@Data
public class MaxSpeedEntity implements java.io.Serializable{
    public static final long serialVersionUID = 1L;

//    timeMark String 时间戳 时间戳
//    upSpeed String 上行最大速率 上行最大速率
//    downSpeed String 下行最大速率 下行最大速率

    /**
     * 时间戳
     */
    private String timeMark;

    /**
     * 上行最大速率
     */
    private String upSpeed;

    /**
     * 下行最大速率
     */
    private String downSpeed;
}
