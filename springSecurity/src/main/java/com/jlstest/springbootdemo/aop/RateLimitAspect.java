package com.jlstest.springbootdemo.aop;

import com.jlstest.springbootdemo.util.RedisCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author JLS
 * @description:
 * @since 2023-06-21 14:14
 */
@Aspect
@Component
public class RateLimitAspect {

    @Resource
    private RedisCache redisCache;

    @Around("@annotation(rateLimit)")
    public Object aroundRateLimit(ProceedingJoinPoint joinPoint, RateLimit rateLimit) throws Throwable {

        String resourceName = rateLimit.resourceName();
        int initialCapacity = rateLimit.initialCapacity();
        int refillRate = rateLimit.refillRate();
        TimeUnit refillTimeUnit = rateLimit.refillTimeUnit();

        DistributedRateLimiterNew distributedRateLimiterNew = new DistributedRateLimiterNew(redisCache, resourceName, initialCapacity, refillRate, 10000L);


        if (!distributedRateLimiterNew.allowRequest()) {
            throw new RuntimeException("限流了");
        }

        return joinPoint.proceed();
    }
}
