package com.roy;

import org.apache.rocketmq.acl.common.AclClientRPCHook;
import org.apache.rocketmq.acl.common.SessionCredentials;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.rebalance.AllocateMessageQueueAveragely;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.remoting.RPCHook;


public class AclClient {
    private static final String ACL_ACCESS_KEY = "RocketMQ";
    private static final String ACL_SECRET_KEY = "1234567";
    //携带权限信息
    static RPCHook getAclRPCHook() {
        return new AclClientRPCHook(new SessionCredentials(ACL_ACCESS_KEY,ACL_SECRET_KEY));
    }

    public static void main(String[] args) throws MQClientException, InterruptedException {
        producer();
        pushConsumer();
    }

    private static void pushConsumer() {
        //传入权限信息
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("ConsumerGroupName", getAclRPCHook(), new AllocateMessageQueueAveragely());
        //.....
    }

    private static void producer() {
        //传入权限信息
        DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName", getAclRPCHook());
        //.......
    }
}
