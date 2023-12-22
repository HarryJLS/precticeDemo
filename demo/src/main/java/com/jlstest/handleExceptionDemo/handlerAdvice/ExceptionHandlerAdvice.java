package com.jlstest.handleExceptionDemo.handlerAdvice;

import com.example.common.exception.CommonResultCode;
import com.example.common.exception.ServiceException;
import com.example.common.response.JlsTestResponse;
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

//    /**
//     * 捕捉数据库执行异常
//     */
//    @ExceptionHandler(MyBatisSystemException.class)
//    public Rs<Object> handleMyBatisSystemException(MyBatisSystemException e) {
//        log.warn("MyBatisSystemException===>>>>MyBatisSystemException", e);
//        return Rs.fail(CommonResultCode.DATABASE_EXCEPTION);
//    }
//
//    @ExceptionHandler(IllegalArgumentException.class)
//    public Rs<Object> handleIllegalArgumentException(IllegalArgumentException e) {
//        log.warn("ExceptionHandlerAdvice==>IllegalArgumentException", e);
//        if (!StringUtils.isEmpty(e.getMessage())) {
//            return Rs.fail(e.getMessage());
//        }
//        return Rs.fail("");
//    }
//
//    @ExceptionHandler(IPOccupyException.class)
//    public Rs<Object> handleIPOccupyException(IPOccupyException e) {
//        log.warn("ExceptionHandlerAdvice==>IPOccupyException", e);
//        if (!StringUtils.isEmpty(e.getMessage())) {
//            return Rs.fail(e.getMessage());
//        }
//        return Rs.fail(CommonResultCode.PROGRAM_EXCEPTION);
//    }
//
//    @ExceptionHandler(IPRangeConflictException.class)
//    public Rs<Object> handleIPRangeConflictException(IPRangeConflictException e) {
//        log.warn("ExceptionHandlerAdvice==>IPRangeConflictException", e);
//        if (!StringUtils.isEmpty(e.getMessage())) {
//            return Rs.fail(e.getMessage());
//        }
//        return Rs.fail(CommonResultCode.PROGRAM_EXCEPTION);
//    }
//
//    @ExceptionHandler(NonFreeIPRangeException.class)
//    public Rs<Object> handleNonFreeIPRangeException(NonFreeIPRangeException e) {
//        log.warn("ExceptionHandlerAdvice==>NonFreeIPRangeException", e);
//        if (!StringUtils.isEmpty(e.getMessage())) {
//            return Rs.fail(e.getMessage());
//        }
//        return Rs.fail(CommonResultCode.PROGRAM_EXCEPTION);
//    }
//
//    @ExceptionHandler(IPFormatException.class)
//    public Rs<Object> handleIPFormatException(IPFormatException e) {
//        log.warn("ExceptionHandlerAdvice==>IPFormatException", e);
//        if (!StringUtils.isEmpty(e.getMessage())) {
//            return Rs.fail(e.getMessage());
//        }
//        return Rs.fail(CommonResultCode.PROGRAM_EXCEPTION);
//    }
//
//    @ExceptionHandler(ExcelImportException.class)
//    public Rs<Object> handleExcelImportException(ExcelImportException e) {
//        log.warn("ExceptionHandlerAdvice==>ExcelImportException", e);
//        if (!StringUtils.isEmpty(e.getMessage())) {
//            return Rs.fail(e.getMessage());
//        }
//        return Rs.fail(CommonResultCode.PROGRAM_EXCEPTION);
//    }
//
//
//    @ExceptionHandler(NonRuleFoundException.class)
//    public Rs<Object> handleNonRuleFoundException(NonRuleFoundException e) {
//        log.warn("ExceptionHandlerAdvice==>NonRuleFoundException", e);
//        if (!StringUtils.isEmpty(e.getMessage())) {
//            return Rs.fail(e.getMessage());
//        }
//        return Rs.fail(CommonResultCode.PROGRAM_EXCEPTION);
//    }

}
