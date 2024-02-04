package com.jlstest.common;

/**
 * @author JLS
 * @description: 返回码枚举
 * @since 2023-06-20 10:33
 */
public enum ResultCode implements IResultCode {

    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功"),

    /**
     * 操作失败
     */
    FAILED(500, "操作失败"),

    /**
     * 参数校验失败
     */
    VALIDATE_FAILED(404, "参数检验失败"),

    /**
     * 暂未登录或token已经过期
     */
    UNAUTHORIZED(401, "暂未登录或token已经过期"),

    /**
     * 没有相关权限
     */
    FORBIDDEN(403, "没有相关权限");

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态信息
     */
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获取消息
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * 获取状态码
     */
    @Override
    public Integer getCode() {
        return code;
    }

}
