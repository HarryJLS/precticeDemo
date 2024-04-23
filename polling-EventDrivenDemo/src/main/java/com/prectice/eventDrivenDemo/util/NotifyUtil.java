package com.prectice.eventDrivenDemo.util;

import com.prectice.eventDrivenDemo.event.Event;
import com.prectice.eventDrivenDemo.publish.service.EventPublisher;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author JLS
 * @description: 同时
 * @since 2024-04-23 20:30
 */
@Slf4j
public class NotifyUtil {

    private static final NotifyUtil INSTANCE = new NotifyUtil();

    private final Map<String, EventPublisher> publisherMap = new ConcurrentHashMap<>(16);

    public static boolean publishEvent(final Event event) {

        String topic = event.getClass().getCanonicalName();
        // 根据类型获取指定的发布者
        EventPublisher publisher = INSTANCE.publisherMap.get(topic);
        if (publisher != null) {
            // 事件发布
            return publisher.publish(event);
        }
        log.warn("There are no [{}] publishers for this event, please register", topic);
        return false;
    }


    /**
     * 注册推送者
     * */
    public static void registerToPublisher(final Class<? extends Event> eventType, final EventPublisher publisher) {
        if (null == publisher) {
            return;
        }
        final String topic = eventType.getCanonicalName();
        synchronized (NotifyUtil.class) {
            INSTANCE.publisherMap.putIfAbsent(topic, publisher);
        }
    }
}
