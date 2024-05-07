package com.prectice.other_prectice;

/**
 * @author JLS
 * @description:
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
        TokenNum = Math.min(capacity, (now - tiemstamp) * rate);
        tiemstamp = now;
        if (TokenNum > 0) {
            TokenNum--;
            return true;
        } else {
            return false;
        }
    }
}
