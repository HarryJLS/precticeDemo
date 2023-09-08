package com.jlstest.springbootdemo.common.response;

/**
 * @author JLS
 * @description: 控制层基类
 * @since 2023-06-20 11:13
 */
public class BaseController {

    /**
     * 发送成功消息（带数据）
     *
     * @param <T>
     *            the type parameter
     * @param data
     *            返回数据
     * @return 架构组规定JackYunResponse结构体
     */
    public static <T> JlsTestResponse<T> sendSuccessData(T data) {
        return JlsTestResponse.sendSuccessData(data);
    }

    /**
     * 发送成功消息（不带数据）
     *
     * @param <T>
     *            the type parameter
     * @return 架构组规定JackYunResponse结构体
     */
    public static <T> JlsTestResponse<T> sendSuccess() {
        return JlsTestResponse.sendSuccess();
    }

    public static <T> JlsTestResponse<T> sendSuccessMsg(String message) {
        return JlsTestResponse.sendSuccess(message);
    }

    /**
     * 发送错误消息
     *
     * @param <T>
     *            the type parameter
     * @return 架构组规定JackYunResponse结构体
     */
    public static <T> JlsTestResponse<T> sendFailure() {
        return JlsTestResponse.sendFailure();
    }

    public static <T> JlsTestResponse<T> sendFailureMsg(String message) {
        return JlsTestResponse.sendFailure(message);
    }

    public static <T> JlsTestResponse<T> sendFailureData(T data) {
        return JlsTestResponse.sendFailure(data);
    }

    public static <T> JlsTestResponse<T> sendFailure(IResultCode resultCode) {
        return JlsTestResponse.sendFailure(resultCode);
    }
}
