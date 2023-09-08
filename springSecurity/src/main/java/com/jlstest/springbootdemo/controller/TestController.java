package com.jlstest.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jlstest.springbootdemo.aop.newLimit.RateLimitNew;
import com.jlstest.springbootdemo.common.response.BaseController;
import com.jlstest.springbootdemo.common.response.JlsTestResponse;

/**
 * @author JLS
 * @description:
 * @since 2023-03-22 19:09
 */
@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

    @GetMapping("/test")
    @ResponseBody
    // @RateLimit(resourceName = "test", initialCapacity = 10, refillRate = 2, refillTimeUnit =
    // TimeUnit.SECONDS)
    @RateLimitNew(resourceName = "test1", permits = 1, restoreRate = 10)
    public JlsTestResponse<String> test() {
        return sendSuccessData("success");
    }

}
