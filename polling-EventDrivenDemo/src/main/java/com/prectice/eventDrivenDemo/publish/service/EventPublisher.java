package com.prectice.eventDrivenDemo.publish.service;

import com.prectice.eventDrivenDemo.event.Event;
import com.prectice.eventDrivenDemo.subscriber.Subscriber;

import java.io.Closeable;

/**
 * @author JLS
 * @description:
 * @since 2024-04-20 21:59
 */
public interface EventPublisher extends Closeable {

    /**
     * Initializes the event publisher.
     *
     * @param type       {@link Event >}
     * @param bufferSize Message staging queue size
     */
    void init(Class<? extends Event> type, int bufferSize);

    /**
     * Add listener.
     *
     * @param subscriber {@link Subscriber}
     */
    void addSubscriber(Subscriber subscriber);

    /**
     * Remove listener. 移除订阅者
     *
     * @param subscriber {@link Subscriber}
     */
    void removeSubscriber(Subscriber subscriber);

    /**
     * publish event. 发布事件
     *
     * @param event {@link Event}
     * @return publish event is success
     */
    boolean publish(Event event);

    /**
     * Notify listener. 通知订阅者
     *
     * @param subscriber {@link Subscriber}
     * @param event      {@link Event}
     */
    void notifySubscriber(Subscriber subscriber, Event event);

    void shutdown();
}
