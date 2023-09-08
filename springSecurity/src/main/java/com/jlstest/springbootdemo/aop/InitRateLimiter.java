//package com.jlstest.springbootdemo.aop;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.jlstest.springbootdemo.util.RedisCache;
//
//import javax.annotation.Resource;
//
///**
// * @author JLS
// * @description: 令牌桶初始化
// * @since 2023-06-21 14:14
// */
//@Component
//public class InitRateLimiter {
//
//    // public static Map<String, RateLimiter> rateLimiterMap = new HashMap<>();
//    //
//    // public static void setRateLimiterMap(String resourceName, RateLimiter rateLimiter) {
//    // rateLimiterMap.putIfAbsent(resourceName, rateLimiter);
//    // }
//    // public static RateLimiter getRateLimiter(String resourceName) {
//    // return rateLimiterMap.get(resourceName);
//    // }
////
////    @Autowired
////    private static RedisCache redisCache;
//
//    private static final String RATE_LIMITER_KEY_PREFIX = "rate_limiter:";
//
//    public static void setRateLimiter(String resourceName, DistributedRateLimiter distributedRateLimiter, RedisCache redisCache) {
//
//        String rateLimiterKey = RATE_LIMITER_KEY_PREFIX + resourceName;
//        if (redisCache.getCacheObject(rateLimiterKey) != null) {
//            return;
//        }
//        redisCache.setCacheObject(rateLimiterKey, distributedRateLimiter);
//
//    }
//
//    public static DistributedRateLimiter getRateLimiter(String resourceName, RedisCache redisCache) {
//        String rateLimiterKey = RATE_LIMITER_KEY_PREFIX + resourceName;
//        DistributedRateLimiter distributedRateLimiter = redisCache.getCacheObject(rateLimiterKey);
//        if (distributedRateLimiter != null) {
//            return distributedRateLimiter;
//        }
//        return null;
//    }
//
////    private static String serializeRateLimiter(RateLimiter rateLimiter) {
////        // 将速率限制器序列化为字符串，可以使用 JSON 或其他序列化方式
////        // 这里仅做示例，假设速率限制器的 toString() 方法返回字符串表示
////        return rateLimiter.toString();
////    }
////
////    private static RateLimiter deserializeRateLimiter(String serializedRateLimiter) {
////        // 将字符串反序列化为速率限制器对象，根据实际情况进行反序列化操作
////        // 这里仅做示例，假设速率限制器的构造函数接受字符串参数
////        return new RateLimiter(serializedRateLimiter);
////    }
//}
