package com.jlstest.springbootdemo.aop;

import com.jlstest.springbootdemo.util.RedisCache;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author JLS
 * @description:
 * @since 2023-06-25 15:01
 */
@Slf4j
public class DistributedRateLimiterNew {

    private final RedisCache redisCache;
    private final String resourceName;
    private final int maxTokens;
    private final int refillRate;
    private final long refillInterval;

    /**
     * 资源key值前缀
     */
    public static final String RATE_LIMIT_KEY = "rate_limit:";

    /**
     * 最近一次更新token的时间
     */
    public static final String LAST_REFILL_TIME_KEY = "last_refill_time:";

    /**
     * @param redisCache
     *            redis工具类
     * @param resourceName
     *            资源名称
     * @param maxTokens
     *            令牌桶容量
     * @param refillRate
     *            令牌桶单位时间填充速率
     * @param refillInterval
     *            令牌桶填充时间间隔，单位ms
     */
    public DistributedRateLimiterNew(RedisCache redisCache, String resourceName, int maxTokens, int refillRate, long refillInterval) {
        this.redisCache = redisCache;
        this.resourceName = resourceName;
        this.maxTokens = maxTokens;
        this.refillRate = refillRate;
        this.refillInterval = refillInterval;

        // 初始化令牌桶
        initializeTokenBucket();
    }

    /**
     * 是否允许请求
     */
    public boolean allowRequest() {
        String key = RATE_LIMIT_KEY + resourceName;
        long currentTime = System.currentTimeMillis();

        // 获取当前令牌数量
        Integer tokenCountCache = redisCache.getCacheObject(key);
        int tokenCount = Objects.isNull(tokenCountCache) ? 0 : tokenCountCache;

        // 补充令牌
        long lastRefillTime = redisCache.getCacheObject(LAST_REFILL_TIME_KEY + resourceName);
        long timePassed = currentTime - lastRefillTime;
        int newTokens = (int) (timePassed * refillRate / refillInterval);
        tokenCount = Math.min(tokenCount + newTokens, maxTokens);

        log.info("扣除之前tokenCount:{}", tokenCount);

        // 判断是否允许请求
        if (tokenCount > 0) {
            tokenCount--;
            log.info("扣除之后tokenCount:{}", tokenCount);
            // 保存令牌桶数量
            redisCache.setCacheObject(key, tokenCount, 60, TimeUnit.MINUTES);
            // 保存最近一次更新token的时间
            redisCache.setCacheObject(LAST_REFILL_TIME_KEY + resourceName, System.currentTimeMillis(), 60, TimeUnit.MINUTES);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 初始化令牌桶
     */
    private void initializeTokenBucket() {
        // 当资源为空时，则进行新建
        if (redisCache.getCacheObject(RATE_LIMIT_KEY + resourceName) == null) {
            // 保存最近一次更新token的时间
            redisCache.setCacheObject(LAST_REFILL_TIME_KEY + resourceName, System.currentTimeMillis(), 60, TimeUnit.MINUTES);
            // 保存令牌桶数量，设置默认值，设置默认值
            redisCache.setCacheObject(RATE_LIMIT_KEY + resourceName, maxTokens, 60, TimeUnit.MINUTES);
            // 设置过期时间，当长期不用则进行释放
            redisCache.expire(resourceName, 3600L);
        }
    }
}
