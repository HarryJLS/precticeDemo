package com.jlstest.model;

import lombok.Data;

import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2024-01-11 20:02
 */
@Data
public class CoreNetworkFunctionEntity implements java.io.Serializable{
    public static final long serialVersionUID = 1L;

//    total 结果总数 Int 结果总数
//    size 分页大小 Int 分页大小
//    current 当前查询页 Int 当前查询页
//    searchCount 是否检索总数 Bool 是否检索结果总数
//    pages 页总数 Int 页总数
//    records 查询记录 List 查询记录
//    orders 需要排序的字段 OrderItem[] 需要排序的字段

    /**
     * 结果总数
     */
    private Integer total;

    /**
     * 分页大小
     */
    private Integer size;

    /**
     * 当前查询页
     */
    private Integer current;

    /**
     * 是否检索总数
     */
    private Boolean searchCount;

    /**
     * 页总数
     */
    private Integer pages;

    /**
     * 查询记录
     */
    private List<CoreNetworkFunctionRecord> records;

    /**
     * 需要排序的字段
     */
    private OrderItem[] orders;
}
