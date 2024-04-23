package com.prectice.eventDrivenDemo.subscriber;

import com.prectice.eventDrivenDemo.event.Event;

import java.util.concurrent.Executor;

/**
 * @author JLS
 * @description:
 * @since 2024-04-20 22:14
 */
public abstract class Subscriber<T extends Event> {

    /**
     * 事件回调
     *
     * @param event
     *            {@link Event}
     */
    public abstract void onEvent(T event);

    /**
     * 获取线程池
     */
    public Executor executor() {
        return null;
    }

}
