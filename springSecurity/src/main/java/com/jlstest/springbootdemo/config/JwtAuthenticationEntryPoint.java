//package com.jlstest.springbootdemo.config;
//
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author JLS
// * @description: 自定义的身份验证入口点类
// * @since 2023-06-29 17:14
// */
//@Component
//public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
//
//    /**
//     * commence 方法是 AuthenticationEntryPoint 接口中的一个方法，用于处理未经授权的请求的入口点。
//     * 当用户尝试访问需要认证的资源而未提供有效的身份验证凭据时，会触发 commence 方法
//     */
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//    }
//}