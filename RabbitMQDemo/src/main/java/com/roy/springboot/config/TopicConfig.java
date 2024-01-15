package com.roy.springboot.config;

import com.roy.springboot.util.MyConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {

	//声明队列
	@Bean
	public Queue topicQ1() {
		return new Queue(MyConstants.QUEUE_TOPIC1);
	}
	@Bean
	public Queue topicQ2() {
		return new Queue(MyConstants.QUEUE_TOPIC2);
	}
	@Bean
	public Queue topicQ3() {
		return new Queue(MyConstants.QUEUE_TOPIC3);
	}
	@Bean
	public Queue topicQ4() {
		return new Queue(MyConstants.QUEUE_TOPIC4);
	}
	//声明exchange
	@Bean
	public TopicExchange setTopicExchange() {
		return new TopicExchange(MyConstants.EXCHANGE_TOPIC);
	}
	//声明binding，需要声明一个roytingKey
	@Bean
	public Binding bindTopicHebei1() {
		return BindingBuilder.bind(topicQ1()).to(setTopicExchange()).with("hunan.*");
	}
	@Bean
	public Binding bindTopicHebei2() {
		return BindingBuilder.bind(topicQ2()).to(setTopicExchange()).with("*.IT");
	}
	@Bean
	public Binding bindTopicHebei3() {
		return BindingBuilder.bind(topicQ3()).to(setTopicExchange()).with("*.eco");
	}
	@Bean
	public Binding bindTopicHebei4() {
		return BindingBuilder.bind(topicQ4()).to(setTopicExchange()).with("hebei.*");
	}
	
}
