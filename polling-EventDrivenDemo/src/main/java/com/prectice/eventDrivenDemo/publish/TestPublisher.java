package com.prectice.eventDrivenDemo.publish;

import com.prectice.eventDrivenDemo.event.Event;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author JLS
 * @description:
 * @since 2024-04-23 20:50
 */
@Slf4j
public class TestPublisher extends DefaultPublisher {

    /**
     * 线程是否初始化标志
     * */
    private volatile boolean initialized = false;

    /**
     * 事件队列
     * */
    private BlockingQueue<Event> queue;

    /**
     * 发布者名称
     * */
    private String publisherName;

    /**
     * 线程名称
     * */
    private static final String THREAD_NAME = "test-";

    @Override
    public void init(Class<? extends Event> type, int bufferSize) {
        this.queue = new ArrayBlockingQueue<>(bufferSize);
        this.publisherName = type.getSimpleName();
        super.setName(THREAD_NAME + this.publisherName);
        super.setDaemon(true);
        super.start();
        initialized = true;
    }

    @Override
    public boolean publish(Event event) {
        checkIsStart();
        boolean success = this.queue.offer(event);
        if (!success) {
            log.warn("Unable to plug in due to interruption, synchronize sending time, event : {}", event);
            // 事件处理
//            handleEvent(event);
            return true;
        }
        return true;
    }


    /**
     * 校验线程是否启动
     * */
    void checkIsStart() {
        if (!initialized) {
            throw new IllegalStateException("Publisher does not start");
        }
    }
}
