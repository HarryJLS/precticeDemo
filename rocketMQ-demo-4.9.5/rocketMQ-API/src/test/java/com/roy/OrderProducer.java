package com.roy;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

public class OrderProducer {
    public static void main(String[] args) {
        try {
            DefaultMQProducer producer = new DefaultMQProducer("OrderService");
            producer.start();
            for (int i = 0; i < 10; i++) {
                int orderId = i % 10;
                for(int j = 1; j < 6;j++){
                    String orderMessage = "OrderId: "+orderId+"; busiStep:"+j;
                    Message msg = new Message("Order", "*",orderMessage.getBytes(RemotingHelper.DEFAULT_CHARSET));
                    SendResult sendResult = producer.send(msg);
                    if(sendResult.getSendStatus() == SendStatus.SEND_OK){
                        System.out.println(orderMessage+"; 发送成功");
                    }
                }
            }
            producer.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
