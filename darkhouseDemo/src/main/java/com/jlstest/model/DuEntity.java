package com.jlstest.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author JLS
 * @description:
 * @since 2024-01-11 19:33
 */
@Data
public class DuEntity implements Serializable {
    public static final long serialVersionUID = 1L;

//    province_code 省份 Integer 省份
//    master_phy_cell_id 所属承建方gNodeBID String 所属承建方gNodeBID
//    related_masteroperator_gnb_id 所属承建方gNodeBID String 所属承建方gNodeBID
//    related_masteroperator_gnb_userlabel 所属承建方gNodeB名称 String 所属承建方gNodeB名称
//    userlabel 小区DU(物理)名称 String 小区DU(物理)名称
//    celdu_id_local 厂家小区DU内部ID String 厂家小区DU内部ID
//    pci 物理小区标识 String 物理小区标识
//    freq_ul 上行中心频率(MHz) String 上行中心频率(MHz)
//    freq_dl 下行中心频率(MHz) String 下行中心频率(MHz)
//    freq_pointno_ul 上行中心频点号 String 上行中心频点号
//    freq_pointno_dl 下行中心频点号 String 下行中心频点号
//    bandwidth_ul 上行带宽(MHz) String 上行带宽(MHz)
//    bandwidth_dl 下行带宽(MHz) String 下行带宽(MHz)
//    tdd_first_transmissionperiodicity 帧结构第一个周期的时间 String 帧结构第一个周期的时间
//    tdd_first_transmissionperiodicity_type 帧结构第一个周期的帧类型 String 帧结构第一个周期的帧类型
//    tdd_first_nrofdownlinksymbols 帧结构第一个周期Sslot上的下行符号数 String 帧结构第一个周期Sslot上的下行符号数
//    tdd_first_nrofuplinksymbols 第一个周期Sslot上的上行符号数 String 第一个周期Sslot上的上行符号数
//    s_slot_gpsymbols 帧结构Sslot上GP符号个数 String 帧结构Sslot上GP符号个数
//    tdd_second_id 指示帧结构第二个周期帧类型是否配置 String 指示帧结构第二个周期帧类型是否配置
//    tdd_second_transmissionperiodicity_city 帧结构第二个周期的时间 String 帧结构第二个周期的时间
//    tdd_second_transmissionperiodicity_type 帧结构第二个周期的帧类型 String 帧结构第二个周期的帧类型
//    tdd_second_nrofdownlinksymbols 帧结构第二个周期Sslot上的下行符号数 String 帧结构第二个周期Sslot上的下行符号数
//    tdd_second_nrofuplinksymbols 帧结构第二个周期Sslot上的上行符号数 String 帧结构第二个周期Sslot上的上行符号数
//    share_type 共享类型 Integer 共享类型
//    province_name 省份名称 String 省份名称
//    city_code 城市编码 Integer 城市编码
//    city_name 城市名称 String 城市名称
//    county_code 区县编码 Integer 区县编码
//    county_name 区县名称 String 区县名称
//    longitude 经度 BigDecimal 经度
//    latitude 维度 BigDecimal 维度
//    update_time 更新时间 LocalDateTime 更新时间
//    celType 设备类型 String 设备类型
//    isSfsysCell 是否室分DU Integer 0: 否,1:是
//    is_query_du 是否已查询室分 Integer 0:否,1:是

    /**
     * 省份
     */
    private String province_code;

    /**
     * 所属承建方gNodeBID
     */
    private String master_phy_cell_id;

    /**
     * 所属承建方gNodeBID
     */
    private String related_masteroperator_gnb_id;

    /**
     * 所属承建方gNodeB名称
     */
    private String related_masteroperator_gnb_userlabel;

    /**
     * 小区DU(物理)名称
     */
    private String userlabel;

    /**
     * 厂家小区DU内部ID
     */
    private String celdu_id_local;

    /**
     * 物理小区标识
     */
    private String pci;

    /**
     * 上行中心频率(MHz)
     */
    private String freq_ul;

    /**
     * 下行中心频率(MHz)
     */
    private String freq_dl;

    /**
     * 上行中心频点号
     */
    private String freq_pointno_ul;

    /**
     * 下行中心频点号
     */
    private String freq_pointno_dl;

    /**
     * 上行带宽(MHz)
     */
    private String bandwidth_ul;

    /**
     * 下行带宽(MHz)
     */
    private String bandwidth_dl;

    /**
     * 帧结构第一个周期的时间
     */
    private String tdd_first_transmissionperiodicity;

    /**
     * 帧结构第一个周期的帧类型
     */
    private String tdd_first_transmissionperiodicity_type;

    /**
     * 帧结构第一个周期Sslot上的下行符号数
     */
    private String tdd_first_nrofdownlinksymbols;

    /**
     * 第一个周期Sslot上的上行符号数
     */
    private String tdd_first_nrofuplinksymbols;

    /**
     * 帧结构Sslot上GP符号个数
     */
    private String s_slot_gpsymbols;

    /**
     * 指示帧结构第二个周期帧类型是否配置
     */
    private String tdd_second_id;

    /**
     * 帧结构第二个周期的时间
     */
    private String tdd_second_transmissionperiodicity_city;

    /**
     * 帧结构第二个周期的帧类型
     */
    private String tdd_second_transmissionperiodicity_type;

    /**
     * 帧结构第二个周期Sslot上的下行符号数
     */
    private String tdd_second_nrofdownlinksymbols;

    /**
     * 帧结构第二个周期Sslot上的上行符号数
     */
    private String tdd_second_nrofuplinksymbols;

    /**
     * 共享类型
     */
    private Integer share_type;

    /**
     * 省份名称
     */
    private String province_name;

    /**
     * 城市编码
     */
    private String city_code;

    /**
     * 城市名称
     */
    private String city_name;

    /**
     * 区县编码
     */
    private String county_code;

    /**
     * 区县名称
     */
    private String county_name;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 维度
     */
    private BigDecimal latitude;

    /**
     * 更新时间
     */
    private LocalDateTime update_time;

    /**
     * 设备类型
     */
    private String celType;

    /**
     * 是否室分DU 0: 否,1:是
     */
    private Integer isSfsysCell;

    /**
     * 是否已查询室分 0:否,1:是
     */
    private Integer is_query_du;
}
