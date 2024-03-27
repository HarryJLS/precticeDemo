package com.roy.rocketmq.config;

import org.apache.rocketmq.spring.annotation.ExtRocketMQConsumerConfiguration;
import org.apache.rocketmq.spring.annotation.ExtRocketMQTemplateConfiguration;
import org.apache.rocketmq.spring.core.RocketMQTemplate;

/**
 * @author ：楼兰
 * @description:
 **/
@ExtRocketMQTemplateConfiguration()
//@ExtRocketMQConsumerConfiguration(topic="stock_consumer_group")
public class ExtRocketMQTemplate extends RocketMQTemplate {
}
