package com.roy.springboot.consumer;

import com.rabbitmq.client.*;
import com.roy.springboot.util.MyConstants;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class DirectReceiver {
	
	//直连模式的多个消费者，会分到其中一个消费者进行消费。类似task模式
	//通过注入RabbitContainerFactory对象，来设置一些属性，相当于task里的channel.basicQos
	@RabbitListener(queues=MyConstants.QUEUE_DIRECT,containerFactory="qos_4")
	public void directReceive22(Message message, Channel channel, String messageStr) {
		System.out.println("consumer1 received message : " +messageStr);
	}

	@RabbitListener(queues=MyConstants.QUEUE_DIRECT)
	public void directReceive2(String message) {
		System.out.println("consumer2 received message : " +message);
	}
	//fanout模式接收还是只指定队列
	@RabbitListener(queues=MyConstants.QUEUE_FANOUT_Q1)
	public void fanoutReceiveq1(String message) {
		System.out.println("fanoutReceive q1 received message : " +message);
	}
	@RabbitListener(queues=MyConstants.QUEUE_FANOUT_Q2)
	public void fanoutReceiveq2(String message) {
		System.out.println("fanoutReceive q2 received message : " +message);
	}
	@RabbitListener(queues=MyConstants.QUEUE_FANOUT_Q3)
	public void fanoutReceiveq3(String message) {
		System.out.println("fanoutReceive q3 received message : " +message);
	}
	@RabbitListener(queues=MyConstants.QUEUE_FANOUT_Q4)
	public void fanoutReceiveq4(String message) {
		System.out.println("fanoutReceive q4 received message : " +message);
	}
	//topic Receiver
	//注意这个模式会有优先匹配原则。例如发送routingKey=hunan.IT,那匹配到hunan.*(hunan.IT,hunan.eco),之后就不会再去匹配*.IT(hebei.IT)
	@RabbitListener(queues=MyConstants.QUEUE_TOPIC1)
	public void topicReceiveq1(String message) {
		System.out.println("topic hunan.eco received message : " +message);
	}
	@RabbitListener(queues=MyConstants.QUEUE_TOPIC2)
	public void topicReceiveq2(String message) {
		System.out.println("topic hunan.IT received message : " +message);
	}
	@RabbitListener(queues=MyConstants.QUEUE_TOPIC3)
	public void topicReceiveq3(String message) {
		System.out.println("topic hebei.eco received message : " +message);
	}
	@RabbitListener(queues=MyConstants.QUEUE_TOPIC4)
	public void topicReceiveq4(String message) {
		System.out.println("topic hebei.IT received message : " +message);
	}
	//header receiver
	//这个模式不再根据routingKey转发，而是根据header中的匹配条件进行转发
	@RabbitListener(queues=MyConstants.QUEUE_TXTYP1)
	public void headerReceiveq1(String message) {
		System.out.println("header txTyp1 received message : " +message);
	}
	@RabbitListener(queues=MyConstants.QUEUE_BUSTYP1)
	public void headerReceiveq2(String message) {
		System.out.println("header busTyp1 received message : " +message);
	}
	@RabbitListener(queues=MyConstants.QUEUE_TXBUSTYP1)
	public void headerReceiveq3(String message) {
		System.out.println("header txbusTyp1 received message : " +message);
	}
	

	@RabbitListener(queues = MyConstants.QUEUE_QUORUM)
	public void quorumReceiver(String message){
		System.out.println("quorumReceiver received message : "+ message);
	}


//	@RabbitListener(queues = MyConstants.QUEUE_STREAM)
	public void stremReceiver(Channel channel,String message){
		try {
			channel.basicQos(100);
			Consumer myconsumer = new DefaultConsumer(channel) {
				@Override
				public void handleDelivery(String consumerTag, Envelope envelope,
										   AMQP.BasicProperties properties, byte[] body)
						throws IOException {
					System.out.println("========================");
					String routingKey = envelope.getRoutingKey();
					System.out.println("routingKey >"+routingKey);
					String contentType = properties.getContentType();
					System.out.println("contentType >"+contentType);
					long deliveryTag = envelope.getDeliveryTag();
					System.out.println("deliveryTag >"+deliveryTag);
					System.out.println("content:"+new String(body,"UTF-8"));
					// (process the message components here ...)
					//消息处理完后，进行答复。答复过的消息，服务器就不会再次转发。
					//没有答复过的消息，服务器会一直不停转发。
					channel.basicAck(deliveryTag, false);
				}
			};

			Map<String,Object> consumeParam = new HashMap<>();
			consumeParam.put("x-stream-offset","last");
			channel.basicConsume(MyConstants.QUEUE_STREAM, false,consumeParam, myconsumer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("quorumReceiver received message : "+ message);
	}
	
	
}
