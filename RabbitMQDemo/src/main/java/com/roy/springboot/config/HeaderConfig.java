package com.roy.springboot.config;

import java.util.HashMap;
import java.util.Map;

import com.roy.springboot.util.MyConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeaderConfig {

	//声明queue
	@Bean
	public Queue headQueueTxTyp1() {
		return new Queue(MyConstants.QUEUE_TXTYP1);
	}
	@Bean
	public Queue headQueueBusTyp1() {
		return new Queue(MyConstants.QUEUE_BUSTYP1);
	}
	@Bean
	public Queue headQueueTxBusTyp() {
		return new Queue(MyConstants.QUEUE_TXBUSTYP1);
	}
	//声明exchange
	@Bean
	public HeadersExchange setHeaderExchange() {
		return new HeadersExchange(MyConstants.EXCHANGE_HEADER);
	}
	//声明Binding
	//绑定header中txtyp=1的队列。header的队列匹配可以用mathces和exisits
	@Bean
	public Binding bindHeaderTxTyp1() {
		return BindingBuilder.bind(headQueueTxTyp1()).to(setHeaderExchange()).where("txTyp").matches("1");
	}
	//绑定Header中busTyp=1的队列。
	@Bean 
	public Binding bindHeaderBusTyp1() {
		return BindingBuilder.bind(headQueueBusTyp1()).to(setHeaderExchange()).where("busTyp").matches("1");
	}
	//绑定Header中txtyp=1或者busTyp=1的队列。
	@Bean 
	public Binding bindHeaderTxBusTyp1() {
		Map<String,Object> condMap = new HashMap<>();
		condMap.put("txTyp", "1");
		condMap.put("busTyp", "1");
//		return BindingBuilder.bind(headQueueTxBusTyp()).to(setHeaderExchange()).whereAny(new String[] {"txTyp","busTyp"}).exist();
		return BindingBuilder.bind(headQueueTxBusTyp()).to(setHeaderExchange()).whereAny(condMap).match();
	}
}
