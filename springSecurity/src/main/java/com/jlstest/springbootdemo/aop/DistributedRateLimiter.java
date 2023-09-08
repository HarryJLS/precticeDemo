//package com.jlstest.springbootdemo.aop;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * 令牌桶
// */
//public class DistributedRateLimiter {
//    private final int maxTokens;
//    private final int refillRate;
//    private final TimeUnit refillTimeUnit;
//    private final DistributedTokenBucketStorage storage;
//
//    /**
//     * 带参构造函数，用于初始化令牌桶的最大容量、令牌的补充速率、令牌补充速率的时间单位
//     */
//    public DistributedRateLimiter(int maxTokens, int refillRate, TimeUnit refillTimeUnit, DistributedTokenBucketStorage distributedStorage) {
//        this.maxTokens = maxTokens;
//        this.refillRate = refillRate;
//        this.refillTimeUnit = refillTimeUnit;
//        this.storage = distributedStorage;
//
//        initTokenBucket();
//        scheduleRefill();
//    }
//
//    /**
//     * 尝试获取令牌并且消费
//     */
//    public boolean allowRequest() {
//        return storage.tryConsumeToken();
//    }
//
//    /**
//     * 初始化令牌桶
//     */
//    private void initTokenBucket() {
//        storage.refillTokens(maxTokens);
//    }
//
//    /**
//     * 定时恢复令牌桶数量
//     */
//    private void scheduleRefill() {
//        Thread refillThread = new Thread(() -> {
//            while (true) {
//                try {
//                    TimeUnit.MILLISECONDS.sleep(refillTimeUnit.toMillis(1) / refillRate);
//                    storage.refillTokens(1);
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                    break;
//                }
//            }
//        });
//        refillThread.setDaemon(true);
//        refillThread.start();
//    }
//}
