//package com.jlstest.springbootdemo.aop;
//
//import java.util.Objects;
//import java.util.concurrent.ConcurrentLinkedQueue;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author JLS
// * @description:
// * @since 2023-06-21 14:15
// */
//public class RateLimiter {
//
//    private ConcurrentLinkedQueue<Long> tokens;
//
//    private final int maxTokens;
//
//    private final int refillRate;
//
//    private final TimeUnit refillTimeUnit;
//
//    /**
//     * @param maxTokens
//     *            桶的最大容量
//     * @param refillRate
//     *            令牌的补充速率
//     * @param refillTimeUnit
//     *            令牌补充速率的时间单位
//     */
//    public RateLimiter(int maxTokens, int refillRate, TimeUnit refillTimeUnit) {
//        this.tokens = new ConcurrentLinkedQueue<>();
//        this.maxTokens = maxTokens;
//        this.refillRate = refillRate;
//        this.refillTimeUnit = refillTimeUnit;
//
//        // 初始化令牌桶
//        refillTokens();
//    }
//
//    /**
//     * 判断是否允许接口请求 当有令牌的时候返回true并取出一个令牌，没有令牌的时候返回false
//     *
//     */
//    public boolean allowRequest() {
//        synchronized (tokens) {
//            if (tokens.isEmpty()) {
//                return false;
//            }
//            System.out.println("；令牌消费成功");
//            System.out.println("；令牌桶剩余数量：" + tokens.size());
//            // 令牌吐出
//            return tokens.poll() != null;
//        }    }
//
//
//    /**
//     * 初始化令牌桶
//     */
//    private void refillTokens() {
//        for (int i = 0; i < maxTokens; i++) {
//            tokens.offer(System.currentTimeMillis());
//        }
//        scheduleRefill();
//    }
//
//
//    /**
//     * 定期补充令牌数量，补充速度由refillTimeUnit和refillRate共同决定
//     */
//    private void scheduleRefill() {
//        Thread refillThread = new Thread(() -> {
//            while (true) {
//                try {
//                    TimeUnit.MILLISECONDS.sleep(refillTimeUnit.toMillis(1) / refillRate);
//                    synchronized (tokens) {
//                        if (tokens.size() < maxTokens) {
//                            tokens.offer(System.currentTimeMillis());
//                        }
//                    }
//                } catch (InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                    break;
//                }
//            }
//        });
//        refillThread.setDaemon(true);
//        refillThread.start();
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o)
//            return true;
//        if (o == null || getClass() != o.getClass())
//            return false;
//        RateLimiter that = (RateLimiter) o;
//        return maxTokens == that.maxTokens && refillRate == that.refillRate && Objects.equals(tokens, that.tokens) && refillTimeUnit == that.refillTimeUnit;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(tokens, maxTokens, refillRate, refillTimeUnit);
//    }
//}
