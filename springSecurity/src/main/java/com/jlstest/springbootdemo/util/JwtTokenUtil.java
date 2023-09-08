//package com.jlstest.springbootdemo.util;
//
//import java.security.Key;
//import java.util.Base64;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//
///**
// * @author JLS
// * @description:
// * @since 2023-06-29 15:32
// */
//@Component
//public class JwtTokenUtil {
//
//    @Value("${jwt.secret}")
//    private String secret;
//
//    @Value("${jwt.expiration}")
//    private Long expiration;
//
//    // 从令牌中获取用户名
//    public String getUsernameFromToken(String token) {
//        return getClaimFromToken(token, Claims::getSubject);
//    }
//
//    // 从令牌中获取过期时间
//    public Date getExpirationDateFromToken(String token) {
//        return getClaimFromToken(token, Claims::getExpiration);
//    }
//
//    // 根据用户信息生成令牌
//    public String generateToken(UserDetails userDetails) {
//        Map<String, Object> claims = new HashMap<>();
//        return createToken(claims, userDetails.getUsername());
//    }
//
//    // 根据传入的声明生成令牌
//    private String createToken(Map<String, Object> claims, String subject) {
//        Date now = new Date();
//        Date expirationDate = new Date(now.getTime() + expiration * 1000);
//
//        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(now).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, secret)
//                // .signWith(key, SignatureAlgorithm.HS512)
//                .compact();
//    }
//
//    // 验证令牌是否有效
//    public boolean validateToken(String token, UserDetails userDetails) {
//        String username = getUsernameFromToken(token);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }
//
//    // 验证令牌是否过期
//    private boolean isTokenExpired(String token) {
//        Date expirationDate = getExpirationDateFromToken(token);
//        return expirationDate.before(new Date());
//    }
//
//    // 从令牌中获取声明信息
//    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//        return claimsResolver.apply(claims);
//    }
//
//    // 创建JWT密钥，用于生成配置文件中用的密钥 （仅仅测试中适合使用）
//    public static void main(String[] args) {
//        // Generate a secure random JWT secret key for HS512 algorithm
//        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
//
//        // Convert the key to a Base64-encoded string
//        String base64Key = Base64.getEncoder().encodeToString(key.getEncoded());
//
//        System.out.println(base64Key);
//
//    }
//}
