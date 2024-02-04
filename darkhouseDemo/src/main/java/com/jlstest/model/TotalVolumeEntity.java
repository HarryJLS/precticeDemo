package com.jlstest.model;

import lombok.Data;

/**
 * @author JLS
 * @description:
 * @since 2024-01-11 20:44
 */
@Data
public class TotalVolumeEntity implements java.io.Serializable {
    public static final long serialVersionUID = 1L;

//    timeMark String 时间戳 时间戳
//    uplinkVolume String 上行累计流量 上行累计流量
//    downlinkVolume String 下行累计流量 下行累计流量


    /**
     * 时间戳
     */
    private String timeMark;

    /**
     * 上行累计流量
     */
    private String uplinkVolume;

    /**
     * 下行累计流量
     */
    private String downlinkVolume;
}
