package com.jlstest.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author JLS
 * @description:
 * @since 2024-01-11 19:25
 */
@Data
public class CuEntity implements Serializable {
    public static final long serialVersionUID = 1L;

//    province_code 省份 Integer 省份
//    master_phy_cell_id 物理小区的 ID String 物理小区的 ID
//    related_gnb_dn 所属物理基站 gNodeBDN 值
//    String 所属物理基站 gNodeBDN 值
//    related_gnb_id 所属物理基站 gNodeB ID String 所属物理基站 gNodeBID
//    related_gnb_userlabel 所属gNodeB名称 String 所属gNodeB名称
//    cel_id 小区 ID String 小区 ID
//    celcu_id_local 厂家小区 CU 内部 ID String 厂家小区 CU 内部 ID
//    celcu_id_local 小区CU名称 String 小区CU名称
//    share_type 共享类型 String 共享类型
//    province_name 省份名称 String 省份名称
//    city_code 城市编码 Integer 城市编码
//    city_name 城市名称 String 城市名称
//    county_code 区县编码 Integer 区县编码
//    county_name 区县名称 String 区县名称
//    longitude 经度 String 经度
//    latitude 维度 String 维度
//    update_time 更新时间 LocalDateTime 更新时间
//    celType 设备类型 String 设备类型

    /**
     * 省份
     */
    private String province_code;

    /**
     * 物理小区的 ID
     */
    private String master_phy_cell_id;

    /**
     * 所属物理基站 gNodeBDN 值
     */
    private String related_gnb_dn;

    /**
     * 所属物理基站 gNodeB ID
     */
    private String related_gnb_id;

    /**
     * 所属gNodeB名称
     */
    private String related_gnb_userlabel;

    /**
     * 小区 ID
     */
    private String cel_id;

    /**
     * 厂家小区 CU 内部 ID
     */
    private String celcu_id_local;

    /**
     * 小区CU名称
     */
    private String celcu_userlabel;

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
    private String longitude;

    /**
     * 维度
     */
    private String latitude;

    /**
     * 更新时间
     */
    private LocalDateTime update_time;

    /**
     * 设备类型
     */
    private String celType;

}
