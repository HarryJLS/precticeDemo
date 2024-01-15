package com.roy.springboot.config;

import com.roy.springboot.util.MyConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Fanout模式需要声明exchange，并绑定queue，由exchange负责转发到queue上。
 * @author roykingw 2019年7月9日
 *
 */
@Configuration
public class FanoutConfig {

	//声明队列
	@Bean
	public Queue fanoutQ1() {
		return new Queue(MyConstants.QUEUE_FANOUT_Q1);
	}
	@Bean
	public Queue fanoutQ2() {
		return new Queue(MyConstants.QUEUE_FANOUT_Q2);
	}
	@Bean
	public Queue fanoutQ3() {
		return new Queue(MyConstants.QUEUE_FANOUT_Q3);
	}
	@Bean
	public Queue fanoutQ4() {
		return new Queue(MyConstants.QUEUE_FANOUT_Q4);
	}
	//声明exchange
	@Bean
	public FanoutExchange setFanoutExchange() {
		return new FanoutExchange(MyConstants.EXCHANGE_FANOUT);
	}
	//声明Binding,exchange与queue的绑定关系
	@Bean
	public Binding bindQ1() {
		return BindingBuilder.bind(fanoutQ1()).to(setFanoutExchange());
	}
	@Bean
	public Binding bindQ2() {
		return BindingBuilder.bind(fanoutQ2()).to(setFanoutExchange());
	}
	@Bean
	public Binding bindQ3() {
		return BindingBuilder.bind(fanoutQ3()).to(setFanoutExchange());
	}
	@Bean
	public Binding bindQ4() {
		return BindingBuilder.bind(fanoutQ4()).to(setFanoutExchange());
	}
	
}
