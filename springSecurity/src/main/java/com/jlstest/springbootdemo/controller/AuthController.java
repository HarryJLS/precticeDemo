//package com.jlstest.springbootdemo.controller;
//
//import javax.annotation.Resource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.jlstest.springbootdemo.common.exception.CommonResultCode;
//import com.jlstest.springbootdemo.common.response.BaseController;
//import com.jlstest.springbootdemo.common.response.JlsTestResponse;
//import com.jlstest.springbootdemo.model.LoginForm;
//import com.jlstest.springbootdemo.service.UserService;
//import com.jlstest.springbootdemo.util.JwtTokenUtil;
//
///**
// * @author JLS
// * @description:
// * @since 2023-06-29 15:12
// */
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController extends BaseController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Resource
//    private JwtTokenUtil jwtTokenUtil;
//
//    @Resource
//    private UserService userService;
//
//    @PostMapping("/login")
//    public JlsTestResponse<?> login(@RequestBody LoginForm loginForm) {
//        try {
//            // 使用用户名和密码进行身份验证
//            Authentication authentication = authenticationManager
//                    .authenticate(new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));
//
//            // 在SecurityContext中设置认证信息
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//
//            // 生成JWT令牌
//            UserDetails userDetails = userService.loadUserByUsername(loginForm.getUsername());
//            String token = jwtTokenUtil.generateToken(userDetails);
//
//            // 构建响应对象
//            return sendSuccessData(token);
//        } catch (AuthenticationException e) {
//            // 处理身份验证失败的情况
//            return JlsTestResponse.sendFailure(CommonResultCode.ERROR);
//        }
//    }
//}
