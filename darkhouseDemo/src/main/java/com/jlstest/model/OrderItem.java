package com.jlstest.model;

import lombok.Data;

/**
 * @author JLS
 * @description:
 * @since 2024-01-11 20:01
 */
@Data
public class OrderItem implements java.io.Serializable{
    public static final long serialVersionUID = 1L;

    /**
     * 排序字段
     */
    private String column;

    /**
     * 是否升序
     */
    private Boolean asc;
}
