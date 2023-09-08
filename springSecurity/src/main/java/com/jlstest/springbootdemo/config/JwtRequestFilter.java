//package com.jlstest.springbootdemo.config;
//
//import com.jlstest.springbootdemo.service.UserService;
//import com.jlstest.springbootdemo.util.JwtTokenUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author JLS
// * @description:
// * @since 2023-06-29 17:12
// */
//@Component
//public class JwtRequestFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//
//    @Autowired
//    private UserService userService;
//
//    /**
//     * 自定义的过滤器方法，用于实现对请求进行过滤和处理的逻辑
//     */
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
//
//        // 从请求中获取 Authorization 请求头
//        final String authorizationHeader = request.getHeader("Authorization");
//
//        String username = null;
//        String jwtToken = null;
//
//        // 从 Authorization 请求头中获取 JWT Token 从 JWT Token 中获取用户名
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            jwtToken = authorizationHeader.substring(7);
//            // 使用 JWT Token 解析工具 jwtTokenUtil 解析出用户名
//            username = jwtTokenUtil.getUsernameFromToken(jwtToken);
//        }
//
//        // 如果用户名不为空且当前 Security 上下文中没有认证信息，则加载用户详细信息并验证 JWT Token 的有效性
//        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            // 从数据库中获取用户信息
//            UserDetails userDetails = userService.loadUserByUsername(username);
//
//            // 验证 JWT Token 是否有效，如果有效则在 SecurityContextHolder 中进行设置
//            if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
//                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null,
//                        userDetails.getAuthorities());
//                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                // 将请求的身份认证信息设置到 Security 上下文中
//                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//            }
//        }
//
//        // 继续执行过滤器链中的下一个过滤器
//        chain.doFilter(request, response);
//    }
//}
