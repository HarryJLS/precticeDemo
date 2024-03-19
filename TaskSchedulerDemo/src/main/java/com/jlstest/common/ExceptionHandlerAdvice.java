package com.jlstest.common;

import com.example.common.exception.CommonResultCode;
import com.example.common.exception.ServiceException;
import com.example.common.response.JlsTestResponse;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


import lombok.extern.slf4j.Slf4j;

/**
 * @author JLS
 * @description: 全局异常捕捉
 * @since 2022-11-09 16:21
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ServiceException.class)
    public JlsTestResponse<Object> handleResultException(ServiceException e) {
        log.warn("ExceptionHandlerAdvice==>ServiceException", e);
        if (e.getResultCode() != null) {
            return JlsTestResponse.sendFailure(e.getResultCode());
        } else if (!StringUtils.isEmpty(e.getMsg())) {
            return JlsTestResponse.sendFailure(e.getMsg());
        }
        return JlsTestResponse.sendFailure("");
    }

    /**
     * 捕捉普通异常并进行
     */
    @ExceptionHandler(Exception.class)
    public JlsTestResponse<Object> handleException(Exception e) {
        log.warn("ExceptionHandlerAdvice==>Exception", e);
        return JlsTestResponse.sendFailure(CommonResultCode.PROGRAM_EXCEPTION);
    }


}
