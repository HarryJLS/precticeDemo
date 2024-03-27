package com.roy;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

public class OrderPayCheckProducer {
    public static void main(String[] args) {
        try {
            DefaultMQProducer producer = new DefaultMQProducer("OrderService");
            producer.start();
            for (int i = 0; i < 10; i++) {
                int orderId = i % 10;
                String orderMessage = "OrderId: "+orderId+" need check payment status;";
                Message msg = new Message("OrderPayCheck", "*",orderMessage.getBytes(RemotingHelper.DEFAULT_CHARSET));
                //指定延迟级别 默认18个延迟级别：1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
                msg.setDelayTimeLevel(3);
                SendResult sendResult = producer.send(msg);
                System.out.println("发送结果："+sendResult);
                if(sendResult.getSendStatus() == SendStatus.SEND_OK){
                    System.out.println(orderMessage+"; 发送成功");
                }
            }
            producer.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
