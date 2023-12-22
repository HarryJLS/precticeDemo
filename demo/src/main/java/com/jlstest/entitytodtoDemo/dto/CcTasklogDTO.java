package com.jlstest.entitytodtoDemo.dto;

/**
 * @author JLS
 * @description:
 * @since 2023-11-17 17:06
 */
public class CcTasklogDTO implements java.io.Serializable{
    public static final long serialVersionUID = 1L;

    private Integer id;
    private String serviceName;
    private String taskName;
    private String moduleName;
    private String startTime;
    private String endTime;
    private String state;
    private String failContent;
    private String remark;
}
