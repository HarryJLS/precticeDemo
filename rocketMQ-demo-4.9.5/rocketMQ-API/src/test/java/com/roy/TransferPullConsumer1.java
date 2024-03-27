package com.roy;

import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

public class TransferPullConsumer1 {
    public static volatile boolean running = true;
    public static void main(String[] args) throws Exception {
        //创建Pull消费者，指定消费者组。
        DefaultLitePullConsumer litePullConsumer = new DefaultLitePullConsumer("TransferServiceGroup");
        //从队列中的第一条消息开始消费
        litePullConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        //订阅Order主题
        litePullConsumer.subscribe("Order", "*");
        litePullConsumer.start();
        try {
            while (running) {
                //每次拉取一批消息
                List<MessageExt> messageExts = litePullConsumer.poll();
                System.out.printf("%s%n", messageExts);
            }
        } finally {
            litePullConsumer.shutdown();
        }
    }
}
