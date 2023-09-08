//package com.jlstest.springbootdemo.aop;
//
//import com.jlstest.springbootdemo.util.RedisCache;
//import lombok.extern.slf4j.Slf4j;
//
//import javax.annotation.Resource;
//
//@Slf4j
//public class DistributedTokenBucketStorage {
//
//    private final RedisCache redisCache;
//    private final String bucketKey;
//
//    public DistributedTokenBucketStorage(RedisCache redisCache, String bucketKey) {
//        this.redisCache = redisCache;
//        this.bucketKey = "rate_limit_value" + bucketKey;
//    }
//
//    /**
//     * 尝试消费令牌桶的一个令牌
//     */
//    public boolean tryConsumeToken() {
//        Long tokens = redisCache.getCacheMapValue(bucketKey, "tokens");
//        log.info("tokens:{}", tokens);
//        if (tokens != null) {
//            long newTokens = tokens - 1;
//            log.info("newTokens:{}", newTokens);
//            redisCache.setCacheMapValue(bucketKey, "tokens", newTokens);
//            return newTokens >= 0;
//        }
//        return false;
//    }
//
//    /**
//     * 更新令牌桶中令牌数量
//     */
//    public void refillTokens(int numTokens) {
//        Integer tokens = redisCache.getCacheMapValue(bucketKey, "tokens");
//        if (tokens != null) {
//            long newTokens = tokens + numTokens;
//            log.info("newTokens:{}", newTokens);
//            redisCache.setCacheMapValue(bucketKey, "tokens", newTokens);
//        } else {
//            redisCache.setCacheMapValue(bucketKey, "tokens", numTokens);
//        }
//    }
//}
