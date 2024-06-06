package com.jlstest.caffeineDemo;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.github.benmanes.caffeine.cache.stats.CacheStats;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author JLS
 * @description:
 * @since 2024-06-06 15:29
 */
@Slf4j
public class CaffeineTest {


    public static void main(String[] args) {


        /**
         * maximumSize：设置缓存的最大容量。
         * maximumWeight：设置缓存的最大权重。
         * expireAfterAccess：设置缓存在最后一次读/写操作后的过期时间。
         * expireAfterWrite：设置缓存在写入后的过期时间。
         * refreshAfterWrite：设置缓存在写入后的刷新时间。
         * weakKeys：使用弱引用存储键。
         * weakValues：使用弱引用存储值。
         * softValues：使用软引用存储值。
         * removalListener：设置删除监听器。
         * */
        // 创建缓存实例
        Cache<String, String> cache = Caffeine.newBuilder()
                .maximumSize(1000)
                .expireAfterAccess(5, TimeUnit.SECONDS)
                .build();

        // 插入值
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");
        log.info("Value for key1: {}", cache.getIfPresent("key1"));

        // 根据key值列表批量获取缓存数据
        Map<String, String> map = cache.getAllPresent(Arrays.asList("key1"));
        log.info("Value for key1: {}", map.get("key1"));

        /**
         * hitCount()：缓存命中次数
         * missCount()：缓存未命中次数
         * loadSuccessCount()：从缓存加载成功的次数
         * loadFailureCount()：从缓存加载失败的次数
         * totalLoadTime()：加载缓存消耗的总时间(单位纳秒)
         * evictionCount()：缓存项被驱逐的总次数
         * hitRate()：缓存命中率,计算公式为 hitCount / (hitCount + missCount)
         */
        CacheStats stats = cache.stats();
        log.info("缓存命中率: {}", stats.hitRate());

        // 移除key2
        cache.invalidate("key2");
        // 移除所有缓存
        cache.invalidateAll();

        // 异步操作
        //Caffeine支持异步加载和异步写入操作,可以提高吞吐量:
//        LoadingCache<String, String> cache = Caffeine.newBuilder()
//                .maximumSize(1000)
//                .buildAsync(key -> loadValue(key));
//
//        cache.put(key, value);
//        cache.get(key, () -> loadValue(key));



    }
}
