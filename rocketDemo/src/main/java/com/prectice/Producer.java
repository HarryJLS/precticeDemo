package com.prectice;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @author JLS
 * @description:
 * @since 2024-03-25 08:58
 */
public class Producer {

    public static void main(String[] args) throws MQClientException, InterruptedException {
        //初始化一个消息生产者
        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
        // 指定nameserver地址
        producer.setNamesrvAddr("124.221.224.111:9876");
        // 启动消息生产者服务
        producer.start();
        for (int i = 0; i < 500; i++) {
            try {
                // 创建消息。消息由Topic,Tag和body三个属性组成，其中Body就是消息内容
                Message msg = new Message("TopicTest","TagA",("测试看看，主要看中文了，，，， " +i).getBytes(RemotingHelper.DEFAULT_CHARSET));
                //发送消息，获取发送结果
                SendResult sendResult = producer.send(msg);
                System.out.printf("%s%n", sendResult);
            } catch (Exception e) {
                e.printStackTrace();
                Thread.sleep(1000);
            }
        }
        //消息发送完后，停止消息生产者服务。
        producer.shutdown();
    }
}
