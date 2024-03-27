package com.roy;

import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TransferPullConsumer2 {
    public static volatile boolean running = true;
    public static void main(String[] args) throws Exception {
        DefaultLitePullConsumer litePullConsumer = new DefaultLitePullConsumer("TransferServiceGroup2");
        //取消自动提交Offset
        litePullConsumer.setAutoCommit(false);
        litePullConsumer.setUnitMode(true);
        litePullConsumer.setUnitName("aaaaa");
        litePullConsumer.start();
        //获取Order Topic下的所有MessageQueue
        Collection<MessageQueue> mqSet = litePullConsumer.fetchMessageQueues("Order");
        List<MessageQueue> list = new ArrayList<>(mqSet);
        List<MessageQueue> assignList = new ArrayList<>();
        for (int i = 0; i < list.size() / 2; i++) {
            assignList.add(list.get(i));
        }
        //给当前消费者分配负责的MessageQueue。主要影响消费者集群的负载均衡。
        litePullConsumer.assign(assignList);
        //从一个具体的MessageQueue上拉取消息
        litePullConsumer.seek(assignList.get(0), 10);
        try {
            while (running) {
                //每次拉取一批消息
                List<MessageExt> messageExts = litePullConsumer.poll();
                System.out.printf("%s %n", messageExts);
                //处理完成后，通知Broker更新lastOffset
                litePullConsumer.commitSync();
            }
        } finally {
            litePullConsumer.shutdown();
        }
    }
}
