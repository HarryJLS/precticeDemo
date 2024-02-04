package com.roy.kfk.boot;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @auth roykingw
 */
@Component
public class KafkaConsumer {

    /**
     * id：指定消费者的标识，用于区分不同的消费者。
     * containerFactory：指定使用的 ConcurrentKafkaListenerContainerFactory 的 bean 名称，可以用于自定义消费者的配置。
     * topics：订阅的主题列表。
     * topicPattern：用于订阅匹配正则表达式的主题。
     * topicPartitions：指定订阅的主题分区。
     * containerGroup：指定监听容器的组 ID。
     * errorHandler：指定错误处理器的 bean 名称，用于处理消费过程中的错误。
     * groupId：指定消费者组的 ID。
     * idIsGroup：表示 id 是否是消费者组的 ID。
     * clientIdPrefix：为消费者配置的客户端 ID 的前缀。
     * beanRef：指定监听器 bean 的名称。
     * */

    // 消费监听
    @KafkaListener(topics = {"topic1"})
    public void onMessage1(ConsumerRecord<?, ?> record){
        // 消费的哪个topic、partition的消息,打印出消息内容
        System.out.println("简单消费："+record.topic()+"-"+record.partition()+"-"+record.value());
    }
}
