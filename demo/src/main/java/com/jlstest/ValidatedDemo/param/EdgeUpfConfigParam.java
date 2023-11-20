package com.jlstest.ValidatedDemo.param;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.jlstest.ValidatedDemo.aop.RangeString;

import lombok.Data;

/**
 * @author JLS
 * @description: 边缘UPF配置入参实体类
 * @since 2023-10-31 15:49
 */
@Data
public class EdgeUpfConfigParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "DNN名称不能为空")
    private String dnnName;

    @NotBlank(message = "Vlanid不能为空")
    private String vlanid;

    @NotNull(message = "域名不能为空")
    private List<String> domainList;

    private String dnnAbbr;

    @NotBlank(message = "网元名称不能为空")
    private String deviceName;

    @RangeString(allows = { "1", "2", "3" }, message = "地址池组仅支持，1,2,3")
    private String addressGroup;

}
