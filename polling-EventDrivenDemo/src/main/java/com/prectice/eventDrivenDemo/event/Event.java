package com.prectice.eventDrivenDemo.event;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author JLS
 * @description:
 * @since 2024-04-20 22:00
 */
public abstract class Event implements Serializable {

        private static final long serialVersionUID = 1L;


    private static final AtomicLong SEQUENCE = new AtomicLong(0);


    // 事件序列号
    private final long sequence = SEQUENCE.getAndIncrement();

    public long sequence() {
        return sequence;
    }
}
