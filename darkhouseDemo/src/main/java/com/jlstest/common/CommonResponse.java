package com.jlstest.common;

import java.io.Serializable;
import java.util.Objects;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author JLS
 * @description:
 * @since 2023-06-20 10:29
 */
public class CommonResponse<T> implements Serializable {
    public static final long serialVersionUID = 1L;

    /**
     * 数据
     */
    public T data;

    /**
     * 状态码
     */
    public Integer resultCode;

    /**
     * 返回的消息
     */
    public String message;

    /**
     * 是否成功
     */
    public Boolean success;

    /**
     * 是否调用成功
     *
     * @return
     */
    @JSONField(serialize = false, deserialize = false)
    public boolean isSuccess() {
        return Objects.equals(ResultCode.SUCCESS.getCode(), this.resultCode);
    }

    public CommonResponse(IResultCode resultCode, T data) {
        this.resultCode = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
        this.success = isSuccess();
    }

    public CommonResponse(IResultCode resultCode) {
        this.resultCode = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.success = isSuccess();
    }

    public CommonResponse(IResultCode resultCode, String message) {
        this.resultCode = resultCode.getCode();
        this.message = message;
        this.success = isSuccess();
    }

    public static <T> CommonResponse<T> sendSuccess() {
        return new CommonResponse<>(ResultCode.SUCCESS);
    }

    public static <T> CommonResponse<T> sendSuccessData(T data) {
        return new CommonResponse<>(ResultCode.SUCCESS, data);
    }

    public static <T> CommonResponse<T> sendSuccess(String message) {
        return new CommonResponse<>(ResultCode.SUCCESS, message);
    }

    public static <T> CommonResponse<T> sendFailure() {
        return new CommonResponse<>(ResultCode.FAILED);
    }

    public static <T> CommonResponse<T> sendFailure(String message) {
        return new CommonResponse<>(ResultCode.FAILED, message);
    }

    public static <T> CommonResponse<T> sendFailure(T data) {
        return new CommonResponse<>(ResultCode.FAILED, data);
    }

    public static <T> CommonResponse<T> sendFailure(IResultCode resultCode) {
        return new CommonResponse<>(resultCode);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }


}
