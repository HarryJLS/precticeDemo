package com.jlstest.springbootdemo.common.exception;


import com.jlstest.springbootdemo.common.enums.ResultCode;

/**
 * @author JLS
 * @description:
 * @since 2022-11-09 15:02
 */
public enum CommonResultCode implements ResultCode {

    /**
     * 接口返回信息枚举类型
     */
    SUCCESS("200", "操作成功"),

    /**
     * Error result code.
     */
    ERROR("500", "操作失败"),

    /**
     * 异常测试
     */
    TEST_ERROR("10001001", "测试异常"),

    /**
     * 参数异常
     */
    PARAMETER_ERROR("10000001", "参数错误，请重试！"),

    /**
     * 程序运行异常
     */
    PROGRAM_EXCEPTION("10000002", "程序运行异常,请重试！"),

    /**
     * 后台数据库操作异常！
     */
    DATABASE_EXCEPTION("10000003", "后台数据库操作异常,请重试！"),

    /**
     * 占用状态不能为空
     */
    NON_STATE("10000004", "占用状态不能为空！"),

    /**
     * 历史数据存在异常，请联系管理员！
     */
    HISTORY_DATA_WRONG("10000005", "历史数据存在异常，请联系管理员！"),

    /**
     * 请勿操作其它省份!
     */
    NOT_OPERATE_OTHER_PROVINCE("10000006", "请勿操作其它省份!"),;

    private String code;
    private String msg;

    CommonResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
