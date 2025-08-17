package com.jlstest.guavaCacheDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalCause;
import com.google.common.cache.RemovalNotification;

/**
 * @author JLS
 * @description:
 * @since 2024-04-07 08:59
 */
public class test {

    public static void main(String[] args) {
        // 创建Cache实例
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(10, TimeUnit.SECONDS) // 设置写入后的过期时间为10秒
                .removalListener(test::handleRemoval)
                .build();


        // 存储数据
        cache.put("key1", "value1");
        // 释放key1
        cache.invalidate("key1");

        // 获取数据
        String value1 = cache.getIfPresent("key1");
        System.out.println("Value for key1: " + value1); // 输出：Value for key1: value1

        // 等待过期时间
        try {
            Thread.sleep(5000); // 等待5秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 更新数据
        cache.put("key2", "value2");
        cache.put("key1", "value2");

        // 再次获取数据
        String updatedValue = cache.getIfPresent("key1");
        System.out.println("Updated value for key1: " + updatedValue); // 输出：Updated value for key1: value2

        // 等待过期时间
        try {
            Thread.sleep(6000); // 等待6秒，超过过期时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 获取数据
        String expiredValue = cache.getIfPresent("key2");
        System.out.println("Expired value for key2: " + expiredValue); // 输出：Expired value for key1: null
        // 获取数据
        String expiredValue1 = cache.getIfPresent("key1");
        System.out.println("Expired value for key1: " + expiredValue1); // 输出：Expired value for key1: null
        cache.put("key1", "value3");

        // 等待过期时间
        try {
            Thread.sleep(6000); // 等待6秒，超过过期时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Expired value for key2: " + cache.getIfPresent("key2"));
        System.out.println("Expired value for key1: " + cache.getIfPresent("key1"));

        CopyOnWriteArrayList list = new CopyOnWriteArrayList<>();
        list.add("1");
        list.get(0);
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.set(0, 2);
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "1");

    }

    /**
     * 缓存项被移除时的回调方法
     */
    private static void handleRemoval(RemovalNotification<String, String> notification) {
        String key = notification.getKey();
        String value = notification.getValue();
        RemovalCause cause = notification.getCause();

        System.out.printf("Entry removed - key: %s, value: %s, cause: %s\n", key, value, cause);
    }
}
