package com.jlstest.springbootdemo.common.exception;

import com.jlstest.springbootdemo.common.enums.ResultCode;

import java.util.Map;


/**
 * @author JLS
 * @description: 异常类型封装
 * @since 2022-11-09 14:54
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private ResultCode resultCode;
    private Map<String, Object> errorData;

    private String subCode;

    private String msg;

    /**
     * Instantiates a new Service exception.
     *
     * @param subCode
     *            the sub code
     * @param msg
     *            the msg
     */
    public ServiceException(String subCode, String msg) {
        super(msg);
        this.subCode = subCode;
        this.msg = msg;
    }

    public ServiceException(String msg) {
        super(msg);
        this.msg = msg;
    }

    /**
     * Instantiates a new Service exception.
     *
     * @param resultCode
     *            the result code
     */
    public ServiceException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.resultCode = resultCode;
        this.subCode = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    /**
     * Instantiates a new Service exception.
     *
     * @param resultCode
     *            the result code
     * @param errorData
     *            the error data
     */
    public ServiceException(ResultCode resultCode, Map<String, Object> errorData) {
        super(resultCode.getMsg());
        this.resultCode = resultCode;
        this.subCode = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.errorData = errorData;
    }

    /**
     * Instantiates a new Service exception.
     *
     * @param subCode
     *            the sub code
     * @param msg
     *            the msg
     * @param errorData
     *            the errorData
     */
    public ServiceException(String subCode, String msg, Map<String, Object> errorData) {
        super(msg);
        this.subCode = subCode;
        this.msg = msg;
        this.errorData = errorData;
    }

    /**
     * Gets result code.
     *
     * @return the result code
     */
    public ResultCode getResultCode() {
        return resultCode;
    }

    /**
     * Sets result code.
     *
     * @param resultCode
     *            the result code
     */
    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * Gets error data.
     *
     * @return the error data
     */
    public Map<String, Object> getErrorData() {
        return errorData;
    }

    /**
     * Sets error data.
     *
     * @param errorData
     *            the error data
     */
    public void setErrorData(Map<String, Object> errorData) {
        this.errorData = errorData;
    }

    /**
     * @return the subCode
     */
    public String getSubCode() {
        return subCode;
    }

    /**
     * @param subCode
     *            the subCode to set
     */
    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg
     *            the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
