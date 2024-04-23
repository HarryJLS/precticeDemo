package com.prectice.pollingDemo.service.Impl;

import com.prectice.pollingDemo.service.PollingDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author JLS
 * @description:
 * @since 2024-04-19 23:19
 */
@Service
@Slf4j
public class PollingDemoServiceImpl implements PollingDemoService {



    private final ScheduledExecutorService scheduledExecutorService;

    public PollingDemoServiceImpl(ScheduledExecutorService scheduledExecutorService) {
        this.scheduledExecutorService = scheduledExecutorService;
    }

    public static final BlockingDeque<Object> QUEUE = new LinkedBlockingDeque<>(5);

    public static final Object ITEM = new Object();



    /**
     * 启动轮询器
     */
    @Override
    public void startTimer() {
        scheduledExecutorService.schedule(() -> {
            try {
                // 核心思想，使用阻塞队列和while实现轮询，指定时间的轮询
                while (!scheduledExecutorService.isShutdown() && !scheduledExecutorService.isTerminated()) {
                    QUEUE.poll(10, java.util.concurrent.TimeUnit.SECONDS);
                    if (scheduledExecutorService.isShutdown() || scheduledExecutorService.isTerminated()) {
                        continue;
                    }
                    // todo 这里可以添加对应的业务逻辑操作
                    log.info("轮询器工作中");
                }
            } catch (InterruptedException e) {
                log.error("轮询器工作中断");
            }


            System.out.println("轮询器开始工作");
        }, 0, java.util.concurrent.TimeUnit.SECONDS);
    }

    /**
     * 模拟数据刷新，当有刷新则对阻塞队列中添加元素
     */
    @Override
    public void reFresh() {
        QUEUE.offer(ITEM);
    }
}
