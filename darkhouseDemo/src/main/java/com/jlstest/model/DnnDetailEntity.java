package com.jlstest.model;

import lombok.Data;

/**
 * @author JLS
 * @description:
 * @since 2024-01-11 20:33
 */
@Data
public class DnnDetailEntity implements java.io.Serializable{
    public static final long serialVersionUID = 1L;

//    addressPoolShartype 地址池分配方式 String
//    dnnName DNN名称 String
//    ipv4dns ipv4主DNS String
//    ipv4dnsbk ipv4备用DNS String
//    ipv6dns ipv6主DNS String
//    ipv6dnsbk ipv6备用DNS String
//    netType 网络类型 String
//    parPlatform 平台归属省份名 String
//    parPlatformCode parPlatformCode String
//    platform 平台归属园区名 String
//    platformCode 平台归属园区编码
//    qos 服务质量
//    sliceId 切片ID
//    sliceName 切片名称
//    ueRecipVis 终端互访(开启/关闭)

    /**
     * 地址池分配方式
     */
    private String addressPoolShartype;

    /**
     * DNN名称
     */
    private String dnnName;

    /**
     * ipv4主DNS
     */
    private String ipv4dns;

    /**
     * ipv4备用DNS
     */
    private String ipv4dnsbk;

    /**
     * ipv6主DNS
     */
    private String ipv6dns;

    /**
     * ipv6备用DNS
     */
    private String ipv6dnsbk;

    /**
     * 网络类型
     */
    private String netType;

    /**
     * 平台归属省份名
     */
    private String parPlatform;

    /**
     * parPlatformCode
     */
    private String parPlatformCode;

    /**
     * 平台归属园区名
     */
    private String platform;

    /**
     * 平台归属园区编码
     */
    private String platformCode;

    /**
     * 服务质量
     */
    private String qos;

    /**
     * 切片ID
     */
    private String sliceId;

    /**
     * 切片名称
     */
    private String sliceName;

    /**
     * 终端互访(开启/关闭)
     */
    private String ueRecipVis;
}
