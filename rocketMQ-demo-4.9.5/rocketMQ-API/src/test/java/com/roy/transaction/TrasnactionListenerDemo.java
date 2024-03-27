package com.roy.transaction;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.io.UnsupportedEncodingException;

public class TrasnactionListenerDemo implements TransactionListener {
    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        int index=  (int)arg;
        System.out.println("==== 开始执行本地事务;index = "+index+" ====="+System.currentTimeMillis());
        if(index % 3 ==1){
            return LocalTransactionState.COMMIT_MESSAGE;
        }else if(index % 3 ==2){
            return LocalTransactionState.ROLLBACK_MESSAGE;
        }else{
            return LocalTransactionState.UNKNOW;
        }
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
        System.out.println("====== 开始回查本地事务状态 ====="+System.currentTimeMillis());
        try {
            int index  = Integer.parseInt(new String(msg.getBody(), RemotingHelper.DEFAULT_CHARSET) );
            System.out.println("====== index = "+index+ " =====");
            if(index % 9 == 3 ){
                return LocalTransactionState.COMMIT_MESSAGE;
            }else if(index %9 == 6){
                return LocalTransactionState.ROLLBACK_MESSAGE;
            }else{
                return LocalTransactionState.UNKNOW;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
