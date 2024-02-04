package com.jlstest.model;

import lombok.Data;

/**
 * @author JLS
 * @description:
 * @since 2024-01-11 20:12
 */
@Data
public class QueryNePerformanceIndexEntity implements java.io.Serializable{
    public static final long serialVersionUID = 1L;

//    indexName String 指标中文名称
//    indexCode String 性能指标编码
//    indexValue String 性能指标值
//    unit String 性能指标单位
//    datetime String 性能指标统计时间

    /**
     * 指标中文名称
     */
    private String indexName;

    /**
     * 性能指标编码
     */
    private String indexCode;

    /**
     * 性能指标值
     */
    private String indexValue;

    /**
     * 性能指标单位
     */
    private String unit;

    /**
     * 性能指标统计时间
     */
    private String datetime;
}
