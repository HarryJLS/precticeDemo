package com.jlstest.exception;

import com.jlstest.common.CommonResponse;

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
    public CommonResponse<Object> handleResultException(ServiceException e) {
        log.warn("ExceptionHandlerAdvice==>ServiceException", e);
        if (!StringUtils.isEmpty(e.getMsg())) {
            return CommonResponse.sendFailure(e.getMsg());
        }
        return CommonResponse.sendFailure("");
    }

    /**
     * 捕捉普通异常并进行
     */
    @ExceptionHandler(Exception.class)
    public CommonResponse<Object> handleException(Exception e) {
        log.warn("ExceptionHandlerAdvice==>Exception", e);
        return CommonResponse.sendFailure(CommonResultCode.PROGRAM_EXCEPTION);
    }



}
