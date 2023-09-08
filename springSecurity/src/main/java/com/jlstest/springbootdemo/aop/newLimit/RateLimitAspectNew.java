package com.jlstest.springbootdemo.aop.newLimit;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.redisson.api.RRateLimiter;
import org.redisson.api.RateIntervalUnit;
import org.redisson.api.RateType;
import org.redisson.api.RedissonClient;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jlstest.springbootdemo.common.exception.ServiceException;

/**
 * @author JLS
 * @description:
 * @since 2023-08-01 14:56
 */
@Aspect
@Component
@Scope
public class RateLimitAspectNew {

    private final Map<String, RRateLimiter> rateLimiterMap = new ConcurrentHashMap<>();

    private final Map<String, Long> lastAccessTimeMap = new ConcurrentHashMap<>();

    // @Value("${redis.address}")
    // private String redisAddress; // Redis连接地址，可以从配置文件中读取

    @Resource
    private RedissonClient redissonClient;

    @Before("@annotation(rateLimitNew)")
    public void before(JoinPoint joinPoint, RateLimitNew rateLimitNew) {
        String resourceName = rateLimitNew.resourceName();
        int permits = rateLimitNew.permits();
        int restoreRate = rateLimitNew.restoreRate();

        // 创建或获取令牌桶
        RRateLimiter rateLimiter = rateLimiterMap.computeIfAbsent(resourceName, key -> {
            // 获取对应资源名的实例，当资源不存在时会新建一个
            RRateLimiter limiter = redissonClient.getRateLimiter(resourceName);
            // 使用 trySetRate 方法设置令牌桶的速率。，只有新建限流器的时候才会设置属性
            limiter.trySetRate(RateType.OVERALL, permits, restoreRate, RateIntervalUnit.SECONDS);
            // 返回对应实例
            return limiter;
        });

        // 当时消费令牌
        if (!rateLimiter.tryAcquire()) {
            throw new ServiceException("Rate limit exceeded for resource: " + resourceName);
        }

        lastAccessTimeMap.put(resourceName, System.currentTimeMillis());
    }

    // 定期清除不活跃的令牌桶
    @Scheduled(fixedDelay = 60000) // 每分钟执行一次清理任务
    public void cleanUpRateLimiters() {
        long inactiveDuration = 5 * 60 * 1000; // 5分钟不活跃则清除
        long currentTime = System.currentTimeMillis();
        rateLimiterMap.entrySet().removeIf(entry -> {
            String resourceName = entry.getKey();
            Long lastAccessTime = lastAccessTimeMap.get(resourceName);
            // 判断是否超过不活跃时间
            if (lastAccessTime != null && currentTime - lastAccessTime > inactiveDuration) {
                // 移除令牌桶实例
                RRateLimiter rateLimiter = entry.getValue();
                rateLimiter.delete();
                // 移除资源名的记录
                lastAccessTimeMap.remove(resourceName);
                return true; // 移除该令牌桶实例
            }
            return false; // 不需要移除该令牌桶实例
        });
    }
}
