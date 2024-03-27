package com.roy;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

public class AsyncProducer {
    public static void main(String[] args)throws Exception{
        DefaultMQProducer producer = new DefaultMQProducer("producerGroup");
        producer.start();
        Message message = new Message("Order","tag","order info : orderId = xxx".getBytes(StandardCharsets.UTF_8));
        producer.send(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("订单消息发送成功");
            }
            @Override
            public void onException(Throwable e) {
                System.out.println("订单消息发送失败，失败原因是："+e.getMessage());
            }
        });
        Thread.sleep(5000);
        producer.shutdown();
    }
}
