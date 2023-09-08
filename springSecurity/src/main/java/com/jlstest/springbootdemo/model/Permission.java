package com.jlstest.springbootdemo.model;

import java.io.Serializable;

import lombok.Data;

/**
 * @author JLS
 * @description: 账户权限实体类
 * @since 2023-06-28 14:46
 */
@Data
public class Permission implements Serializable {
    public static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 父权限
     */
    private Long parentId;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限英文名称
     */
    private String enname;

    /**
     * 授权路径
     */
    private String url;

    /**
     * 备注
     */
    private String description;

}
