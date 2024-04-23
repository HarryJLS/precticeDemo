package com.prectice.pollingDemo.service;

/**
 * @author JLS
 * @description:
 * @since 2024-04-19 23:18
 */
public interface PollingDemoService {

    /**
     * 启动轮询器
     */
    void startTimer();

    /**
     * 模拟数据刷新，当有刷新则对阻塞队列中添加元素
     */
    void reFresh();

}
