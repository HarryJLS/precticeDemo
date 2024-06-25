package com.prectice.other_prectice;

/**
 * @author JLS
 * @description: 令牌桶算法，令牌桶算法是一种流量整形算法，可以用于流量整形和流量控制，令牌桶算法的基本思想是，
 * 系统以一个恒定的速率往桶里放入令牌，当请求到来时，会先去桶里取令牌，如果有令牌则放行，如果没有令牌则拒绝请求。
 * @since 2024-05-07 10:38
 */
public class TokenBucket {

    // 令牌恢复速率
    private Long rate = 5L;

    // 令牌桶总容量
    private Long capacity = 10L;

    // 初始化时候的时间戳
    private long tiemstamp = System.currentTimeMillis();

    // 当前令牌桶的令牌数量
    private Long TokenNum = 0L;




    private boolean limit() {
        Long now = System.currentTimeMillis();
        Long temp = Math.min(capacity, (now - tiemstamp) * rate);
        if (temp > 0) {
            TokenNum = Math.min(capacity, TokenNum + temp);
            tiemstamp = now;
        }
        if (TokenNum > 0) {
            TokenNum--;
            return true;
        } else {
            return false;
        }
    }
}
