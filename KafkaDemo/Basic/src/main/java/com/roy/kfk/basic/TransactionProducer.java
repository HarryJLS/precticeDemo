package com.roy.kfk.basic;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.errors.ProducerFencedException;

import javax.swing.*;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @auth roykingw
 */
public class TransactionProducer {
    private static final String BOOTSTRAP_SERVERS = "test1:9092,test2:9093,test3:9093";
    private static final String TOPIC = "disTopic";
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties props = new Properties();
        // 此处配置的是kafka的端口
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        // 事务ID。
        props.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG,"111");
        // 配置key的序列化类
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        // 配置value的序列化类
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");

        Producer<String,String> producer = new KafkaProducer<>(props);
        producer.initTransactions();
        producer.beginTransaction();
        try{
            for(int i = 0; i < 5; i++) {
                ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, Integer.toString(i), "MyProducer" + i);
                //异步发送。
                producer.send(record);
            }
            producer.commitTransaction();
        }catch (ProducerFencedException e){
            producer.abortTransaction();
        }finally {
            producer.close();
        }
    }
}
