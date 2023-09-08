package com.jlstest.springbootdemo.config;

import com.jlstest.springbootdemo.common.exception.ServiceException;
import com.jlstest.springbootdemo.common.response.JlsTestResponse;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author JLS
 * @description: 全局异常捕捉
 * @since 2023-06-27 10:10
 */

@ControllerAdvice
@ResponseBody
@Slf4j
public class ExceptionHandle {

    @ExceptionHandler(ServiceException.class)
    public JlsTestResponse<Object> handleServiceException(ServiceException e) {
        log.error("ExceptionHandlerAdvice==>ServiceException", e);
        if (e.getResultCode() != null) {
            return JlsTestResponse.sendFailure(e);
        } else if (!StringUtils.isEmpty(e.getMsg())) {
            return JlsTestResponse.sendFailure(e.getMsg());
        }
        return JlsTestResponse.sendFailure("");
    }

//    @ExceptionHandler(UsernameNotFoundException.class)
//    public JlsTestResponse<Object> handlerUsernameNotFoundException(UsernameNotFoundException e) {
//        log.error("ExceptionHandlerAdvice=======>>UsernameNotFoundException", e);
//        if (!StringUtils.isEmpty(e.getMessage())) {
//            return JlsTestResponse.sendFailure(e.getMessage());
//        }
//        return JlsTestResponse.sendFailure("");
//    }

    /**
     * 捕捉普通异常并进行
     */
    @ExceptionHandler(Exception.class)
    public JlsTestResponse<Object> handleException(Exception e) {
        log.warn("ExceptionHandlerAdvice==>Exception", e);
        return JlsTestResponse.sendFailure("程序运行异常");
    }
}
