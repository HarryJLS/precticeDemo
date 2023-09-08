package com.jlstest.springbootdemo.common.response;

import java.io.Serializable;

/**
 * @className: IResultCode
 * @Description: TODO
 * @author: JLS
 * @date: 2023/6/20 10:31
 */
public interface IResultCode extends Serializable {
    public static final long serialVersionUID = 1L;

    /**
     * 获取消息
     */
    String getMessage();

    /**
     * 获取状态码
     */
    Integer getCode();
}
