package com.jlstest.model;

import lombok.Data;

/**
 * @author JLS
 * @description:
 * @since 2024-01-11 20:03
 */
@Data
public class CoreNetworkFunctionRecord implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

//    neId 网元ID String 网元ID
//    neName 网元名称 String 网元名称
//    neType 网元类型 String 网元类型
//    shareType 共享类型 String 1：边缘独享 2：共享 3：边缘共享
//    fqdn fqdn String fqdn
//    hardMaxWidth 硬件最大带宽 String 硬件最大带宽
//    cityName 城市 String 城市
//    machineRoomName 物理机房名称 String 物理机房名称
//    openTime 网元开通时间 LocalDateTime 网元开通时间
//    neModel 设备型号 String 设备型号
//    neStatus 设备状态 String 设备状态
//    forwardAbility 转发能力 String 转发能力
//    n6Bandwidth n6口带宽 String n6口带宽
//    provinceName 省份 String 省份
//    countyName 区县 String 区县
//    machineRoomLocation 机房位置 String 机房位置
//    n3IPAddress n3IP地址 String n3IP地址
//    n4IPAddress n4IP地址 String n4IP地址
//    neAbility 设备能力 String 设备能力

    /**
     * 网元ID
     */
    private String neId;

    /**
     * 网元名称
     */
    private String neName;

    /**
     * 网元类型
     */
    private String neType;

    /**
     * 共享类型 1：边缘独享 2：共享 3：边缘共享
     */
    private String shareType;

    /**
     * fqdn
     */
    private String fqdn;

    /**
     * 硬件最大带宽
     */
    private String hardMaxWidth;

    /**
     * 城市
     */
    private String cityName;

    /**
     * 物理机房名称
     */
    private String machineRoomName;

    /**
     * 网元开通时间
     */
    private java.time.LocalDateTime openTime;

    /**
     * 设备型号
     */
    private String neModel;

    /**
     * 设备状态
     */
    private String neStatus;

    /**
     * 转发能力
     */
    private String forwardAbility;

    /**
     * n6口带宽
     */
    private String n6Bandwidth;

    /**
     * 省份
     */
    private String provinceName;

    /**
     * 区县
     */
    private String countyName;

    /**
     * 机房位置
     */
    private String machineRoomLocation;

    /**
     * n3IP地址
     */
    private String n3IPAddress;

    /**
     * n4IP地址
     */
    private String n4IPAddress;

    /**
     * 设备能力
     */
    private String neAbility;
}
