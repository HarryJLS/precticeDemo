package com.jlstest.model;

import lombok.Data;

/**
 * @author JLS
 * @description:
 * @since 2024-01-11 20:00
 */
@Data
public class PageReq implements java.io.Serializable{
    public static final long serialVersionUID = 1L;

    /**
     * 页码
     */
    private Integer pageNum;

    /**
     * 每页条数
     */
    private Integer pageSize;

    /**
     * 分页大小
     */
    private Integer size;

    /**
     * 排序字段
     */
    private String orders;

    /**
     * 当前查询页
     */
    private Integer current;
}
