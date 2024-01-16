package com.jlstest.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author JLS
 * @description:
 * @since 2024-01-11 19:18
 */
@Data
public class WirelessNetworkEntity implements Serializable {
    public static final long serialVersionUID = 1L;

//    province_code 省份 String 省份
//    gnb_id 基站id String 基站id
//    userlabel 基站名称 String 基站名称
//    gnb_model 设备型号 String 设备型号
//    gnb_id_length gNodeB 标识长度 String gNodeB 标识长度
//    software_version gNodeB 软件版本 String gNodeB 软件版本
//    freq_mode 无线制式 String 无线制式
//    cel_num 小区数量 String 小区数量
//    serial_id 基站的电子序列号 String 基站的电子序列号
//    clock_source 时钟源 String 时钟源
//    synchronous_mode 同步方式 Integer 同步方式
//    bbu_longitude 基站经度 BigDecimal 基站经度
//    bbu_latitude 基站纬度 BigDecimal 基站纬度
//    gnb_type 基站类型 String 基站类型
//    gnb_deployment_mode 基站部署方式 String 基站部署方式
//            masteroperator_plmn 承建方基站归属的PLMN String 承建方基站归属的 PLMN
//    physical_userlabel 物理网元别称 String 物理网元别称
//    share_type 共享类型 Integer 1：边缘独享 2：共享 3：边缘共享
//    province_name 省份名称 String 省份
//    city_code 城市编码 String 城市编码
//    city_name 城市名称 String 城市名称
//    county_code 区县编码 String 区县编码
//    county_name 区县名称 String 区县名称
//    update_time 更新时间 LocalDateTime 更新时间
//    is_sfsys_cell 是否含有室分DU String 0: 否,1:是
//    gnb_ip 基站管理ip String 基站管理ip
//    last_sub_time 基站最后订阅时间 LocalDateTime 基站最后订阅时间
//            machine_room_location 机房位置 String 机房位置
//    cuList CU小区列表 List CU小区列表
//    duList DU小区列表 List DU小区列表
//    rruList RRU列表 List RRU列表

    /**
     * 省份
     */
    private String province_code;

    /**
     * 基站id
     */
    private String gnb_id;

    /**
     * 基站名称
     */
    private String userlabel;

    /**
     * 设备型号
     */
    private String gnb_model;

    /**
     * gNodeB 标识长度
     */
    private String gnb_id_length;

    /**
     * gNodeB 软件版本
     */
    private String software_version;

    /**
     * 无线制式
     */
    private String freq_mode;

    /**
     * 小区数量
     */
    private String cel_num;

    /**
     * 基站的电子序列号
     */
    private String serial_id;

    /**
     * 时钟源
     */
    private String clock_source;

    /**
     * 同步方式
     */
    private Integer synchronous_mode;

    /**
     * 基站经度
     */
    private String bbu_longitude;

    /**
     * 基站纬度
     */
    private String bbu_latitude;

    /**
     * 基站类型
     */
    private String gnb_type;

    /**
     * 基站部署方式
     */
    private String gnb_deployment_mode;

    /**
     * 承建方基站归属的PLMN
     */
    private String masteroperator_plmn;

    /**
     * 物理网元别称
     */
    private String physical_userlabel;

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
     * 更新时间
     */
    private String update_time;

    /**
     * 是否含有室分DU
     */
    private String is_sfsys_cell;

    /**
     * 基站管理ip
     */
    private String gnb_ip;

    /**
     * 基站最后订阅时间
     */
    private String last_sub_time;

    /**
     * 机房位置
     */
    private String machine_room_location;

    /**
     * CU小区列表
     */
    private String cuList;

    /**
     * DU小区列表
     */
    private String duList;

    /**
     * RRU列表
     */
    private String rruList;
}
