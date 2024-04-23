package com.prectice.pollingDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author JLS
 * @description:
 * @since 2024-04-19 23:29
 */
@Configuration
public class ThreadPoolConfig {

    // 这段代码创建了一个定时执行的线程池。。每个线程在执行时会被命名为 "pollingDemoService-Thread-"，并且被设置为守护线程。
    // 这里的 Executors.newScheduledThreadPool 是 Java 的并发库中的一个工具方法，用于创建一个固定大小的线程池，这个线程池可以定时或者延时执行任务。
    // 线程池的大小为5。 r -> { Thread t = new Thread(r); t.setName("pollingDemoService-Thread-");
    // t.setDaemon(true); return t; } 是一个线程工厂，用于创建新的线程。这个工厂创建的线程会被命名为 "pollingDemoService-Thread-"，
    // 并且被设置为守护线程。守护线程是一种在后台运行的线程，当所有的非守护线程结束时，JVM 会退出，不会关心守护线程是否已经执行完毕。
    @Bean
    public ScheduledExecutorService scheduledExecutorService() {
        return Executors.newScheduledThreadPool(1, r -> {
            Thread t = new Thread(r);
            t.setName("pollingDemoService-Thread-");
            t.setDaemon(true);
            return t;
        });
    }
}
