package com.jlstest.model;

import lombok.Data;

/**
 * @author JLS
 * @description:
 * @since 2024-01-11 19:44
 */
@Data
public class RruEntity implements java.io.Serializable{
    public static final long serialVersionUID = 1L;

//    related_masteroperator_gnb_dn 所属承建方gNodeBDN值 String 所属承建方gNodeBDN值
//    related_masteroperator_gnb_id 所属承建方gNodeBID String 所属承建方gNodeBID
//    elated_masteroperator_gnb_userlabel 所属承建方gNodeB名称 String 所属承建方gNodeB名称
//    rru_vendor_location RRU的厂家定位信息 String RRU的厂家定位信息
//    userlabel RRU名称 String RRU名称
//    freq_mode 无线制式 Integer 无线制式
//    rru_model RRU型号 String RRU型号
//    cel_dn_list RRU关联到小区DU的DN值列表 String RRU关联到小区DU的DN值列表
//    cel_id_list RRU关联到小区DU的ID列表 String RRU关联到小区DU的ID列表
//    serialid RRU电子序列号 String RRU电子序列号
//    maxactpower_rru RRU实际最大发射功率 String RRU实际最大发射功率
//    rru_type RRU类型 Integer RRU类型
//    related_phub_dn 所属PHUBDN值 String 所属PHUBDN值
//    related_phub_id 所属PHUBID String 所属PHUBID
//    related_phub_userlabel 所属PHUB名称 String 所属PHUB名称
//    rru_longitude RRU经度 Double RRU经度
//    rru_latitude RRU纬度 Double RRU纬度
//    rru_id RRUID String RRUID
//    support_frequency_band 支持频段 String 支持频段
//    bandwidth_set 设置带宽 String 设置带宽
//    upline_slot_configuration 上行时隙配置比 String 上行时隙配置比
//    rb_reserve_bandwidth RB预留带宽 String RB预留带宽
//    province_name 省 String 省
//    city_name 市 String 市
//    county_name 区 String 区

    /**
     * 所属承建方gNodeBDN值
     */
    private String related_masteroperator_gnb_dn;

    /**
     * 所属承建方gNodeBID
     */
    private String related_masteroperator_gnb_id;

    /**
     * 所属承建方gNodeB名称
     */
    private String elated_masteroperator_gnb_userlabel;

    /**
     * RRU的厂家定位信息
     */
    private String rru_vendor_location;

    /**
     * RRU名称
     */
    private String userlabel;

    /**
     * 无线制式
     */
    private Integer freq_mode;

    /**
     * RRU型号
     */
    private String rru_model;

    /**
     * RRU关联到小区DU的DN值列表
     */
    private String cel_dn_list;

    /**
     * RRU关联到小区DU的ID列表
     */
    private String cel_id_list;

    /**
     * RRU电子序列号
     */
    private String serialid;

    /**
     * RRU实际最大发射功率
     */
    private String maxactpower_rru;

    /**
     * RRU类型
     */
    private Integer rru_type;

    /**
     * 所属PHUBDN值
     */
    private String related_phub_dn;

    /**
     * 所属PHUBID
     */
    private String related_phub_id;

    /**
     * 所属PHUB名称
     */
    private String related_phub_userlabel;

    /**
     * RRU经度
     */
    private Double rru_longitude;

    /**
     * RRU纬度
     */
    private Double rru_latitude;

    /**
     * RRUID
     */
    private String rru_id;

    /**
     * 支持频段
     */
    private String support_frequency_band;

    /**
     * 设置带宽
     */
    private String bandwidth_set;

    /**
     * 上行时隙配置比
     */
    private String upline_slot_configuration;

    /**
     * RB预留带宽
     */
    private String rb_reserve_bandwidth;

    /**
     * 省
     */
    private String province_name;

    /**
     * 市
     */
    private String city_name;

    /**
     * 区
     */
    private String county_name;
}
