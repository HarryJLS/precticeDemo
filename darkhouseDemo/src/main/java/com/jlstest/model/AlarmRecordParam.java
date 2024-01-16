package com.jlstest.model;

/**
 * @author JLS
 * @description:
 * @since 2024-01-11 20:14
 */
public class AlarmRecordParam implements java.io.Serializable{
    public static final long serialVersionUID = 1L;

//    neId 网元ID String Body True 网元ID
//    nfType 网元类型 String Body True AMF/SMF/UPF/GNB
//    startTime 开始时间 String Body True 示例：2021-07-31 19:51:38
//    endTime 结束时间 String Body true 示例：2021-07-31 19:51:38
//    alarmLevel 告警级别 Int Body False 1/2/3/4，代表一/二/三/四级告警
//    PageReq 分页参数 / Body True 分页参数
//    PageReq.size 分页大小 Int Body True 分页大小
//    PageReq.current
//    当前查询页 Int Body True 当前查询页
//    PageReq.orders
//    需要排序的字段可以为空
//    OrderItem[]
//    Body False 需要排序的字段，可以为空
//    orders.column 排序字段名称 String Body False 排序字段名称
//    orders.asc 是否升序 Bool Body False 是否升序，true升序，false降序

    /**
     * 网元ID
     */
    private String neId;

    /**
     * 网元类型
     */
    private String nfType;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 告警级别
     */
    private Integer alarmLevel;

    /**
     * 分页参数
     */
    private PageReq PageReq;

    /**
     * 排序参数
     */
    private OrderItem OrderItem;
}
