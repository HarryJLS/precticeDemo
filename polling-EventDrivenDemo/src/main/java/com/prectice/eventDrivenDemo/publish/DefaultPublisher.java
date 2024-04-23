package com.prectice.eventDrivenDemo.publish;

import com.prectice.eventDrivenDemo.event.Event;
import com.prectice.eventDrivenDemo.publish.service.EventPublisher;
import com.prectice.eventDrivenDemo.subscriber.Subscriber;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * @author JLS
 * @description:
 * @since 2024-04-20 22:05
 */
@Slf4j
public class DefaultPublisher extends Thread implements EventPublisher {

    private BlockingQueue<Event> queue;

    private volatile boolean shutdown = false;

    /**
     * 线程启动标志
     * */
    private volatile boolean initialized = false;

    /**
     * Initializes the event publisher.
     *
     * @param type       {@link Event >}
     * @param bufferSize Message staging queue size
     */
    @Override
    public void init(Class<? extends Event> type, int bufferSize) {
        // 线程属性赋值
        setDaemon(true);
        setName("nacos.publisher-" + type.getName());
        // 初始化阻塞队列
        this.queue = new ArrayBlockingQueue<>(bufferSize);
        // 启动线程
        start();
    }

    @Override
    public void close() throws IOException {

    }

    /**
     * Add listener.  增加订阅者
     *
     * @param subscriber {@link Subscriber}
     */
    @Override
    public void addSubscriber(Subscriber subscriber) {

    }

    /**
     * Remove listener. 移除订阅者
     *
     * @param subscriber {@link Subscriber}
     */
    @Override
    public void removeSubscriber(Subscriber subscriber) {

    }

    /**
     * publish event. 发布事件
     *
     * @param event {@link Event}
     * @return publish event is success
     */
    @Override
    public boolean publish(Event event) {
        return false;
    }

    /**
     * Notify listener. 通知订阅者
     *
     * @param subscriber {@link Subscriber}
     * @param event      {@link Event}
     */
    @Override
    public void notifySubscriber(Subscriber subscriber, Event event) {

    }


    @Override
    public void run() {
        openEventHandler();
    }
    // 开始线程处理   订阅者直接订阅在发布者中，当
    void openEventHandler() {
        try {
            for (; ; ) {
                if (shutdown) {
                    break;
                }
                final Event event = queue.take();
                receiveEvent(event);

            }
        } catch (Throwable ex) {
            log.error("Event listener exception : ", ex);
        }
    }

    void receiveEvent(Event event) {
        final long currentEventSequence = event.sequence();
//        // 判断订阅者是否为空
//        if (!hasSubscriber()) {
//            LOGGER.warn("[NotifyCenter] the {} is lost, because there is no subscriber.", event);
//            return;
//        }
//
//        // Notification single event listener
//        for (Subscriber subscriber : subscribers) {
//            // Whether to ignore expiration events
//            if (subscriber.ignoreExpireEvent() && lastEventSequence > currentEventSequence) {
//                LOGGER.debug("[NotifyCenter] the {} is unacceptable to this subscriber, because had expire",
//                        event.getClass());
//                continue;
//            }
//
//            // Because unifying smartSubscriber and subscriber, so here need to think of compatibility.
//            // Remove original judge part of codes. 通知订阅者处理
//            notifySubscriber(subscriber, event);
//        }
    }


    @Override
    public void shutdown() {
        this.shutdown = true;
        this.queue.clear();
    }
}
