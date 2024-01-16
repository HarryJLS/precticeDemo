package com.jlstest.model;

import lombok.Data;

import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2024-01-11 20:35
 */
@Data
public class PageOnlineInfoEntity implements java.io.Serializable{
    public static final long serialVersionUID = 1L;

//    total 成员总数 Int
//    current 当前页 Int
//    pages 页数 Int
//    records 成员记录 List
//    iccid ICCID String
//    msisdn 接入号 String
//    imsi IMSI String
//    totalOnlineTime 在线时长 String
//    statusCd SIM卡状态 String
//    statusOnline 网络在线状态 String
//    initTimes 上线次数 String
//    terminatedTimes 下行次数 String
//    updateTime 状态变更时间 String

    /**
     * 成员总数
     */
    private Integer total;

    /**
     * 当前页
     */
    private Integer current;

    /**
     * 页数
     */
    private Integer pages;

    /**
     * 成员记录
     */
    private List<String> records;

    /**
     * ICCID
     */
    private String iccid;

    /**
     * 接入号
     */
    private String msisdn;

    /**
     * IMSI
     */
    private String imsi;

    /**
     * 在线时长
     */
    private String totalOnlineTime;

    /**
     * SIM卡状态
     */
    private String statusCd;

    /**
     * 网络在线状态
     */
    private String statusOnline;

    /**
     * 上线次数
     */
    private String initTimes;

    /**
     * 下行次数
     */
    private String terminatedTimes;

    /**
     * 状态变更时间
     */
    private String updateTime;
}
