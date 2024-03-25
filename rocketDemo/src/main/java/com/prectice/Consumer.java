package com.prectice;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author JLS
 * @description:
 * @since 2024-03-25 09:00
 */
public class Consumer {

    public static void main(String[] args) throws MQClientException {
        //构建一个消息消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("please_rename_unique_group_name_4");
        //指定nameserver地址
        consumer.setNamesrvAddr("124.221.224.111:9876");
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        // 订阅一个感兴趣的话题，这个话题需要与消息的topic一致
        consumer.subscribe("TopicTest", "*");
        // 注册一个消息回调函数，消费到消息后就会触发回调。
        consumer.setConsumeMessageBatchMaxSize(4);
        consumer.setPullBatchSize(4);
        consumer.setConsumeThreadMax(5);
        consumer.setConsumeThreadMin(3);
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                System.out.println("开始进行消费=====》》》》》》》" + msgs.size());
                msgs.forEach(messageExt -> {
                    try {
                        Thread.sleep(1000);
                        System.out.println("收到消息:"+new String(messageExt.getBody(), RemotingHelper.DEFAULT_CHARSET));
                    } catch (UnsupportedEncodingException | InterruptedException e) {}
                });
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //启动消费者服务
        consumer.start();
        System.out.print("Consumer Started");
    }
}
