//package com.jlstest.springbootdemo.config;
//
//import java.util.Arrays;
//
//import javax.annotation.Resource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import com.jlstest.springbootdemo.service.UserService;
//
///**
// * @author JLS
// * @description:
// * @since 2023-06-29 17:10
// */
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//
//    @Resource
//    private JwtRequestFilter jwtRequestFilter;
//
////    /**
////     * 配置 Spring Security 忽略对某些特定请求的安全验证。一般用于测试
////     */
////    @Override
////    public void configure(WebSecurity web) {
////
////        // 表示忽略对 HTTP OPTIONS 请求方法的验证，并且对所有路径 /** 都生效。
////        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**").antMatchers("/test/test");
////    }
//
//    /**
//     * 配置 Spring Security 的安全策略和过滤器链的方法。通过重写该方法，你可以自定义对不同请求的访问控制、认证配置、异常处理
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // 关闭csrf防护 csrf跨站点请求 可以通过token来避免跨站点请求的攻击 csrf跨站请求伪造
//        // (如果前后端都注册在同一个nginx上，则不存在跨站点请求的攻击问题，毕竟是同源的，所以在生产环境上可以不用关闭csrf的保护)
//        http.csrf().disable()
//                // 表示对于 /api/auth/login 路径的请求，允许所有用户进行访问，即不需要进行身份验证和授权即可访问该路径。
//                .authorizeRequests().antMatchers("/api/auth/login").permitAll()
//                // 表示对于其他所有请求，要求用户进行身份验证才能访问
//                .anyRequest().authenticated();
//
//        // 配置身份验证异常的处理类，使得在身份验证失败时能够自定义处理逻辑，并返回适当的响应信息。
//        http.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint);
//
//        // 在无状态会话策略下，服务器不会创建或使用会话来存储用户状态，每次请求都需要进行身份验证。
//        // 这种策略适用于前后端分离的应用或无需维护用户会话状态的场景，因为它不依赖于会话来存储用户信息或认证状态，而是通过每个请求中的令牌或其他身份验证信息来进行身份验证和授权。
//        // 配置会话创建策略为无状态会话，从而使得系统不依赖于会话来存储用户状态，提高系统的可伸缩性和安全性。
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        // 这段代码的作用是将自定义的 JWT 请求过滤器添加到 Spring Security 过滤器链中，
//        // 并在处理用户名和密码的身份验证之前对 JWT 进行验证和解析。这样可以实现基于 JWT 的身份验证机制。
//        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//
//        // 开启cors配置，主要用于解决跨域问题，并结合 corsConfigurationSource()使用
//        http.cors();
//    }
//
//    // 配置 Spring Security 的身份验证管理器。并指定身份验证的方式和提供者。
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // .userDetailsService(userService) 指定了用于加载用户信息的自定义 UserDetailsService 接口的实现类 userService。
//        // .authenticationProvider(authenticationProvider()) 指定了身份验证的提供者。
//        // authenticationProvider() 方法返回一个 AuthenticationProvider 的实例，其中包含了自定义的身份验证逻辑和处理方式。
//        auth.userDetailsService(userService).passwordEncoder(passwordEncoder()).and().authenticationProvider(authenticationProvider());
//    }
//
//    /**
//     * 定义密码加密方式，一般推荐使用BCryptPasswordEncoder
//     */
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    /**
//     * 用于验证用户信息，其中的userService则是自定义的用户信息获取
//     */
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userService);
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }
//
//    /**
//     * 处理用户信息的核心接口， 负责管理认证过程，包括验证用户的身份、加载用户的权限信息， 最后结果返回，验证后的用户身份信息和相关的权限信息
//     */
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    // 处理跨域问题，一般只有在本地测试，使用浏览器访问时才会出现跨域问题，如果是都部署到nginx上则没有跨域的问题
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8080")); // 添加允许跨域的源
//        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
//        configuration.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//
//}
