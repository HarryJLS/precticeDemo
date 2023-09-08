package com.jlstest.springbootdemo.common.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author JLS
 * @description:
 * @since 2023-06-20 10:29
 */
public class JlsTestResponse<T> implements Serializable {
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
    @JsonIgnore
    @JSONField(serialize = false, deserialize = false)
    public boolean isSuccess() {
        return Objects.equals(ResultCode.SUCCESS.getCode(), this.resultCode);
    }

    public JlsTestResponse(IResultCode resultCode, T data) {
        this.resultCode = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
        this.success = isSuccess();
    }

    public JlsTestResponse(IResultCode resultCode) {
        this.resultCode = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.success = isSuccess();
    }

    public JlsTestResponse(IResultCode resultCode, String message) {
        this.resultCode = resultCode.getCode();
        this.message = message;
        this.success = isSuccess();
    }

    public static <T> JlsTestResponse<T> sendSuccess() {
        return new JlsTestResponse<>(ResultCode.SUCCESS);
    }

    public static <T> JlsTestResponse<T> sendSuccessData(T data) {
        return new JlsTestResponse<>(ResultCode.SUCCESS, data);
    }

    public static <T> JlsTestResponse<T> sendSuccess(String message) {
        return new JlsTestResponse<>(ResultCode.SUCCESS, message);
    }

    public static <T> JlsTestResponse<T> sendFailure() {
        return new JlsTestResponse<>(ResultCode.FAILED);
    }

    public static <T> JlsTestResponse<T> sendFailure(String message) {
        return new JlsTestResponse<>(ResultCode.FAILED, message);
    }

    public static <T> JlsTestResponse<T> sendFailure(T data) {
        return new JlsTestResponse<>(ResultCode.FAILED, data);
    }

    public static <T> JlsTestResponse<T> sendFailure(IResultCode resultCode) {
        return new JlsTestResponse<>(resultCode);
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
