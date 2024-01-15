package com.roy.springboot.util;

/**
 * @author roy
 * @date 2022/4/26
 * @desc
 */
public class MyConstants {

    public static final String QUEUE_QUORUM = "quorumQueue";
    public static final String QUEUE_STREAM = "streamQueue";
    //direct模式，直接发送到队列
    public static final String QUEUE_DIRECT = "directqueue";
    //fanout模式
    public static final String EXCHANGE_FANOUT = "fanoutExchange";
    public static final String QUEUE_FANOUT_Q1 = "fanout.q1";
    public static final String QUEUE_FANOUT_Q2 = "fanout.q2";
    public static final String QUEUE_FANOUT_Q3 = "fanout.q3";
    public static final String QUEUE_FANOUT_Q4 = "fanout.q4";
    //topic模式
    public static final String EXCHANGE_TOPIC = "topicExchange";
    public static final String QUEUE_TOPIC1 = "hunan.eco";
    public static final String QUEUE_TOPIC2 = "hunan.IT";
    public static final String QUEUE_TOPIC3 = "hebei.eco";
    public static final String QUEUE_TOPIC4 = "hebei.IT";
    //header模式
    public static final String EXCHANGE_HEADER = "headerExchange";
    public static final String QUEUE_TXTYP1 = "txTyp1";
    public static final String QUEUE_BUSTYP1 = "busTyp1";
    public static final String QUEUE_TXBUSTYP1 = "txbusTyp1";

}
