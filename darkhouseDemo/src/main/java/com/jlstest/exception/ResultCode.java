package com.jlstest.exception;

/**
 * @className: ResultCode
 * @Description: 错误码接口
 * @author: JLS
 * @date: 2022/11/9 14:59
 */
public interface ResultCode {

    /**
     * 获取code
     */
    String getCode();

    /**
     * 获取错误信息
     */
    String getMsg();
}
