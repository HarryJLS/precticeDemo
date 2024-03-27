package com.roy;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

public class SyncProducer {
    public static void main(String[] args)throws Exception{
        DefaultMQProducer producer = new DefaultMQProducer("producerGroup");
        producer.start();
        Message message = new Message("Order","tag","order info : orderId = xxx".getBytes(StandardCharsets.UTF_8));
        for(int i = 0 ; i < 5 ; i ++){
            SendResult sendResult = producer.send(message);
            //sendStatus = SEND_OK表示消息成功发送到了Broker
            if(SendStatus.SEND_OK!=sendResult.getSendStatus()){
                System.out.println("订单消息发送成功");
                break;
            }else{
                System.out.println("订单消息发送失败。等待重试。重试次数："+i);
            }
        }
        Thread.sleep(50000);
        producer.shutdown();
    }
}
