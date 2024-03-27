package com.roy.scrocket.basic;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

/**
 * @author ：楼兰
 * @description:
 **/
@Component
public class ScConsumer {
    //关于消费者过滤消息的条件，可以在@StreamListener的condition属性中写SPEL表达式来配置
    //但是一般建议还是在配置文件中来配置。
//    @StreamListener(value = Sink.INPUT,condition = "headers['"+RocketMQHeaders.PREFIX+RocketMQHeaders.TAGS+"']=='testTag'")
    @StreamListener(value = Sink.INPUT)
    public void onMessage(String messsage) {
        System.out.println("received message:" + messsage + " from binding:" +
                Sink.INPUT);
    }
}
