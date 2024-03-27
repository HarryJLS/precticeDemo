package com.roy.transaction;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.example.transaction.TransactionListenerImpl;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.*;

public class TransactionProducerDemo {

    public static void main(String[] args) throws MQClientException, InterruptedException, UnsupportedEncodingException {
        TrasnactionListenerDemo listener = new TrasnactionListenerDemo();
        TransactionMQProducer producer = new TransactionMQProducer("OrderTransGroup");
        producer.setTransactionListener(listener);
        producer.start();
        //发送十条消息
        for (int i = 0; i < 10; i++) {
                Message msg =new Message("TransTest", "*",("" + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
                SendResult sendResult = producer.sendMessageInTransaction(msg, i);
                if(null != sendResult && sendResult.getSendStatus()== SendStatus.SEND_OK) {
                    System.out.println("第"+i+"条消息发送成功"+System.currentTimeMillis());
                }
                Thread.sleep(10);
        }
        //保持Producer主线程不结束
        for (int i = 0; i < 100000; i++) {
            Thread.sleep(1000);
        }
        producer.shutdown();
    }
}
