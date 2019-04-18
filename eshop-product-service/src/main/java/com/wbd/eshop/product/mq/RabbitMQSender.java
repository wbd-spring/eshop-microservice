package com.wbd.eshop.product.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息发送
 * @author zgh
 *
 */
@Component
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	public void send(String queue,String message) {
		this.amqpTemplate.convertAndSend(queue, message);
	}

}
