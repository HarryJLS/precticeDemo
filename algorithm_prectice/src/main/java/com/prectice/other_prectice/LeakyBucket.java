package com.prectice.other_prectice;

/**
 * @author JLS
 * @description: 漏桶算法
 *               漏桶是一种常见的流量整形算法，可以用于流量整形和流量控制，漏桶算法的基本思想是，系统以一个恒定的速度流出数据，
 *               当流入的数据以一个速度过快时，会导致溢出，从而丢弃数据。
 * @since 2024-05-05 15:49
 */
public class LeakyBucket {

    // 记录的时间戳
    public long timeStamp = System.currentTimeMillis();
    // 漏桶的容量
    public long capacity;
    // 漏桶流出的速率
    public long rate = 1;
    // 当前的水量
    public long water;

    public boolean limit() {
        // 计算出水量
        long now = System.currentTimeMillis();
        water = Math.max(0, water - (now - timeStamp) * rate);
        timeStamp = now;
        if (water + 1 < capacity) {
            // 水还未满，继续加水
            water += 1;
            return true;
        } else {
            // 水满，拒绝加水
            return false;
        }
    }

}
