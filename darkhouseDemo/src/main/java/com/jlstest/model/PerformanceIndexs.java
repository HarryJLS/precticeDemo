package com.jlstest.model;

import lombok.Data;

/**
 * @author JLS
 * @description:
 * @since 2024-01-11 20:10
 */
@Data
public class PerformanceIndexs implements java.io.Serializable{
    public static final long serialVersionUID = 1L;

    /**
     * indexCode
     */
    private String indexCode;

    /**
     * sliceId
     */
    private String sliceId;

    /**
     * dnn名称
     */
    private String dnnName;
}
